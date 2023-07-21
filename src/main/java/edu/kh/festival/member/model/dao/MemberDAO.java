package edu.kh.festival.member.model.dao;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.festival.member.model.vo.Member;

public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
		
	// 기본 생성자
	public MemberDAO() {
		try {
			prop = new Properties();
			
			String filePath =  MemberDAO.class.getResource("/edu/kh/festival/sql/member-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	/** 로그인 DAO
	 * @param mem
	 * @param conn
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem, Connection conn) throws Exception {
		
		Member loginMember = null; 
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			
			System.out.println("mem.getMemberId:: " + mem.getMemberId());
			System.out.println("mem.getMemberPw:: " + mem.getMemberPw());
			
			rs = pstmt.executeQuery();
			
			//System.out.println("rs.next() 는 : " + rs.next());
			
			//System.out.println("rs.next():::" + rs.next());
			
			
			if(rs.next()) {
				loginMember = new Member();
				
				loginMember.setMemberId(rs.getString("MEMBER_ID"));
				loginMember.setMemberPw(rs.getString("MEMBER_PW"));
				loginMember.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
				
				System.out.println("loginMember rs:: " + loginMember);
			}
			
			if(true) {
				System.out.println("true입니다");
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println("loginMember rs22:: " + loginMember);
		return loginMember;
		
	}


	/** 회원 정보 수정 DAO
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Connection conn, Member mem, String newPw) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateMember");
			
			pstmt = conn.prepareStatement(sql);
			
	/*		UPDATE MEMBER SET 
		   	MEMBER_REGION = ?,
		   	MEMBER_EMAIL = ?,
		   	MEMBER_TEL = ?,
			MEMBER_PW = ?,
			MEMBER_NICKNAME = ? 
		   	WHERE MEMBER_NO=?
			AND MEMBER_PW = ?;*/
			
			pstmt.setString(1, mem.getMemberRegion());
			pstmt.setString(2, mem.getMemberEmail());
			pstmt.setInt(3, mem.getMemberPhone());
			pstmt.setString(4, newPw);
			pstmt.setString(5, mem.getMemberNickname());
			pstmt.setInt(6, mem.getMemberNo());
			pstmt.setString(7, mem.getMemberPw());
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}


	/** 회원가입 - 아이디 중복검사 DAO
	 * @param conn
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idCheck(Connection conn, String memberId) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("joinIdCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}
		
		
}

		

