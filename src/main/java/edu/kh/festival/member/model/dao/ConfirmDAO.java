package edu.kh.festival.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import static edu.kh.festival.common.JDBCTemplate.*;

public class ConfirmDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
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

}
