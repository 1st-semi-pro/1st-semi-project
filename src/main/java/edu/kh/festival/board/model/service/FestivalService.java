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
	public Map<String, Object> festivalInfo(String query,int type, int cp,HttpServletRequest req) throws Exception {
		
		Connection conn = getConnection();
		
		// 1. 게시판이름
		String festivalName = dao.selectBoardName(conn,type);
		
		// 2. 전체 축제 수 조회
		int	festivalCount = dao.getfestival(conn,type,req);
		// 3. 페이지네이션
		Pagination9 pagination = new Pagination9(cp, festivalCount);
		
		// 3. 축제 목록조회
		List<Festival> festivalList = dao.festivalList(conn,pagination,query,type,req);
		
		// 4. 이미지 조회
		List<FestivalImage> imgList = dao.imgList(conn);
	
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("festivalName", festivalName);
		map.put("pagination", pagination);
		map.put("festivalList", festivalList);
		map.put("imgList",imgList);
		close(conn);
		
		return map;
	}
	/**
	 * 축제정보 지민ver
	 * @param type
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> festivalInfo( String query) throws Exception {
		
		Connection conn = getConnection();
		
	
		
		// 3. 축제 목록조회
		List<Festival> festivalList = dao.festivalList(conn,query);
		
		Map<String, Object> map = new HashMap<String, Object>();
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
	/*
	 * public Map<String, Object> festivalInfo(int type, int cp, int ft) throws
	 * Exception {
	 * 
	 * Connection conn = getConnection();
	 * 
	 * String festivalName = dao.selectBoardName(conn,type);
	 * 
	 * int festivalCount = dao.festivalDt(conn,type,ft);
	 * 
	 * Pagination9 pagination = new Pagination9(cp, festivalCount);
	 * 
	 * List<Festival> festivalList = dao.festivalDtList(conn, pagination, type,ft);
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * 
	 * map.put("festivalName", festivalName); map.put("pagination", pagination);
	 * map.put("festivalList", festivalList);
	 * 
	 * close(conn);
	 * 
	 * return map; }
	 */


	/** 인기순 조회 Service
	 * @param type
	 * @param cp
	 * @param pop
	 * @return map
	 * @throws Exception
	 */
	
	public Map<String, Object> festivalInfo1(int type, int cp, int pop , HttpServletRequest req) throws Exception{
		
		Connection conn = getConnection();

		String festivalName = dao.selectBoardName(conn, type);

		int festivalCount = dao.festivalPopCount(conn, type, pop , req);

		Pagination9 pagination = new Pagination9(cp, festivalCount);

		List<Festival> festivalList = dao.PopfestivalList(conn, pagination, type, pop ,req);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("festivalName", festivalName);
		map.put("pagination", pagination);
		map.put("festivalList", festivalList);

		close(conn);

		return map;
	}


	/** 축제 상세정보페이지 조회 Service
	 * @param festivalNo
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectFesitvalDetail(int festivalNo) throws Exception {
		
		Connection conn = getConnection();
		
		// 상세페이지 들어가면 조회수 +1 시키기
		int result = dao.updateReadCount(conn, festivalNo);
		
		if(result == 1) commit(conn);
		else 			rollback(conn);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = dao.selectFestivalDetail(conn, festivalNo);
		
		if(map != null) {
			
			List<FestivalImage> imgList = dao.selectImgList(conn, festivalNo);
			
			map.put("imgList", imgList);
			
		}
		
		return map;
		
	}


	/** 축제 상세페이지 조회수 증가 Service
	 * @param festivalNo
	 * @return result
	 * @throws Exception
	 */
	public int updateReadCount(int festivalNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateReadCount(conn, festivalNo);
		 
		close(conn);
		
		return result;
	}
	
	
	/** 관심축제 선택여부 조회 Service
	 * @param memberNo
	 * @param festivalNo
	 * @return result
	 * @throws Exception
	 */
	public int dibTest(int memberNo, int festivalNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.dibTest(conn, memberNo, festivalNo);
		
		close(conn);
		
		return result;
	}

	
	/** 관심축제 Insert Service
	 * @param festivalNo
	 * @return result
	 * @throws Exception
	 */
	public int insertDib(int memberNo, int festivalNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.insertDib(conn, memberNo, festivalNo);
		 
		if(result == 1) commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
	}




	/** 관심축제 Delete Service
	 * @param memberNo
	 * @param festivalNo
	 * @return result;
	 * @throws Exception
	 */
	public int deleteDib(int memberNo, int festivalNo) throws Exception {
	
		Connection conn = getConnection();
		
		int result = dao.deleteDib(conn, memberNo, festivalNo);
		 
		if(result > 0) commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
		
		
		
	}

}