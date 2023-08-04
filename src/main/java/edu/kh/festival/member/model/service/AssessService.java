package edu.kh.festival.member.model.service;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.festival.member.model.dao.AssessDAO;

public class AssessService {
	private AssessDAO dao = new AssessDAO();

	
	
	/** 좋아요 중복 조회 Service
	 * @param recNo
	 * @param goodNo
	 * @return result
	 * @throws Exception
	 */
	public int checkAssess(int recNo, int goodNo) throws Exception  {
		
		Connection conn =  getConnection();
		
		int result = dao.checkAssess(conn, recNo, goodNo);
		
		close(conn);
		
		return result;
	}
	
	
	
	
	/** 좋아요 눌렀을 때 행 추가 Service 
	 * @param recNo
	 * @param goodNo
	 * @return result
	 * @throws Exception
	 */
	public int addAssess(int recNo, int goodNo) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.addAssess(conn, recNo, goodNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}




	/** 좋아요 기록 삭제 Service
	 * @param recNo
	 * @param goodNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteAssess(int recNo, int goodNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteAssess(conn, recNo, goodNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}




	/** 좋아요 개수 조회 Service
	 * @param goodNo
	 * @return result
	 * @throws Exception
	 */
	public int selectAssess(int goodNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.selectAssess(conn, goodNo);
		
		close(conn);
		
		return result;
		
	}



	
	/** 신고하기 중복 검사 Service
	 * @param recNo
	 * @param goodNo
	 * @return result
	 * @throws Exception
	 */
	public int checkAssess1(int recNo, int badNo) throws Exception {
		
		Connection conn =  getConnection();
		
		int result = dao.checkAssess1(conn, recNo, badNo);
		
		close(conn);
		
		return result;
	}




	/** 신고하기 기록 추가 Service
	 * @param recNo
	 * @param badNo
	 * @return result
	 * @throws Exception
	 */
	public int addBadAssess(int recNo, int badNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.addBadAssess(conn, recNo, badNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}




	/** 신고하기 기록 삭제 Service
	 * @param recNo
	 * @param badNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBadAssess(int recNo, int badNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteBadAssess(conn, recNo, badNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}



	/** 신고하기 개수 조회 Service
	 * @param goodNo
	 * @return result
	 * @throws Exception
	 */
	public int selectBadAssess(int badNo) throws Exception {
		
Connection conn = getConnection();
		
		int result = dao.selectBadAssess(conn, badNo);
		
		close(conn);
		
		return result;
	}

}
