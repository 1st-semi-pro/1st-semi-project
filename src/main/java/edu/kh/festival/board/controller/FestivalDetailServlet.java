package edu.kh.festival.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
			
			//map.put("festival", fes);
			//map.put("festivalDetail", fesDt); 
			// festival, festivalDetail 안의 컬럼 값들 전부 다 가져오고
			
			//map.put("imgList", imgList);
			// imgList(여러행) 을 가져온다.
			
			// service 안에서 detail을 보여주기 전 조회수를 +1 시킨다

			req.setAttribute("map", map);
			
			String path = "/WEB-INF/views/board/festivalDetail.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
