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
	public int updateMember(Member mem/* , String newPw */) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, mem /* , newPw */);
		
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
	 * 프로필 이미지 변경 service
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
	 * 프로필  메세지 변경 service
	 * @param memberNo
	 * @param profileMessage
	 * @return result
	 * @throws Exception
	 */
	public int updateProfileMessage(int memberNo, String profileMessage) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.updateProfileMessage(conn, memberNo, profileMessage);
		
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



	/** 비밀번호 변경 Service
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(String currentPw, String newPw, int memberNo) throws Exception {
		
		Connection conn = getConnection();

		int result = dao.changePw(conn, currentPw,newPw,memberNo);

		if (result > 0) commit(conn);
		else rollback(conn);

		close(conn);

		return result;
	}
	public int changePw(String newPw, String memberId) throws Exception {
		
		Connection conn = getConnection();

		int result = dao.changePw(conn, newPw, memberId);

		if (result > 0) commit(conn);
		else rollback(conn);

		close(conn);

		return result;
	}

	/** 회원탈퇴 Service
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(int memberNo, String memberPw) throws Exception{
		
		Connection conn = getConnection();

		int result = dao.secession(conn,memberNo,memberPw);

		if (result > 0) commit(conn);
		else rollback(conn);

		close(conn);

		return result;
	}



	/** 이메일 중복 검사 Service
	 * @param memberEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailDupCheck(String memberEmail) throws Exception {
		
		
		Connection conn = getConnection(); // DBCP에서 만들어둔 커넥션 얻어오기
		
		int result = dao.emailDupCheck(conn,memberEmail);
		
		close(conn);
		
		return result;
	}

	/** 닉네임 중복 검사 Service
	 * @param memberNickname
	 * @return
	 * @throws Exception
	 */
	public int NicknameDupCheck(String memberNickname) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.NicknameDupCheck(conn,memberNickname);
		
		close(conn);
		
		return result;
	}

	
	
	
}
