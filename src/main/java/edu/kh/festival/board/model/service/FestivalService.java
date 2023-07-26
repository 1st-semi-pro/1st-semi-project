package edu.kh.festival.board.model.service;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import edu.kh.festival.board.model.dao.FestivalDAO;

public class FestivalService {
	
	FestivalDAO dao = new FestivalDAO();

	/** 축제정보 Service
	 * @param type
	 * @param cp
	 * @return
	 * @throws EnumConstantNotPresentException
	 */
	public Map<String, Object> festivalInfo(int type, int cp) throws EnumConstantNotPresentException {
		
		Connection conn = getConnection();
		
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}
}
