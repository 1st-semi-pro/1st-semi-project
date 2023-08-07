package edu.kh.festival.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.kh.festival.board.model.service.BoardService;
import edu.kh.festival.board.model.vo.Board;

@WebServlet("/companionList/*")
public class CompanionDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // /community/reply/test
		String contextPath = req.getContextPath(); // /community
		String command = uri.substring((contextPath + "/companionList/").length());// test (/reply/ 뒤)
		BoardService service = new BoardService();
		
		try {
			if(command.equals("companionList")) {
				
				int type = Integer.parseInt(req.getParameter("type"));
				
				int cp = 1;
				
				if (req.getParameter("cp") != null) {
					cp = Integer.parseInt(req.getParameter("cp"));
				}
				
				List<Board> companionList = service.companionList1(type,cp);
				
				 new Gson().toJson(companionList, resp.getWriter());
				
			}
			
			if (command.equals("delete")) {
				
				HttpSession session = req.getSession();
				
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				
				int result = service.deleteCompanion(boardNo);
				
		
				resp.getWriter().print(result);
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
