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

@WebServlet("/member/myPage/changePw")
public class MyPageChangePwServlet extends HttpServlet {
	
	// get방식 요청 :  /WEB-INF/views/member/myPage-changePW.jsp 요청위임
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/myPage-changePw.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	// post방식 요청 : 비밀번호 변경
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터(현재 비밀번호, 새 비밀번호) 얻어오기
		String currentPw = req.getParameter("currentPw");
		String newPw = req.getParameter("newPw");
		
		// ** 로그인 회원 번호 얻어오기 **
		HttpSession session = req.getSession(); // 세션 얻어오기
		
		// 로그인 정보 얻어오기
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		int memberNo = loginMember.getMemberNo(); // 로그인 회원번호
		
		System.out.println(currentPw);
		System.out.println(newPw);
		System.out.println(memberNo);
		
		try {
			MemberService service = new MemberService();
			
			String path = null;
			
			int result = service.changePw(currentPw,newPw,memberNo);
			
			if(result > 0) { // 성공
				// session scope -> key="message", value="비밀번호 성공!"
				// path = "내 정보 페이지 주소"
				session.setAttribute("message", "비밀번호 변경완료!");
				
				path = req.getContextPath() +"/member/myPage/info";
				//path = "info";
				
			} else { // 실패
				session.setAttribute("message", "현재 비밀번호가 일치하지 않습니다!");
				
				// path = req.getContextPath() +"/member/myPage/changePw";
				path = "changePw";
			}
			
			
			resp.sendRedirect(path);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}

