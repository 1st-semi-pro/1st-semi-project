package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.kh.festival.common.EmailSender;
import edu.kh.festival.member.model.service.MemberService;
import edu.kh.festival.member.model.vo.Member;

@WebServlet("/member/myPage/emailAuthentication/*")
public class SendInfoEmailServlet extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // /semiworkspace/member/join
		String contextPath = req.getContextPath(); // /semiworkspace
		String command = uri.substring(  (contextPath + "/member/myPage/////").length()  );// /member/ 뒤
		
		MemberService service = new MemberService();
		
		try {
			
			
			// 이메일 인증하기	
			if(command.equals("emailAuthentication")) {
				
				String Email = req.getParameter("Email");
				
				System.out.println(Email);
				
				String key = EmailSender.sendEmail(Email);
				
				System.out.println(key);
				
				new Gson().toJson(key, resp.getWriter());
				 
				
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
