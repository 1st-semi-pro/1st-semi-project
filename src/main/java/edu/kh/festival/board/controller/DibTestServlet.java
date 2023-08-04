package edu.kh.festival.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.board.model.service.FestivalService;

// 찜이 되어있는지 안되어있는지 조회하는 dibTest Servlet 즉시실행함수로 페이지 들어오자마자 실행
@WebServlet("/board/dibTest")
public class DibTestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int festivalNo = Integer.parseInt(req.getParameter("festivalNo"));
			
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			
			FestivalService service = new FestivalService();
			 
			int result = service.dibTest(memberNo, festivalNo);
			
			System.out.println(result);

			resp.getWriter().print(result);
			
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}
		
	}
	
}
