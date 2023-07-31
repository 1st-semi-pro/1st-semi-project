package edu.kh.festival.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.board.model.service.ReplyService;

@WebServlet("/reply/*")
public class ReplyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uri = req.getRequestURI(); // /community/reply/test
		String contextPath = req.getContextPath(); // /community
		String command = uri.substring(  (contextPath + "/reply/").length()  );// test (/reply/ 뒤)
		// /festival/reply/ 뒤부터 잘라냄을 의미
		
		ReplyService service = new ReplyService();
		
		try {
			
			if(command.equals("selectReplyList"));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
