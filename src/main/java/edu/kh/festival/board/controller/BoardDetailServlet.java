package edu.kh.festival.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.board.model.service.BoardService;
import edu.kh.festival.board.model.vo.BoardDetail;


@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int boardNo = Integer.parseInt(req.getParameter("no")); // 게시글 번호
			
			BoardService service = new BoardService();
			
			BoardDetail detail = service.selectboardDetail(boardNo); // 게시글 정보 다 가져오기 (이미지는 제외)
			
			if(detail != null) {
				// 댓글 조회
			}
			
			req.setAttribute("detail", detail);
			
			String path = "/WEB-INF/views/board/boardDetail.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
