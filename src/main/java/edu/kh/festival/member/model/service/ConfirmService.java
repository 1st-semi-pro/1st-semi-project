package edu.kh.festival.member.model.service;

import static edu.kh.festival.common.JDBCTemplate.close;
import static edu.kh.festival.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import edu.kh.festival.member.model.dao.ConfirmDAO;
import edu.kh.festival.member.model.vo.Member;

import static edu.kh.festival.common.JDBCTemplate.*;

public class ConfirmService {
	
	private ConfirmDAO dao = new ConfirmDAO();
	

	/** 비밀번호 확인 Service
	 * @param memberId
	 * @param inputPw
	 * @return result
	 * @throws Exception
	 */
	public int confirmMember(String memberId, String inputPw) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.confirmMember(conn, memberId, inputPw);
		
		close(conn);
		
		return result;
		
	}


	/** 이름과 이메일이 일치하는 회원이 있는지 확인 Service
	 * @param inputName
	 * @param inputEmail
	 * @return member
	 * @throws Exception
	 */
	public Member checkEmail(String inputName, String inputEmail) throws Exception {
		
		Connection conn = getConnection();
		
		Member member = dao.checkEmail(conn, inputName, inputEmail);
		
		close(conn);
		
		return member;
	}

}
