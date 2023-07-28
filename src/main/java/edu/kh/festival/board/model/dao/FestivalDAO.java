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

import edu.kh.festival.board.model.vo.Festival;
import edu.kh.festival.board.model.vo.Pagination9;


public class FestivalDAO {
	
	   private Statement stmt;
	   private PreparedStatement pstmt;
	   private ResultSet rs;
	   
	   private Properties prop;
	   
	   public FestivalDAO() {
	      try {
	         prop = new Properties();
	         
	         String filePath = FestivalDAO.class.getResource("/edu/kh/festival/sql/festival-sql.xml").getPath();
	         
	         prop.loadFromXML(new FileInputStream(filePath));
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	   }

	/** 게시판이름 조회 DAO
	 * @param conn
	 * @param type
	 * @return boardName
	 * @throws Exception
	 */
	public String selectBoardName(Connection conn, int type) throws Exception {

		String boardName = null;

		try {
			String sql = prop.getProperty("BoardName");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				boardName = rs.getString(1);
			}

		} finally {
			close(rs);
			close(stmt);
		}

		return boardName;
	}

	/** 축제게시글 조회 DAO
	 * @param conn
	 * @param type
	 * @return festivalCount
	 * @throws Exception
	 */
	public int getfestival(Connection conn, int type) throws Exception {
		
		int festivalCount = 0;

		try {
			String sql = prop.getProperty("festivalCount");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				festivalCount = rs.getInt(1);
			}

		} finally {
			close(rs);
			close(stmt);
		}

		return festivalCount;
	}

	/** 축제 범위 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<Festival> festivalList(Connection conn, Pagination9 pagination, int type) throws Exception {
		
		List<Festival> festival = new ArrayList<Festival>();
		
		return festival;
	}

}
