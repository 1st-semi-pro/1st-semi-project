package edu.kh.festival.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.board.model.service.BoardService;
import edu.kh.festival.board.model.service.ReplyService;
import edu.kh.festival.board.model.vo.BoardDetail;
import edu.kh.festival.board.model.vo.Reply;

// http://localhost:8080/semiworkspacee/board/list?type=1&cp=2 에서
// http://localhost:8080/semiworkspacee/board/detail?no=490&cp=2&type=1 으로 오는 식
@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); 
		String contextPath = req.getContextPath(); 
		String command = uri.substring(  (contextPath + "/board/").length()  );
		
		try {
			
			BoardService service = new BoardService();
			
			int boardNo = Integer.parseInt(req.getParameter("no"));
			
			BoardDetail detail = service.selectBoardDetail(boardNo);
			
			// 댓글 조회
			if(detail != null) {
				
				ReplyService service2	 = new ReplyService();
				List<Reply> ReplyList = service2.selectReplyList(boardNo);
				// replyContorller는 주소로? 받지만 얘는 서비스로 바로넘겨서 상관이 없음
				
				req.setAttribute("ReplyList", ReplyList);
				
			}
			
			req.setAttribute("detail", detail);
			
			String path = "/WEB-INF/views/board/boardDetail.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
