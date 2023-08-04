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


@WebServlet("/member/changePw")
public class ChangePwServlet extends HttpServlet{
	   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberName = req.getParameter("memberName");
		String memberId = req.getParameter("memberId");
		String memberEmail = req.getParameter("memberEmail");

		try {
			//먼저 아이디로 회원정보를 받아오고 가져온 데이터에서 email값을 비교하여 존재하지 않으면 인증메일 보내지 못함
			Member m = new MemberService().searchMember(memberName, memberId);

			if(m==null || !m.getMemberEmail().equals(memberEmail)) {
				req.setAttribute("message", "아이디나 이메일 정보가 맞지 않습니다");
			}
			else{
			   req.setAttribute("message", "이메일을 확인 후 인증번호를 입력해주세요");
			}
		}catch(Exception e) {
		   e.printStackTrace();
		}

		String path = "/WEB-INF/views/member/changePw.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newPw = req.getParameter("newPw");
		String newPwCheck = req.getParameter("newPwCheck");
		String memberId = req.getParameter("memberId");
		
		HttpSession session = req.getSession(); // 세션 얻어오기
		String path = null;
		
		if(newPw.equals(newPwCheck)) {
			System.out.println("새비밀번호, 비밀번호 확인 일치");
			
			try {
				int result = new MemberService().changePw(newPw, memberId );
				
				System.out.println(result);
				System.out.println(result>0 ? "변경성공" : "변경실패");
				
				if(result > 0) { // 성공
					session.setAttribute("message", "비밀번호 변경이 완료되었습니다.");
					
					path = req.getContextPath() + "/member/login";
					
				} else { // 실패
					session.setAttribute("message", "비밀번호 변경에 실패했습니다..");
					
					// path = req.getContextPath() +"/member/changePw";
					path = "changePw";
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
