package edu.kh.festival.member.model.dao;

import static edu.kh.festival.common.JDBCTemplate.close;
import static edu.kh.festival.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
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

			String filePath = MemberDAO.class.getResource("/edu/kh/festival/sql/member-sql.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 로그인 DAO
	 * 
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

			rs = pstmt.executeQuery();

			if (rs.next()) { // 아이디 비번이 일치하는 회원이 있다면 그 회원의 값들 전부 다 가져오기
				 loginMember = new Member();

				 loginMember.setMemberNo(rs.getInt("MEMBER_NO")); 
				 loginMember.setMemberId(rs.getString("MEMBER_ID"));
				 loginMember.setMemberPw(rs.getString("MEMBER_PW"));
				 loginMember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				 loginMember.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
				 loginMember.setMemberName(rs.getString("MEMBER_NAME"));
				 loginMember.setMemberBirth(rs.getInt("MEMBER_BIRTH"));
				 loginMember.setMemberRegion(rs.getString("MEMBER_REGION"));
				 loginMember.setMemberGender(rs.getString("MEMBER_GENDER"));
				 loginMember.setMemberNationality(rs.getString("MEMBER_NT"));
				 loginMember.setMemberPhone(rs.getString("MEMBER_PHONE"));
				 loginMember.setEnrollDate(rs.getDate("ENROLL_DT"));
				 loginMember.setAdminFl(rs.getString("ADMIN_FL"));
				 loginMember.setMemberProfileImage(rs.getString("MEMBER_PROFILE"));
				 loginMember.setMemberMessage(rs.getString("MEMBER_MESSAGE"));

				 
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return loginMember;

	}

	/**
	 * 회원 정보 수정 DAO
	 * 
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Connection conn, Member mem, String newPw) throws Exception {
		int result = 0;

		try {
			String sql = prop.getProperty("updateMember");

			pstmt = conn.prepareStatement(sql);

			/*
			 * UPDATE MEMBER SET MEMBER_REGION = ?, MEMBER_EMAIL = ?, MEMBER_TEL = ?,
			 * MEMBER_PW = ?, MEMBER_NICKNAME = ? WHERE MEMBER_NO=? AND MEMBER_PW = ?;
			 */

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
		System.out.println(result);
		return result;
	}

	/**
	 * 회원가입 - 아이디 중복검사 DAO
	 * 
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

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	/**
	 * 회원가입 - 닉네임 중복 검사 DAO
	 * 
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

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} finally {
			close(rs);
			close(pstmt);

		}

		return result;

	}

	/**
	 * 회원가입 - 이메일 중복 검사 DAO
	 * 
	 * @param conn
	 * @param inputEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailCheck(Connection conn, String inputEmail) throws Exception {

		int result = 0;

		try {

			String sql = prop.getProperty("joinEmailCheck");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, inputEmail);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				result = rs.getInt(1);
			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	/**
	 * 회원가입 DAO
	 * 
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
			// VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYYMMDD'), ?, ?, ?,
			// ?, DEFAULT, DEFAULT, DEFAULT, NULL, NULL)

		} finally {
			close(pstmt);
		}

		return result;

	}

	/**
	 * 프로필 이미지 변경 DAO
	 * @param conn
	 * @param memberNo
	 * @param profileImage
	 * @return result
	 * @throws Exception
	 */
	public int updateProfileImage(Connection conn, int memberNo, String profileImage) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateProfileImage");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, profileImage);
			pstmt.setInt(2,memberNo);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 이름,아이디 일치하는 회원 조회 DAO
	 * @param conn
	 * @param memberName
	 * @param memberId
	 * @return member
	 * @throws Exception
	 */
	public Member searchMember(Connection conn, String memberName, String memberId) throws Exception{
		Member member = null;
		
		try {
			String sql = prop.getProperty("searchMember");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberNo(rs.getInt(1));
				member.setMemberId(rs.getString(2));
				member.setMemberEmail(rs.getString(4));
				member.setMemberName(rs.getString(6));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}

}
