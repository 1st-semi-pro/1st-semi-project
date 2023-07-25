package edu.kh.festival.board.model.service;


import static edu.kh.festival.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.festival.board.model.dao.ManageDAO;
import edu.kh.festival.member.model.vo.Member;

public class ManageService {
	
	private ManageDAO dao = new ManageDAO();

	public Map<String, Object> selectAllMember(int type, int cp) {
		
		Connection conn = getConnection();
		
		int memberCount = dao.getMemberCount(conn, type);
		
		edu.kh.festival.board.model.vo.Pagination pagination = new edu.kh.festival.board.model.vo.Pagination(cp, memberCount);
		
		return null;
		
		
	}

		
		
		
		
	


	

}
