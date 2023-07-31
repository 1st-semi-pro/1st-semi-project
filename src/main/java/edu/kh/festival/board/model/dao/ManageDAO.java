package edu.kh.festival.board.model.dao;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.festival.board.model.vo.Pagination;
import edu.kh.festival.board.model.vo.Pagination2;
import edu.kh.festival.member.model.vo.Member;

public class ManageDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public ManageDAO() {
		
		try {
			prop = new Properties();
			
			String filePath = BoardDAO.class.getResource("/edu/kh/festival/sql/board-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();	
		}
			
	}
	
	/** 회원수 조회 DAO
	 * @param conn
	 * @param type
	 * @return 
	 */
	public int getMemberCount(Connection conn) throws Exception {
		
		int memberCount = 0;
		
		try {
			String sql = prop.getProperty("getListCount1");
			
			pstmt = conn.prepareStatement(sql);

			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			memberCount = rs.getInt(1);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return memberCount;
		
	}
	
	
	
	
	
	
	
	/** 전체 회원목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	public List<Member> selectMemberList(Connection conn, Pagination2 pagination) throws Exception {

		List<Member> mList = new ArrayList<Member>();
		
		try {
			String sql = prop.getProperty("selectMemberList");
			
			int start = ( pagination.getCurrentPage() -1) * pagination.getLimit() + 1;
			int end = start + pagination.getLimit() -1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				
				member.setMemberNo(rs.getInt("MEMBER_NO"));
				member.setMemberId(rs.getString("MEMBER_ID"));
				member.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
				member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rs.getString("MEMBER_PHONE"));
				member.setEnrollDate(rs.getDate("ENROLL_DT"));
				member.setSecessionFl(rs.getString("SECESSION_FL"));
				
				mList.add(member);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return mList;
	}

	public int getMemberCount(Connection conn, String condition) throws Exception {
		
		int memberCount = 0;
		
		try {
			String sql = prop.getProperty("getListCount1") + condition;
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberCount = rs.getInt(1);
			}
		
		}finally {
			close(rs);
			close(pstmt);
		}

		
		return memberCount;
	}

	/** 회원목록에서 검색에 만족하는 회원리스트 조회 DAO
	 * @param conn
	 * @param pagination
	 * @param condition
	 * @return mList
	 * @throws Exception
	 */
	public List<Member> searchMemberList(Connection conn, Pagination2 pagination, String condition) throws Exception {

		List<Member> mList = new ArrayList<Member>();
		
		try {
			String sql = prop.getProperty("searchMemberList1")
						+condition
						+prop.getProperty("searchMemberList2");
			int start = ( pagination.getCurrentPage() -1) * pagination.getLimit() + 1;
			int end = start + pagination.getLimit() -1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				
				member.setMemberNo(rs.getInt("MEMBER_NO"));
				member.setMemberId(rs.getString("MEMBER_ID"));
				member.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
				member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rs.getString("MEMBER_PHONE"));
				member.setEnrollDate(rs.getDate("ENROLL_DT"));
				member.setSecessionFl(rs.getString("SECESSION_FL"));
				
				mList.add(member);
			}	
			
		}finally {
			close(rs);
			close(pstmt);
		}
	
		return mList;
	}

	
	/** 관리자 회원 탈퇴 DAO
	 * @param conn
	 * @param checkRow
	 * @return result
	 * @throws Exception
	 */
	public int deleteMember(Connection conn, int checkRow) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = "UPDATE MEMBER SET SECESSION_FL = 'Y' WHERE MEMBER_NO = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, checkRow);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int deleteMember(Connection conn, String[] checkRow) throws Exception {
		int result = 0;
		
		try {
			for(int i = 0 ; i < checkRow.length ; i ++) {
			
			String sql = "UPDATE MEMBER SET SECESSION_FL = 'Y' WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
				pstmt.setString(1, checkRow[i]);
				
				result = pstmt.executeUpdate();
			}
			
			
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


	
}
