package edu.kh.festival.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.board.model.service.BoardService;
import edu.kh.festival.board.model.service.FestivalService;
import edu.kh.festival.board.model.vo.FestivalDetail;

@WebServlet("/board/festivalDetail")
public class FestivalDetailServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		try {

			int festivalNo = Integer.parseInt(req.getParameter("festivalNo"));
			
			System.out.println(festivalNo);
			
			FestivalDetail detail = new FestivalDetail();
			
			FestivalService service = new FestivalService();
			
			Map<String, Object> map = null;
			
			map = service.selectFesitvalDetail(festivalNo);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
