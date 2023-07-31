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

import edu.kh.festival.board.model.vo.Board;
import edu.kh.festival.board.model.vo.BoardDetail;
import edu.kh.festival.board.model.vo.BoardImage;
import edu.kh.festival.board.model.vo.Pagination;
import edu.kh.festival.member.model.vo.Member;

/**
 * @author user1
 *
 */
/**
 * @author user1
 *
 */
public class BoardDAO {
   
   private Statement stmt;
   private PreparedStatement pstmt;
   private ResultSet rs;
   
   private Properties prop;
   
   public BoardDAO() {
      try {
         prop = new Properties();
         
         String filePath = BoardDAO.class.getResource("/edu/kh/festival/sql/board-sql.xml").getPath();
         
         prop.loadFromXML(new FileInputStream(filePath));
      }catch(Exception e) {
         e.printStackTrace();
      }
   }

	/** 게시글 이름 조회 DAO
	 * @param conn
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public String selectBoardName(Connection conn, int type) throws Exception {
		String boardName = null;
		
		try {
			String sql = prop.getProperty("selectBoardName");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				boardName = rs.getString(1);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return boardName;
	}

	/** 특정 게시판 전체 게시글 수 조회 DAO
	 * @param conn
	 * @param type
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, int type) throws Exception {
			int listCount = 0;
		
		try {
			String sql = prop.getProperty("getListCount");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				listCount = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return listCount;
	}

	/** 특정 게시판에서 일정한 범위의 목록 조회
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn, Pagination pagination, int type) throws Exception {
		
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			String sql = prop.getProperty("selectBoardList");
			
			// BETWEEN 구문에 들어갈 범위 계산
			int start = ( pagination.getCurrentPage()-1) * pagination.getLimit() + 1;
			
			int end = start + pagination.getLimit() -1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				
				boardList.add(board);
				
			}
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		return boardList;
	}
	
	
	/** 게시글 상세조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return detail
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(Connection conn, int boardNo) throws Exception {
		
		BoardDetail detail = null;
		
		try {
			String sql  = prop.getProperty("selectBoardDetail");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				detail = new BoardDetail();
				
	            detail.setBoardNo(rs.getInt(1));
	            detail.setBoardTitle(rs.getString(2));
	            detail.setBoardContent(rs.getString(3));
	            detail.setCreateDate(rs.getString(4));
	            detail.setUpdateDate(rs.getString(5));
	            detail.setReadCount(rs.getInt(6));
	            detail.setMemberNickname(rs.getString(7));
	            detail.setProfileImage(rs.getString(8));
	            detail.setMemberNo(rs.getInt(9));
	            detail.setBoardCd(rs.getString(10));
				
				
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return detail;
		
	}

	
	
	/** 게시글에 첨부된 이미지 리스트 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return imageList
	 * @throws Exception
	 */
	public List<BoardImage> selectImageList(Connection conn, int boardNo) throws Exception {
		
		List<BoardImage> imageList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectImageList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) { // 여러 행이 나옴 이미지 개수마다 한 행
				
				BoardImage image = new BoardImage();
	            
	            image.setImageNo(rs.getInt(1));
	            image.setImageLevel(rs.getInt(2));
	            image.setImageReName(rs.getString(3));
	            image.setImageOriginal(rs.getString(4));
	            image.setBoardNo(rs.getInt(5));
				
	            imageList.add(image); // private List<BoardImage> imageList; 
	            
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return imageList;
	}
		
		
	

	
	/** 게시글 삭제 DAO
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

	/** 다음 게시글 번호 조회 DAO
	 * @param conn
	 * @return boardNo
	 * @throws Exception
	 */
	public int nextBoardNo(Connection conn) throws Exception {
		
		int boardNo = 0;
		
		try {
			
			String sql = prop.getProperty("nextBoardNo");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				boardNo = rs.getInt(1);
			}
			
		}finally {
			
			close(rs);
			close(stmt);
			
		}
		
		return boardNo;
	}

	
	/** 게시글 삽입 DAO
	 * @param conn
	 * @param detail
	 * @param boardCode
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, BoardDetail detail, int boardCode) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, detail.getBoardNo());
	        pstmt.setString(2, detail.getBoardTitle());
	        pstmt.setString(3, detail.getBoardContent());
	        pstmt.setInt(4, detail.getMemberNo());
	        pstmt.setInt(5, boardCode);
	        
	        result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
	/** 게시글 수정 DAO
	 * @param conn
	 * @param detail
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(Connection conn, BoardDetail detail) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, detail.getBoardTitle());
			pstmt.setString(2, detail.getBoardContent());
			pstmt.setInt(3, detail.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		}finally {

			close(pstmt);
			
		}
		
		return result;
	}

	/** 게시글 이미지 삽입 DAO
	 * @param conn
	 * @param image
	 * @return
	 * @throws Exception
	 */
	public int insertBoardImage(Connection conn, BoardImage image) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertBoardImage");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, image.getImageLevel());
			pstmt.setString(2, image.getImageReName());
	        pstmt.setString(3, image.getImageOriginal());
	        pstmt.setInt(4, image.getBoardNo());
			
			result = pstmt.executeUpdate();
			
			
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

	/** 게시글 이미지 수정 DAO
	 * @param conn
	 * @param img
	 * @return result
	 * @throws Exception
	 */
	public int updateBoardImage(Connection conn, BoardImage img) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateBoardImage");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, img.getImageReName());
			pstmt.setString(2, img.getImageOriginal());
			pstmt.setInt(3, img.getBoardNo());
			pstmt.setInt(4, img.getImageLevel());
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

	/** 게시글 수정 - 이미지 삭제 DAO
	 * @param conn
	 * @param deleteList
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoardImage(Connection conn, String deleteList, int boardNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteBoardImage") + deleteList + ")";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}

		return result;
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
