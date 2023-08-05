package edu.kh.festival.board.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.kh.festival.common.JDBCTemplate.*;

import edu.kh.festival.board.model.dao.BoardDAO;
import edu.kh.festival.board.model.dao.MainBoardDAO;
import edu.kh.festival.board.model.vo.Board;
import edu.kh.festival.board.model.vo.BoardDetail;
import edu.kh.festival.board.model.vo.Festival;
import edu.kh.festival.board.model.vo.Pagination;


public class MainBoardService {

	
	private MainBoardDAO dao = new MainBoardDAO();
	
	
	/** 메인에서 게시판1 최신글 목록 조회 Service
	 * @return boardList1
	 * @throws Exception
	 */
	public List<BoardDetail> selectMainboard() throws Exception {
		
		Connection conn =  getConnection();
		
		List<BoardDetail> boardList1 = dao.selectBoardList(conn);
		
		
		return boardList1;
	}


	/** 메인에서 게시판2 최신글 목록 조회 Service
	 * @return boardList2
	 * @throws Exception
	 */
	public List<BoardDetail> selectMainboard2() throws Exception {
		Connection conn =  getConnection();
		
		List<BoardDetail> boardList2 = dao.selectBoardList2(conn);
		
		
		return boardList2;
	}


	/** 메인에서 게시판3 최신글 목록 조회 Service
	 * @return boardList3
	 * @throws Exception
	 */
	public List<BoardDetail> selectMainboard3() throws Exception {
		Connection conn =  getConnection();
		
		List<BoardDetail> boardList3 = dao.selectBoardList3(conn);
		
		close(conn);
		
		return boardList3;
	}

	/** 검색 결과 조회 Service
	 * @param type
	 * @param cp
	 * @param key
	 * @param query
	 * @return
	 */
	public Map<String, Object> searchResultList(String query) throws Exception{
		
		Connection conn = getConnection();
		
		// 2. SQL 조건절에 추가될 구문 가공
		//String condition = null; // 조건
		int type = 0; // 조건
		
		
		//condition=" AND (BOARD_CONTENT LIKE '%"+query+"%' OR BOARD_TITLE LIKE '%"+query+"%') ";  break;
		
		
		
		String boardName = null; 
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		for( int i=2; i<5; i++) {
	         boardName = dao.selectBoardName(conn, i);
	         List<Board> boardList = dao.searchBoardList(conn, i, query);
	         map.put("boardName"+i, boardName);
	         map.put("boardList"+i, boardList);
	      }
		
		
		close(conn);
		return map;
	}


	public List<Festival> selectFestival1() throws Exception {
		Connection conn =  getConnection();
		
		List<Festival> festivalList1 = dao.selectFestival1(conn);
		
		
		return festivalList1;
	}

	
}
