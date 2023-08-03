package edu.kh.festival.board.model.dao;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;


import edu.kh.festival.board.model.vo.Festival;
import edu.kh.festival.board.model.vo.FestivalDetail;
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
		
		
		try {
			
			String festivalDate = req.getParameter("festivalDate");
			String festivalArea = req.getParameter("festivalArea");
			String festivalCat = req.getParameter("festivalCat");
			
			String sql = prop.getProperty("festivalCount");
			
			
			if(festivalDate != null && festivalDate !="") {
			   sql += "AND FESTIVAL_DT LIKE '_____" + festivalDate + "%' ";
			}
			if(festivalArea != null && festivalArea !="") {
			   sql += "AND FESTIVAL_AREA LIKE '%" + festivalArea + "%' ";
			}
			if(festivalCat != null && festivalCat !=""){
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
		
			if(festivalDate != null && festivalDate !="") {
				   sql2 += "AND FESTIVAL_DT LIKE '_____" + festivalDate + "%' ";
			}
			if(festivalArea != null && festivalArea !="") {
				   sql2 += "AND FESTIVAL_AREA LIKE '%" + festivalArea + "%' ";
			}
			if(festivalCat != null && festivalCat !=""){
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

	/** 인기순 조회 DAO
	 * @param conn
	 * @param type
	 * @param pop
	 * @return festivalCount
	 * @throws Exception
	 */
	public int festivalPopCount(Connection conn, int type, int pop ,HttpServletRequest req) throws Exception{
		
		int festivalCount = 0;
		
		String festivalDate = req.getParameter("festivalDate");
		String festivalArea = req.getParameter("festivalArea");
		String festivalCat = req.getParameter("festivalCat");
		
		try {

			String sql = prop.getProperty("festivalPop");
			
			if(festivalDate != null && festivalDate !="") {
				   sql += "AND FESTIVAL_DT LIKE '_____" + festivalDate + "%' ";
			}
			if(festivalArea != null && festivalArea !="") {
				   sql += "AND FESTIVAL_AREA LIKE '%" + festivalArea + "%' ";
			}
			if(festivalCat != null && festivalCat !=""){
				   sql += "AND FESTIVAL_CAT LIKE '%" + festivalCat + "%' ";
			}

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
	public List<Festival> PopfestivalList(Connection conn, Pagination9 pagination, int type, int pop ,HttpServletRequest req) throws Exception {
		
		
		List<Festival> festivalList = new ArrayList<Festival>();
		
		String festivalDate = req.getParameter("festivalDate");
		String festivalArea = req.getParameter("festivalArea");
		String festivalCat = req.getParameter("festivalCat");
		
		try {
			
			
			
			String sql1 = prop.getProperty("PopfestivalList1");
			String sql2 = prop.getProperty("PopfestivalList2");
			String sql3 = prop.getProperty("PopfestivalList3");
			
			if(festivalDate != null && festivalDate !="") {
				   sql2 += "AND FESTIVAL_DT LIKE '_____" + festivalDate + "%' ";
			}
			if(festivalArea != null && festivalArea !="") {
				   sql2 += "AND FESTIVAL_AREA LIKE '%" + festivalArea + "%' ";
			}
			if(festivalCat != null && festivalCat !=""){
				   sql2 += "AND FESTIVAL_CAT LIKE '%" + festivalCat + "%' ";
			}
			
			String sql = sql1 + sql2 + sql3;
			
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

	
	/** 축제 상세 페이지 조회 DAO
	 * @param festivalNo
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectFestivalDetail(Connection conn, int festivalNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		Festival fes = null;
		FestivalDetail fesDt = null;
		
		try {
			
			String sql = prop.getProperty("selectFestivalDetail");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, festivalNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				fes = new Festival();
				fesDt = new FestivalDetail();
				
				fes.setFestivalNo(rs.getInt(1));
				fes.setFestivalTitle(rs.getString(2));
				fes.setFestivalContent(rs.getString(3));
				fes.setFestivalDate(rs.getString(4));
				fes.setReadCount(rs.getInt(5));
				fes.setBoardCode(rs.getInt(6));
				fes.setFestivalArea(rs.getString(7));
				fes.setFestivalCat(rs.getString(8));
				
				fesDt.setFestivalNo(rs.getInt(1));
				fesDt.setFestivalContent(rs.getString(9));
				fesDt.setFestivalDetailInfo(rs.getString(10));
				
				map.put("festival", fes);
				map.put("festivalDetail", fesDt);
			}
			
		}finally {
			close(pstmt);
		}
		
		return map;
	}

	/** 축제 상세조회 페이지 이미지 여러 개씩 갖고오기 DAO
	 * @param conn
	 * @param festivalNo
	 * @return result
	 * @throws Exception
	 */
	public List<FestivalImage> selectImgList(Connection conn, int festivalNo) throws Exception {
		
		List<FestivalImage> imgList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectImgList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, festivalNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				FestivalImage image = new FestivalImage();
				
				image.setImageNo(rs.getInt(1));
				image.setImageReName(rs.getString(2));
				image.setImageLevel(rs.getInt(3));
				
				imgList.add(image);
				
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return imgList;
	}

	/** 축제 상세페이지 조회수 증가 DAO
	 * @param conn
	 * @param festivalNo
	 * @return result
	 * @throws Exception
	 */
	public int updateReadCount(Connection conn, int festivalNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateReadCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, festivalNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

	
	/** 관심축제 Update DAO
	 * @param conn
	 * @param festivalNo
	 * @return result
	 * @throws Exception
	 */
	public int insertDib(Connection conn, int memberNo, int festivalNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertDib");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);

			pstmt.setInt(2, festivalNo);
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);

		}finally {
			
			close(pstmt);
			
		}
		
		return result;
		
	}

}
