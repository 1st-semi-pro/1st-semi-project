package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.festival.member.model.service.MemberService;
import edu.kh.festival.member.model.vo.Member;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/WEB-INF/views/member/login.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 로그인창에 아이디 입력하고 입력하고 로그인 누르면 값 담김
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		
		// 확인용
		System.out.println(inputId);
		System.out.println(inputPw);
		
		// 입력한 아이디, 비번 Member VO에 세팅
		Member mem = new Member();
		mem.setMemberId(inputId);
		mem.setMemberPw(inputPw);
		
		try {
			
				// 서비스 객체 만들기 (서비스 메소드 쓸라고)
				MemberService service = new MemberService();
				
				// 이메일, 비번 일치하는 회원 있는지 조회하고 결과 반환받으러 가기
				Member loginMember = service.login(mem);
			
				if(loginMember != null) {
					System.out.println("성공");
					
				}else {
					System.out.println("실패");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
