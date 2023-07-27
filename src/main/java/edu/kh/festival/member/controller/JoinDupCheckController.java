package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.member.model.service.MemberService;

@WebServlet("/member/*")
public class JoinDupCheckController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // /semiworkspace/member/join
		String contextPath = req.getContextPath(); // /semiworkspace
		String command = uri.substring(  (contextPath + "/member/").length()  );// /member/ 뒤
		
		MemberService service = new MemberService();
		
		try {
			
			// 아이디 중복검사
			if(command.equals("idDupCheck")) { // command = join idDupCheck ajax 실행되는 순간 join -> idDupCheck
				
				String memberId = req.getParameter("inputId");
				
				int result = service.idCheck(memberId);
				
				resp.getWriter().print(result);
				
			}
			
			// 닉네임 중복검사
			if(command.equals("nicknameDupCheck")) {
				
				String memberNickname = req.getParameter("memberNickname");
				
				int result = service.nicknameCheck(memberNickname);
				
				resp.getWriter().print(result);
				
			}
				
			if(command.equals("emailDupCheck")) {
				
				String inputEmail = req.getParameter("inputEmail");
				
				int result = service.emailCheck(inputEmail);
			
				System.out.println(result);
				
				resp.getWriter().print(result);
				
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp); //POST 요청도 GET으로 처리
	}
	
	
	
}
