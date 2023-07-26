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
			
			
			if(rs.next()) {
				loginMember = new Member();
				
				loginMember.setMemberId(rs.getString("MEMBER_ID"));
				loginMember.setMemberPw(rs.getString("MEMBER_PW"));
				
				
				
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
			pstmt.setString(3, mem.getMemberPhone());
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


	/** 회원가입 - 닉네임 중복 검사 DAO
	 * @param conn
	 * @param memberNickname
	 * @return
	 */
	public int nicknameCheck(Connection conn, String memberNickname) throws Exception {

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("joinNickCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberNickname);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

// 회원가입 member 테이블 변경하면 sql문 ? 개수랑 위치홀더 개수 변경해야함
	
	/** 회원가입 DAO
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int join(Connection conn, Member mem) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("join");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			pstmt.setString(3, mem.getMemberEmail());
			pstmt.setString(4, mem.getMemberNickname());
			pstmt.setString(5, mem.getMemberName());
			pstmt.setInt(6, mem.getMemberBirth());
			pstmt.setString(7, mem.getMemberRegion());
			pstmt.setString(8, mem.getMemberGender());
			pstmt.setString(9, mem.getMemberNationality());
			pstmt.setString(10, mem.getMemberPhone());
			
			result = pstmt.executeUpdate();
			
			// 위치홀더 처음부터 id-pw-email-nick-nm-birth-region-gender-nt-phone
			// INSERT INTO MEMBER 
			// VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYYMMDD'), ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT, NULL, NULL)
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
		
		
	}
		
		
}

		

