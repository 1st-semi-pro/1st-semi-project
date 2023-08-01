package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.festival.member.model.service.ConfirmService;
import edu.kh.festival.member.model.vo.Member;


@WebServlet("/member/pwConfirm/check")
public class PwConfirmServlet2 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputPw = req.getParameter("inputPw");

		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		
		System.out.println("로그인한멤버 아이디 확인" + memberId);
		
		try {
			ConfirmService service = new ConfirmService();
			
			int result = service.confirmMember(memberId, inputPw);
			
			System.out.println(result);
			
			if(result == 1) {
				resp.sendRedirect("/member/myPageInfo");
			}else {
				session.setAttribute("message", "비밀번호가 일치하지 않습니다.");
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
