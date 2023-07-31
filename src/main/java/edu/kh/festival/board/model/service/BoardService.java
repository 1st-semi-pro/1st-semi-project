package edu.kh.festival.board.model.service;

import static edu.kh.festival.common.JDBCTemplate.getConnection;
import static edu.kh.festival.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.festival.common.Util;
import edu.kh.festival.board.model.dao.BoardDAO;
import edu.kh.festival.board.model.vo.Board;
import edu.kh.festival.board.model.vo.BoardDetail;
import edu.kh.festival.board.model.vo.BoardImage;
import edu.kh.festival.board.model.vo.Pagination;

public class BoardService {

	private BoardDAO dao = new BoardDAO();

	/** 게시글 목록 조회 Service
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectBoardList(int type, int cp) throws Exception{
		
		Connection conn = getConnection();
		
		// 1. 게시판 이름 조회 DAO호출
		String boardName = dao.selectBoardName(conn,type);
		
		// 2-1. 특정 게시판 전체 게시글 수 조회 DAO 호출
		int listCount = dao.getListCount(conn,type);
		
		// 2-2. 전체 게시글 수 + 현재 페이지(cp)를 이용해 페이지네이션 객체 생성
		Pagination pagination = new Pagination(cp,listCount);
		
		// 3. 게시글 목록 조회
		List<Board> boardList = dao.selectBoardList(conn,pagination,type);
		
		// 4. Map 객체를 생성하여 1,2,3 결과 객체를 모두 저장
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardName", boardName);
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		close(conn);
		
		return map;
	}

	/** 게시글 상세페이지 service
	 * @param boardNo
	 * @return detail
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		BoardDetail detail = dao.selectBoardDetail(conn, boardNo);
		
		// 이미지 조회
		if(detail != null) {
			
			List<BoardImage> imageList = dao.selectImageList(conn, boardNo);
			
			detail.setImageList(imageList);
		} 
		
		close(conn);
		
		return detail;
		
		
	}
	
	/** 게시글 삭제 Service
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, boardNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 게시글 삽입 DAO
	 * @param detail
	 * @param imageList
	 * @param boardCode
	 * @return boardNo
	 */

	public int insertBoard(BoardDetail detail, List<BoardImage> imageList, int boardCode) throws Exception {
		Connection conn = getConnection();
		
		int boardNo = dao.nextBoardNo(conn);
		
		detail.setBoardNo(boardNo);
		
		detail.setBoardTitle(Util.XSSHandling( detail.getBoardTitle() ) );
		detail.setBoardContent(Util.XSSHandling( detail.getBoardContent() ) );
		detail.setBoardContent(Util.newLineHandling( detail.getBoardContent() ) );
		
		int result = dao.insertBoard(conn, detail, boardCode);
		
		if (result > 0 ) {
			// 이미지
		}
		
		if(result > 0) { 
			commit(conn);
		
		}else { // 2, 3 번에서 한 번이라도 실패한 경우 // 위에서 result == 0 일떄 break;
			rollback(conn);
			boardNo = 0; // 게시글 번호를 0으로 바꿔서 실패했음을 컨트롤러로 전달해준다.
		}
		
		close(conn);
		
		return boardNo;
		
	}

	

	/** 게시글 수정 Service
	 * @param detail
	 * @param imageList
	 * @param deleteList
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(BoardDetail detail, List<BoardImage> imageList, String deleteList) throws Exception {
		
		Connection conn = getConnection();
		
		detail.setBoardTitle(Util.XSSHandling(detail.getBoardTitle()));
		detail.setBoardContent(Util.XSSHandling(detail.getBoardContent()));
		detail.setBoardContent(Util.newLineHandling(detail.getBoardContent()));
		
		int result = dao.updateBoard(conn, detail);
		
		if(result == 1) {//이미지부분
			}
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
		
		
	}
	
	
	
	
	
}