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

@WebServlet("/board/mainList")
public class MainController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<BoardDetail> boardList1 = new ArrayList<BoardDetail>();
			List<Board> boardList2 = new ArrayList<Board>();
			List<Board> boardList3 = new ArrayList<Board>();
			List<Board> boardList4 = new ArrayList<Board>();
			
			MainBoardService service = new MainBoardService();
			
			
			
			boardList1 = service.selectMainboard();
			
			
			new Gson().toJson( boardList1, resp.getWriter());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
