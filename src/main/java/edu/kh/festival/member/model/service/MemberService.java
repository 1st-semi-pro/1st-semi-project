package edu.kh.festival.member.model.service;


import static edu.kh.festival.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.festival.member.model.dao.MemberDAO;
import edu.kh.festival.member.model.vo.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO(); 
		// DAO 메소드 호출해야해서 객체 생성
	
	
	/** 로그인 서비스
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem) throws Exception{

		Connection conn = getConnection();
		
		Member loginMember = dao.login(mem, conn);
		
		close(conn);
		
		return loginMember;
	}


	/** 회원 정보 수정 Service
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Member mem, String newPw) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, mem , newPw);
		
		if(result >0) commit(conn);
		else		  rollback(conn);
		
		close(conn);
		
		
		return result;
	}


	public Map<String, Object> manageMember(int cp) {
		// TODO Auto-generated method stub
		return null;
	}


	/** 회원가입 - 아이디 중복검사 service
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idCheck(String memberId) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.idCheck(conn, memberId);
		
		close(conn);
		
		return result;

	}


	
}
