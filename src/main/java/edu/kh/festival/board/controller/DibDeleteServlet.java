package edu.kh.festival.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.board.model.service.FestivalService;

@WebServlet("/board/dibDelete")
public class DibDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int festivalNo = Integer.parseInt(req.getParameter("festivalNo"));
			
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			
			FestivalService service = new FestivalService();
			
			int result = service.deleteDib(memberNo, festivalNo);
			
			resp.getWriter().print(result);
			
		}catch(Exception e) {
			
		}
		
		
		
	}
	
}
