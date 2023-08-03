package edu.kh.festival.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.festival.member.model.vo.Member;

import static edu.kh.festival.common.JDBCTemplate.*;

public class ConfirmDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	
	
	/** 비밀번호 확인 DAO
	 * @param conn
	 * @param memberId
	 * @param inputPw
	 * @return result
	 * @throws Exception
	 */
	public int confirmMember(Connection conn, String memberId, String inputPw) throws Exception {

		int result = 0;
		
		try {
			String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberId);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}



	/** 이름과 이메일이 일치하는 회원있는지 확인 DAO
	 * @param conn
	 * @param inputName
	 * @param inputEmail
	 * @return member
	 * @throws Exception
	 */
	public Member checkEmail(Connection conn, String inputName, String inputEmail) throws Exception {
		
		Member member = new Member();
		
		
		try {
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME = ? AND MEMBER_EMAIL = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputName);
			pstmt.setString(2, inputEmail);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member.setMemberId(rs.getString("MEMBER_ID"));
				
			}
		
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}

}
