package edu.kh.festival.board.model.service;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.festival.board.model.dao.FestivalDAO;
import edu.kh.festival.board.model.vo.Festival;
import edu.kh.festival.board.model.vo.Pagination9;

public class FestivalService {
	
	FestivalDAO dao = new FestivalDAO();

	/** 축제정보 Service
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> festivalInfo(int type, int cp) throws Exception {
		
		Connection conn = getConnection();
		
		// 1. 게시판이름
		String boardName = dao.selectBoardName(conn,type);
		
		// 2. 전체 축제 수 조회
		int	festivalCount = dao.getfestival(conn,type);
		
		// 3. 페이지네이션
		Pagination9 pagination = new Pagination9(cp, festivalCount);
		// 3. 축제 목록조회
		List<Festival> festival = dao.festivalList(conn,pagination,type);
		
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}
}
