package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.member.model.service.MemberService;

// 회원가입 아이디 중복검사 Servlet
@WebServlet("/member/test")
public class JoinIdDupCheckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberId = req.getParameter("inputId");
		
		System.out.println(memberId);
		
		try {
			
			MemberService service = new MemberService();
			
			int result = service.idCheck(memberId);
			
		
			resp.getWriter().print(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	} 
	
}
