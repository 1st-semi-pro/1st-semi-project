package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.board.model.service.ManageService;
import edu.kh.festival.member.model.vo.Member;

@WebServlet("/member/myPage2")
public class MyPageServlet2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int viewMemberNo = Integer.parseInt(req.getParameter("memberNo"));
			
			System.out.println(viewMemberNo);
			
			Member viewMember = new Member();
			
			ManageService service = new ManageService();
			
			viewMember = service.viewProfile(viewMemberNo);
			
			System.out.println(viewMember);
			
			 req.setAttribute("viewMember", viewMember);
			
			String path = "/WEB-INF/views/member/myPage2.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
