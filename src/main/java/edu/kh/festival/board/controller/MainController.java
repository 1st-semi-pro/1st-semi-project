package edu.kh.festival.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.festival.board.model.service.MainBoardService;
import edu.kh.festival.board.model.vo.Board;
import edu.kh.festival.board.model.vo.BoardDetail;
import edu.kh.festival.board.model.vo.Festival;

@WebServlet("/board/mainList/*")
public class MainController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		
		String contextPath = req.getContextPath();
		
		String command = uri.substring(  (contextPath + "/board/mainList/").length()  );
		
		
		
		MainBoardService service = new MainBoardService();
		
		try {
			
			if(command.equals("bd1")) {
				
				List<BoardDetail> boardList1 = new ArrayList<BoardDetail>();
				
				boardList1 = service.selectMainboard();
				
				new Gson().toJson( boardList1, resp.getWriter());
			}
			
			
			if(command.equals("bd2")) {
				
				List<BoardDetail> boardList2 = new ArrayList<BoardDetail>();
				
				boardList2 = service.selectMainboard2();
				
				new Gson().toJson( boardList2, resp.getWriter());
			}
			
			if(command.equals("bd3")) {
				
				List<BoardDetail> boardList3 = new ArrayList<BoardDetail>();
				
				boardList3 = service.selectMainboard3();
				
				new Gson().toJson( boardList3, resp.getWriter());
			}
			
			if(command.equals("festival1")) {
				
				List<Festival> festivalList1 = new ArrayList<Festival>();
				
				festivalList1 = service.selectFestival1();
				
				new Gson().toJson( festivalList1, resp.getWriter());
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
