package edu.kh.festival.member.model.service;

import static edu.kh.festival.common.JDBCTemplate.close;
import static edu.kh.festival.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import edu.kh.festival.member.model.dao.ConfirmDAO;

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

}
