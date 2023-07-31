
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
		// TODO Auto-generated method stub
		return null;
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
