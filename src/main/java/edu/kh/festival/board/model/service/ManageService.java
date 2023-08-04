package edu.kh.festival.board.model.service;


import static edu.kh.festival.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.festival.board.model.dao.ManageDAO;
import edu.kh.festival.board.model.vo.Pagination2;
import edu.kh.festival.member.model.vo.Member;

public class ManageService {
	
	private ManageDAO dao = new ManageDAO();

	
	
	/** 회원 목록 조회 Service (관리자)
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
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

	/** 검색 목록 조회 Service (관리자)
	 * @param cp
	 * @param ctg
	 * @param search
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> searchBoardList(int cp, String ctg, String search) throws Exception {
		
		Connection conn  = getConnection();
		
		String condition  = null;
		
		switch(ctg) {
		case "id" : condition  = " AND MEMBER_ID LIKE '%" + search + "%' "; break;
		case "ni" : condition  = " AND MEMBER_NICKNAME LIKE '%" + search + "%' "; break;
		case "em" : condition  = " AND MEMBER_EMAIL LIKE '%" + search + "%' "; break;
		}
		
		int memberCount = dao.getMemberCount(conn, condition);
		
		Pagination2 pagination = new Pagination2(cp, memberCount);
		
		List<Member> mList = dao.searchMemberList(conn, pagination, condition);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("mList", mList);
		map.put("memberCount", memberCount);
		
		close(conn);
		
		
		return map;
	}

	/** 관리자 회원 탈퇴
	 * @param checkRow
	 * @return result
	 * @throws Exception
	 */
	public int deleteMember(String[] checkRow) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteMember(conn, checkRow);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);

		close(conn);
		
		return result;
	}

	/** 관리자 회원 프로필 보기
	 * @param memberNo
	 * @return member
	 * @throws Exception
	 */
	public Member viewProfile(int viewMemberNo) throws Exception {
		
		Connection conn = getConnection();
		
		Member viewMember = dao.viewProfile(conn, viewMemberNo);
		
		close(conn);
		
		return viewMember;
		
	}

	
	public List<Member> selectMemberList() throws Exception {
		
		Connection conn = getConnection();
		
		List<Member> mList = dao.selectMemberList(conn);
		
		
		
		return mList;
	}
	
	

	/** 좋아요 갯수 출력 Service
	 * @param viewMemberNo
	 * @return result
	 * @throws Exception
	 */
	public int viewGood(int viewMemberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.viewGood(conn, viewMemberNo);
		
		close(conn);
		
		return result;
	}

	
	
	/** 신고 갯수 출력 Service
	 * @param viewMemberNo
	 * @return result
	 * @throws Exception
	 */
	public int viewBad(int viewMemberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.viewBad(conn, viewMemberNo);
		
		close(conn);
		
		return result;
	}

		
		
		
	


	

}
