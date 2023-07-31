package edu.kh.festival.board.model.service;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import edu.kh.festival.board.model.dao.FestivalDAO;
import edu.kh.festival.board.model.vo.Festival;
import edu.kh.festival.board.model.vo.FestivalImage;
import edu.kh.festival.board.model.vo.Pagination9;

public class FestivalService {
	
	FestivalDAO dao = new FestivalDAO();

	/** 축제정보 Service / 축제검색 Service
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> festivalInfo(int type, int cp,HttpServletRequest req) throws Exception {
		
		Connection conn = getConnection();
		
		// 1. 게시판이름
		String festivalName = dao.selectBoardName(conn,type);
		
		// 2. 전체 축제 수 조회
		int	festivalCount = dao.getfestival(conn,type,req);
		
		// 3. 페이지네이션
		Pagination9 pagination = new Pagination9(cp, festivalCount);
		
		// 3. 축제 목록조회
		List<Festival> festivalList = dao.festivalList(conn,pagination,type,req);
	
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("festivalName", festivalName);
		map.put("pagination", pagination);
		map.put("festivalList", festivalList);
		
		close(conn);
		
		return map;
	}

	
	/** 축제일순 조회Service
	 * @param type
	 * @param cp
	 * @param ft
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> festivalInfo(int type, int cp, int ft) throws Exception {
		
		Connection conn = getConnection();
		
		String festivalName = dao.selectBoardName(conn,type);
		
		int	festivalCount = dao.festivalDt(conn,type,ft);
		
		Pagination9 pagination = new Pagination9(cp, festivalCount);
		
		List<Festival> festivalList = dao.festivalDtList(conn, pagination, type,ft);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("festivalName", festivalName);
		map.put("pagination", pagination);
		map.put("festivalList", festivalList);

		close(conn);
		
		return map;
	}


	/** 인기순 조회 Service
	 * @param type
	 * @param cp
	 * @param pop
	 * @return map
	 * @throws Exception
	 */
	
	public Map<String, Object> festivalInfo1(int type, int cp, int pop) throws Exception{
		
		Connection conn = getConnection();

		String festivalName = dao.selectBoardName(conn, type);

		int festivalCount = dao.festivalPopCount(conn, type, pop);

		Pagination9 pagination = new Pagination9(cp, festivalCount);

		List<Festival> festivalList = dao.PopfestivalList(conn, pagination, type, pop);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("festivalName", festivalName);
		map.put("pagination", pagination);
		map.put("festivalList", festivalList);

		close(conn);

		return map;
	}
}
