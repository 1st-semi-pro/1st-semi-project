package edu.kh.festival.member.model.dao;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class AssessDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public AssessDAO() {
		try {
			prop = new Properties();
			
			String filePath = AssessDAO.class.getResource("/edu/kh/festival/sql/assess-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/** 좋아요 중복 검사 DAO
	 * @param conn
	 * @param recNo
	 * @param goodNo
	 * @return result
	 * @throws Exception
	 */
	public int checkAssess(Connection conn, int recNo, int goodNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql =  prop.getProperty("checkAssess");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, recNo);
			pstmt.setInt(2, goodNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1); // 1번 컬럼 결과를 result에 대입
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	/**좋아요 눌렀을 때 행 추가 DAO
	 * @param conn
	 * @param recNo
	 * @param goodNo
	 * @return result
	 * @throws Exception
	 */
	public int addAssess(Connection conn, int recNo, int goodNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql =  prop.getProperty("addAssess");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, recNo);
			pstmt.setInt(2, goodNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}



	/** 좋아요 기록 삭제 DAO
	 * @param conn
	 * @param recNo
	 * @param goodNo
	 * @return
	 * @throws Exception
	 */
	public int deleteAssess(Connection conn, int recNo, int goodNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteAssess");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, recNo);
			pstmt.setInt(2, goodNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	/** 좋아요 횟수 조회 DAO
	 * @param conn
	 * @param goodNo
	 * @return result
	 * @throws Exception
	 */
	public int selectAssess(Connection conn, int goodNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("selectAssess");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, goodNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1); // 1번 컬럼 결과를 result에 대입
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}



	/**신고하기 중복 검사 DAO
	 * @param conn
	 * @param recNo
	 * @param goodNo
	 * @return
	 */
	public int checkAssess1(Connection conn, int recNo, int badNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql =  prop.getProperty("checkAssess1");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, recNo);
			pstmt.setInt(2, badNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1); // 1번 컬럼 결과를 result에 대입
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}


 
	/** 신고하기 기록 추가 DAO
	 * @param conn
	 * @param recNo
	 * @param badNo
	 * @return result
	 * @throws Exception
	 */
	public int addAssess1(Connection conn, int recNo, int badNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql =  prop.getProperty("addAssess1");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, recNo);
			pstmt.setInt(2, badNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}



	/** 신고하기 기록 삭제 DAO
	 * @param conn
	 * @param recNo
	 * @param badNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteAssess1(Connection conn, int recNo, int badNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteAssess1");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, recNo);
			pstmt.setInt(2, badNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	/** 신고하기 개수 조회 DAO
	 * @param conn
	 * @param badNo
	 * @return
	 * @throws Exception
	 */
	public int selectAssess1(Connection conn, int badNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("selectAssess1");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, badNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1); // 1번 컬럼 결과를 result에 대입
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
		
		
	}
	



	
}
