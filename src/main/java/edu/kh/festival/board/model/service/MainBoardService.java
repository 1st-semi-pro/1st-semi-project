package edu.kh.festival.board.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.festival.common.JDBCTemplate.*;

import edu.kh.festival.board.model.dao.BoardDAO;
import edu.kh.festival.board.model.dao.MainBoardDAO;
import edu.kh.festival.board.model.vo.Board;
import edu.kh.festival.board.model.vo.BoardDetail;

public class MainBoardService {

	
	private MainBoardDAO dao = new MainBoardDAO();
	
	
	/** 메인에서 게시판1 글 목록 조회
	 * @return boardList1
	 * @throws Exception
	 */
	public List<BoardDetail> selectMainboard() throws Exception {
		
		Connection conn =  getConnection();
		
		List<BoardDetail> boardList1 = dao.selectBoardList(conn);
		
		close(conn);
		
		return boardList1;
	}

}
