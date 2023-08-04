package edu.kh.festival.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.festival.common.EmailSender;
import edu.kh.festival.member.model.service.MemberService;
import edu.kh.festival.member.model.vo.Member;

@WebServlet("/member/sendEmail")
public class SendEmailServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String memberName = req.getParameter("memberName");
		String memberId = req.getParameter("memberId");
		String memberEmail = req.getParameter("memberEmail");		
		
		//System.out.println(memberName);
		//System.out.println(memberId);
		//System.out.println(memberEmail);
		
		try {
			Member member = new MemberService().searchMember(memberName, memberId);
			
			if(member.getMemberEmail().equals(memberEmail)) {
				//System.out.println("DB조회한 이메일이랑 일치함");
				String key = EmailSender.sendEmail(memberEmail);
				new Gson().toJson(key, resp.getWriter());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
