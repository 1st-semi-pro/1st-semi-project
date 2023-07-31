package edu.kh.festival.board.model.service;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

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

}
