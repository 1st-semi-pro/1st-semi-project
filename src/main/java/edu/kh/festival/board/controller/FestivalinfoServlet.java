package edu.kh.festival.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.board.model.service.FestivalService;

@WebServlet("/board/festivalInfo")
public class FestivalinfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
		try {
			
			int type = Integer.parseInt(req.getParameter("type"));
			
			int ft = Integer.parseInt(req.getParameter("ft"));
			
			int cp = 1;
			
			if(req.getParameter("cp")!=null) { // 쿼리스트링에 "cp"가 존재한다면
				cp = Integer.parseInt(req.getParameter("cp"));
			}
			
			FestivalService service = new FestivalService();
			
			Map<String,Object> map = service.festivalInfo(type, cp);
			
			if( ft == 0 ) {
				map = service.festivalInfo(type, cp);
				System.out.println("map null == " + map);
			}
			
			if( ft == 1 ) {
				map = service.festivalInfo(type, cp,ft);
				System.out.println("map == 1" + map);
			}
			
			
			req.setAttribute("map", map);
			
			String path = "/WEB-INF/views/board/festivalInformation.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
