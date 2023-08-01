package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.festival.board.model.service.ManageService;
import edu.kh.festival.member.model.service.ConfirmService;
import edu.kh.festival.member.model.vo.Member;

@WebServlet("/member/pwConfirm")
public class PwConfirmServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				
		String path = "/WEB-INF/views/member/pwConfirm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
		
		/*
		 * if(command.equals("check")) { String inputPw = req.getParameter("inputPw");
		 * System.out.println("입력한 비밀번호" +inputPw);
		 * 
		 * HttpSession session = req.getSession();
		 * 
		 * edu.kh.festival.member.model.vo.Member loginMember =
		 * (edu.kh.festival.member.model.vo.Member)(session.getAttribute("loginMember"))
		 * ; System.out.println(loginMember + "~~~");
		 * 
		 * String path = "/WEB-INF/views/member/pwConfirm.jsp";
		 * req.getRequestDispatcher(path).forward(req, resp);
				
			
			
		}
		 */
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String inputPw = req.getParameter("inputPw");

		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		String memberId = loginMember.getMemberId();
		
		try{
			ConfirmService service = new ConfirmService();
			
			int result = service.confirmMember(memberId, inputPw);
			
			
			if(result == 1) {
				resp.sendRedirect(req.getContextPath() +"/member/myPage/info");
			}else {
				resp.sendRedirect(req.getContextPath() + "/member/pwConfirm");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
