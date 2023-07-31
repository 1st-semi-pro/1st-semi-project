package edu.kh.festival.board.model.service;


import static edu.kh.festival.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.festival.common.Util;
import edu.kh.festival.board.model.dao.ReplyDAO;
import edu.kh.festival.board.model.vo.Reply;

public class ReplyService {

	private ReplyDAO dao = new ReplyDAO();
	
	/** 댓글 조회 service
	 * @param boardNo
	 * @return replyList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(int boardNo) throws Exception {

		Connection conn = getConnection();
		
		List<Reply> replyList = dao.selectReplyList(conn,boardNo);
		
		close(conn);
		
		return replyList;
	}

	/** 댓글 작성 service
	 * @param reply
	 * @return result
	 * @throws Exception
	 */ 
	public int insertReply(Reply reply) throws Exception {
		
		Connection conn = getConnection();
		
		reply.setReplyContent( Util.XSSHandling( reply.getReplyContent()) );
		
		reply.setReplyContent( Util.newLineHandling(reply.getReplyContent()) );
		
		int result = dao.insertReply(conn, reply);
		
		if(result == 1) conn.commit();
		else conn.rollback();
		
		close(conn);
		
		return result;
		
	}

	/** 댓글 수정 service
	 * @param replyNo
	 * @param replyContent
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(int replyNo, String replyContent) throws Exception {

		Connection conn = getConnection();
		
		// XSS 처리
		replyContent = Util.XSSHandling(replyContent);
		
		// 개행문자 처리
		replyContent = Util.newLineHandling(replyContent);
		
		int result = dao.updateReply(conn, replyNo, replyContent);
		
		if(result > 0) conn.commit();
		else conn.rollback();
		
		close(conn);
		
		return result;
	}

	/** 댓글 삭제 service
	 * @param replyNo
	 * @return
	 */
	public int deleteReply(int replyNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteReply(conn, replyNo);
		
		if(result > 0) conn.commit();
		else conn.rollback();
		
		close(conn);
		
		return result;
		
		
	}

}
