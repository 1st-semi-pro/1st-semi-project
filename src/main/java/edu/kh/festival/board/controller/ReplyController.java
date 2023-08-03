package edu.kh.festival.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.festival.board.model.vo.Reply;
import edu.kh.festival.board.model.service.ReplyService;

@WebServlet("/reply/*")
public class ReplyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uri = req.getRequestURI(); 
		String contextPath = req.getContextPath(); 
		String command = uri.substring(  (contextPath + "/reply/").length()  );
		// /festival/reply/ 뒤부터 잘라냄을 의미
		
		ReplyService service = new ReplyService();
		
	
		try {
			
			// 첫화면은 detail.jsp에 include된 reply.jsp를 띄우는 것이고
			// 얘네는 다 reply.js에서 ajax로 쓴다.
			
			// 댓글 조회
			if(command.equals("selectReplyList")) {
				
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));	
				
				List<Reply> replyList = service.selectReplyList(boardNo);
				
				new Gson().toJson(replyList, resp.getWriter());
				
			}
			
			// 댓글 등록
			if(command.equals("insert")) {
				
				String replyContent = req.getParameter("replyContent");
				int memberNo = Integer.parseInt(req.getParameter("memberNo"));
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				
				Reply reply = new Reply();
				reply.setReplyContent(replyContent);
				reply.setMemberNo(memberNo);
				reply.setBoardNo(boardNo);
				
				int result = service.insertReply(reply);
				
				resp.getWriter().print(result);
				
			}
			
			// 댓글 수정
			if(command.equals("update")) {
				
				int replyNo = Integer.parseInt(req.getParameter("replyNo"));
				String replyContent = req.getParameter("replyContent");
				
				int result = service.updateReply(replyNo, replyContent);
				
				resp.getWriter().print(result);
				
			}
			
			// 댓글 삭제
			if(command.equals("delete")) {
				
				int replyNo = Integer.parseInt(req.getParameter("replyNo"));
				
				int result = service.deleteReply(replyNo);
				
				resp.getWriter().print(result);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
		
	}
	
	
	
}
