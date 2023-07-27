package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.festival.member.model.service.MemberService;
import edu.kh.festival.member.model.vo.Member;


@WebServlet("/member/join")
public class JoinServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/WEB-INF/views/member/join.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		// String inputPwCheck = req.getParameter("inputPwCheck");
		
		String memberNickname = req.getParameter("memberNickname");
		String memberName = req.getParameter("memberName");
		int memberBirth = Integer.parseInt(req.getParameter("memberBirth"));
		String region = req.getParameter("regionSelect"); // select 태그 -> option의 value값이 넘어온다.
		
		String memberPhone = req.getParameter("memberPhone");
		
		String gender = req.getParameter("gender"); // -> radio 태그도 똑같은 name들 value 각각 넣어놓으면 체크된 value 가져온다.
		
		String nationality = req.getParameter("nation");
		
		String inputEmail = req.getParameter("inputEmail");
		
		//System.out.println(gender);
		//System.out.println(nationality);
		//System.out.println(region);
		
		Member mem = new Member();
		
		mem.setMemberId(inputId);
		mem.setMemberPw(inputPw);
		mem.setMemberNickname(memberNickname);
		mem.setMemberName(memberName);
		mem.setMemberBirth(memberBirth);
		mem.setMemberRegion(region);
		mem.setMemberPhone(memberPhone);
		mem.setMemberGender(gender);
		mem.setMemberNationality(nationality);
		mem.setMemberEmail(inputEmail);
		
		try {
			MemberService service = new MemberService();
	
			int result = service.join(mem);
			
			HttpSession session = req.getSession();			
			
			if(result == 1) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
