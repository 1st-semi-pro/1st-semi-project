package edu.kh.festival.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.festival.board.model.service.BoardService;
import edu.kh.festival.board.model.service.FestivalService;
import edu.kh.festival.board.model.service.MainBoardService;
import edu.kh.festival.board.model.vo.BoardDetail;

@WebServlet("/board/search")
public class SearchResultServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		try {
			
	
			MainBoardService mainboardService = new MainBoardService();
			FestivalService festivalService = new FestivalService();
			BoardService boardService = new BoardService();
			// 게시판 이름, 페이지네이션 객체, 게시글 리스트 한번에 반화하는 Service 호출
			Map<String,Object> map1 = null;
			Map<String,Object> map2 = null;
			Map<String,Object> map3 = null;
			
				//String key = req.getParameter("key");
				String query = req.getParameter("query");
				
				map1 = mainboardService.searchResultList(query);
				map2 = festivalService.festivalInfo(query);
				map3 = boardService.companionList(query);
				
			// request 범위로 map을 세팅
			req.setAttribute("map1", map1);
			req.setAttribute("map2", map2);
			req.setAttribute("map3", map3);
			
			
			String path = "/WEB-INF/views/board/searchResult.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
