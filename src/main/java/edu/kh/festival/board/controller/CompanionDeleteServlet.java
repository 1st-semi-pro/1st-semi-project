package edu.kh.festival.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.board.model.service.BoardService;

@WebServlet("/companionList/*")
public class CompanionDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // /community/reply/test
		String contextPath = req.getContextPath(); // /community
		String command = uri.substring((contextPath + "/companionList/").length());// test (/reply/ 뒤)
		BoardService service = new BoardService();
		
		try {
			if(command.equals("companionList")) {

				
				
				
			}
			
			if(command.equals("delete")) {
				
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				
				int result = service.deleteCompanion(boardNo);
				
				resp.getWriter().print(result);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
