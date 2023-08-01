package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.member.model.service.MemberService;

@WebServlet("/member/myPage/NicknameDupCheck")
public class NicknameDupCheckServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberNickname = req.getParameter("memberNickname");
		
		System.out.println("memberNickname == " + memberNickname);
		
		try {
			
			MemberService service = new MemberService();
			
			int result = service.NicknameDupCheck(memberNickname);
			
			
			if(result >0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			resp.getWriter().print(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}