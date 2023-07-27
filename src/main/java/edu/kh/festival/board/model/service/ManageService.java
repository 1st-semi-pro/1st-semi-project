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

	public Map<String, Object> selectAllMember(int cp)throws Exception {
		
		Connection conn = getConnection();
		
		
		// 회원수 조회
		int memberCount = dao.getMemberCount(conn);
		
		// 페이지네이션 객체 생성
		edu.kh.festival.board.model.vo.Pagination2 pagination = new edu.kh.festival.board.model.vo.Pagination2(cp, memberCount);
		
		// 회원목록 조회
		List<Member> mList = dao.selectMemberList(conn, pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("mList", mList);
		map.put("memberCount", memberCount);
		
		
		close(conn);
		
		return map;
	}

		
		
		
		
	


	

}
