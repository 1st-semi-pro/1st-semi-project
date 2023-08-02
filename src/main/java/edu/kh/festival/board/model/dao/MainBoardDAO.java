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

public class MainBoardDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop; // sql을 읽어와 저장
	
	// 기본 생성자
	public MainBoardDAO() {
		
	}
	
	
	

	/** 메인에서 게시판1 최신글 목록 조회 DAO
	 * @param conn
	 * @return boardList1
	 * @throws Exception
	 */
	public List<BoardDetail> selectBoardList(Connection conn) throws Exception {
		
		List<BoardDetail> boardList1 = new ArrayList<BoardDetail>();
		
		try {
			
			String sql = "SELECT * FROM (SELECT * FROM BOARD WHERE BOARD_CD = 2	AND BOARD_ST = 'N' ORDER BY BOARD_NO DESC) WHERE ROWNUM BETWEEN 1 AND 10";
			
			stmt = conn.createStatement();
			
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardDetail board = new BoardDetail();
				
				board.setBoardNo( rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setBoardContent(rs.getString(3));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setMemberNo(rs.getInt("MEMBER_NO"));
				board.setBoardCd(rs.getString("BOARD_CD"));
				
				boardList1.add(board);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		
		
		return boardList1;
	}



	/** 메인에서 게시판2 최신글 목록 조회 DAO
	 * @param conn
	 * @return boardList2
	 * @throws Exception
	 */
	public List<BoardDetail> selectBoardList2(Connection conn) throws Exception {
		List<BoardDetail> boardList2 = new ArrayList<BoardDetail>();
		
		try {
			
			String sql = "SELECT * FROM (SELECT * FROM BOARD WHERE BOARD_CD = 3	AND BOARD_ST = 'N' ORDER BY BOARD_NO DESC) WHERE ROWNUM BETWEEN 1 AND 10";
			
			stmt = conn.createStatement();
			
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardDetail board = new BoardDetail();
				
				board.setBoardNo( rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setBoardContent(rs.getString(3));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setMemberNo(rs.getInt("MEMBER_NO"));
				board.setBoardCd(rs.getString("BOARD_CD"));
				
				boardList2.add(board);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		
		
		return boardList2;
	}



	/** 메인에서 게시판3 최신글 목록 조회 DAO
	 * @param conn
	 * @return boardList3
	 * @throws Exception
	 */
	public List<BoardDetail> selectBoardList3(Connection conn) throws Exception {
		List<BoardDetail> boardList3 = new ArrayList<BoardDetail>();
		
		try {
			
			String sql = "SELECT * FROM (SELECT * FROM BOARD WHERE BOARD_CD = 4	AND BOARD_ST = 'N' ORDER BY BOARD_NO DESC) WHERE ROWNUM BETWEEN 1 AND 10";
			
			stmt = conn.createStatement();
			
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardDetail board = new BoardDetail();
				
				board.setBoardNo( rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setBoardContent(rs.getString(3));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setMemberNo(rs.getInt("MEMBER_NO"));
				board.setBoardCd(rs.getString("BOARD_CD"));
				
				boardList3.add(board);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		
		
		return boardList3;
	}

}
