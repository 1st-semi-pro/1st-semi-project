package edu.kh.festival.member.model.service;

import static edu.kh.festival.common.JDBCTemplate.close;
import static edu.kh.festival.common.JDBCTemplate.getConnection;
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


	/** 회원가입 - 닉네임 중복검사 service
	 * @param memberNickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameCheck(String memberNickname) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.nicknameCheck(conn, memberNickname);
		
		close(conn);
		
		return result;
	}

	/** 회원가입 - 이메일 중복검사 service
	 * @param inputEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailCheck(String inputEmail) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.emailCheck(conn, inputEmail);
		
		close(conn);
		
		return result;
	}

	/** 회원가입 service
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int join(Member mem) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.join(conn, mem);
		
		if(result > 0 ) commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/**
	 * 프로필이미지 변경 service
	 * @param memberNo
	 * @param profileImage
	 * @return result
	 * @throws Exception
	 */
	public int updateProfileImage(int memberNo, String profileImage) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.updateProfileImage(conn, memberNo, profileImage);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/**
	 * 이름,아이디 일치하는 회원 조회 service
	 * @param memberName
	 * @param memberId
	 * @return 
	 * @throws Exception
	 */
	public Member searchMember(String memberName, String memberId) throws Exception{
		Connection conn = getConnection();
		
		Member member = dao.searchMember(conn, memberName, memberId);
		
		close(conn);
		
		return member;
	}





	
}
