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

import javax.servlet.http.HttpServletRequest;

import edu.kh.festival.board.model.vo.Festival;
import edu.kh.festival.board.model.vo.FestivalImage;
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

	/** 축제게시글 조회 DAO / 축제검색 DAO
	 * @param conn
	 * @param type
	 * @return festivalCount
	 * @throws Exception
	 */
	public int getfestival(Connection conn, int type,HttpServletRequest req) throws Exception {
		
		int festivalCount = 0;
		
		String festivalDate = req.getParameter("festivalDate");
		String festivalArea = req.getParameter("festivalArea");
		String festivalCat = req.getParameter("festivalCat");
		
		try {
			
			String sql = prop.getProperty("festivalCount");
	
			if(festivalDate != null) {
			   sql += "AND FESTIVAL_DT LIKE '%_____" + festivalDate + "%' ";
			}
			if(festivalArea != null) {
			   sql += "AND FESTIVAL_AREA LIKE '%" + festivalArea + "%' ";
			}
			if(festivalCat != null){
			   sql += "AND FESTIVAL_CAT LIKE '%" + festivalCat + "%' ";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				festivalCount = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}

		return festivalCount;
	}

	/** 축제 범위 목록 조회 DAO / 특정검색 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<Festival> festivalList(Connection conn, Pagination9 pagination, int type, HttpServletRequest req) throws Exception {
		
		List<Festival> festivalList = new ArrayList<Festival>();
		
		String festivalDate = req.getParameter("festivalDate");
		String festivalArea = req.getParameter("festivalArea");
		String festivalCat = req.getParameter("festivalCat");
		
		
		try {
		
			String sql1 = prop.getProperty("festivalList1");
			String sql2 = prop.getProperty("festivalList2");
			String sql3 = prop.getProperty("festivalList3");
			
			
		
			if(festivalDate != null) {
				   sql2 += "AND FESTIVAL_DT LIKE '%_____" + festivalDate + "%' ";
			}
			if(festivalArea != null) {
				   sql2 += "AND FESTIVAL_AREA LIKE '%" + festivalArea + "%' ";
			}
			if(festivalCat != null){
				   sql2 += "AND FESTIVAL_CAT LIKE '%" + festivalCat + "%' ";
			}
			
			String sql= sql1+sql2+sql3;
			
			// BETWEEN 구문에 들어갈 범위 계산
			int start = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;

			int end = start + pagination.getLimit() - 1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Festival festival = new Festival();
				
				festival.setFestivalNo(rs.getInt("FESTIVAL_NO"));
				festival.setFestivalTitle(rs.getString("FESTIVAL_TITLE"));
				festival.setFestivalContent(rs.getString("FESTIVAL_CT"));
				festival.setFestivalDate(rs.getString("FESTIVAL_DT"));
				festival.setReadCount(rs.getInt("READ_COUNT"));
				festival.setFestivalArea(rs.getString("FESTIVAL_AREA"));
				festival.setFestivalCat(rs.getString("FESTIVAL_CAT"));
				
				
				festivalList.add(festival);
				
			}
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		return festivalList;
	}

	/** 축제일순 조회 DAO
	 * @param conn
	 * @param type
	 * @param ft
	 * @return festivalCount
	 * @throws Exception
	 */
	public int festivalDt(Connection conn, int type, int ft) throws Exception {
		
		int festivalCount = 0;
		
		try {
			
			String sql = prop.getProperty("festivalDt");
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				festivalCount++;
			}

		} finally {
			close(rs);
			close(stmt);
		}
		
		System.out.println("festivalCount == " + festivalCount);
		return festivalCount;
	}

	/** 축제일순 List 조회 DAO
	 * @param conn
	 * @param pagination
	 * @param type
	 * @param ft
	 * @return
	 * @throws Exception
	 */
	public List<Festival> festivalDtList(Connection conn, Pagination9 pagination, int type, int ft) throws Exception {
		
			List<Festival> festivalList = new ArrayList<Festival>();
			
			
			try {
				
				String sql = prop.getProperty("DtfestivalList");
				
				int start = (pagination.getCurrentPage()-1)* pagination.getLimit()+1;
		         
		        int end = start + pagination.getLimit()-1;
		        
		        pstmt = conn.prepareStatement(sql);
		        
		        pstmt.setInt(1, start);
		        pstmt.setInt(2, end);
		        
		        rs = pstmt.executeQuery();
		        
		        while(rs.next()) {
		        	Festival festival = new Festival();
		        	
		        	festival.setFestivalNo(rs.getInt("FESTIVAL_NO"));
					festival.setFestivalTitle(rs.getString("FESTIVAL_TITLE"));
					festival.setFestivalContent(rs.getString("FESTIVAL_CT"));
					festival.setFestivalDate(rs.getString("FESTIVAL_DT"));
					festival.setReadCount(rs.getInt("READ_COUNT"));
					
					
					festivalList.add(festival);
					
		        }
				
				
			} finally {
				
				close(rs);
				close(pstmt);
				
				
			}
			
		return festivalList;
	}

	/** 인기순 조회 DAO
	 * @param conn
	 * @param type
	 * @param pop
	 * @return festivalCount
	 * @throws Exception
	 */
	public int festivalPopCount(Connection conn, int type, int pop) throws Exception{
		
		int festivalCount = 0;

		try {

			String sql = prop.getProperty("festivalPop");

			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				festivalCount++;
			}

		} finally {
			close(rs);
			close(stmt);
		}
		
		return festivalCount;
	}

	/** 인기순 목록조회 DAO
	 * @param conn
	 * @param pagination
	 * @param type
	 * @param pop
	 * @return festivalList
	 * @throws Exception
	 */
	public List<Festival> PopfestivalList(Connection conn, Pagination9 pagination, int type, int pop) throws Exception {
		
		
		List<Festival> festivalList = new ArrayList<Festival>();
		
		try {
			
			String sql = prop.getProperty("PopfestivalList");
			
			int start = (pagination.getCurrentPage()-1)* pagination.getLimit()+1;
	         
	        int end = start + pagination.getLimit()-1;
	        
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, start);
	        pstmt.setInt(2, end);
	        
	        rs = pstmt.executeQuery();
	        
	        while(rs.next()) {
	        	Festival festival = new Festival();
	        	
	        	festival.setFestivalNo(rs.getInt("FESTIVAL_NO"));
				festival.setFestivalTitle(rs.getString("FESTIVAL_TITLE"));
				festival.setFestivalContent(rs.getString("FESTIVAL_CT"));
				festival.setFestivalDate(rs.getString("FESTIVAL_DT"));
				festival.setReadCount(rs.getInt("READ_COUNT"));
				
				
				festivalList.add(festival);
				
	        }
			
		} finally {
			
			close(rs);
			close(pstmt);
			
			
		}
		
	return festivalList;
	}
	

}
