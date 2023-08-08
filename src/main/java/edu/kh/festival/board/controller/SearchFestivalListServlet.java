package edu.kh.festival.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.festival.board.model.service.FestivalService;
import edu.kh.festival.board.model.vo.Festival;

@WebServlet("/SearchFestivalListServlet")
public class SearchFestivalListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String festivalDatd = req.getParameter("festivalDate");
		String festivalArea = req.getParameter("festivalArea");
		String festivalCat = req.getParameter("festivalCat");
		List<Festival> festList = null;
		
		try {
			festList = new FestivalService().festivalInfo(festivalDatd, festivalArea, festivalCat);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		new Gson().toJson(festList, resp.getWriter());
	}
}
