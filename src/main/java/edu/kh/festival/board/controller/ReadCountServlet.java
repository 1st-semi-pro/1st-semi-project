package edu.kh.festival.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.board.model.service.BoardService;

@WebServlet("/board/test")
public class ReadCountServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		BoardService service = new BoardService();
		
		String boardTitle = req.getParameter("boardTitle");
		
		System.out.println("test read");
		
		System.out.println(boardTitle);
		
		String path = "/WEB-INF/views/board/boardList.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
		
	}
	
}
