package edu.kh.festival.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.board.model.service.FestivalService;

// 찜하기 누르면 ajax로 연결해 찜하기(dib) 테이블에 연결 
// dib 테이블의 member_no -> member의 member_no의 fk
// dib 테이블의 festival_no -> festival의 festival의 fk
// -> join 3번해서 관심 축제를 가져온다 join dib, join festival, join festival_img
@WebServlet("/board/dibInsert")
public class DibInsertServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
				
				int festivalNo = Integer.parseInt(req.getParameter("festivalNo"));
				
				int memberNo = Integer.parseInt(req.getParameter("memberNo"));
				
				FestivalService service = new FestivalService();
				
				int result = service.insertDib(memberNo, festivalNo);
				
				resp.getWriter().print(result);
		
			}	catch(Exception e) {
				
				e.printStackTrace();
		}
	}
}