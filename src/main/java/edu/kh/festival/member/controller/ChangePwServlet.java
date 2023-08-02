package edu.kh.festival.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			System.out.println(m.getMemberId());
			System.out.println(m.getMemberName());
			System.out.println(m.getMemberEmail());
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
