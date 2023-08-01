package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.festival.board.model.service.ManageService;

@WebServlet("/member/pwConfirm/view")
public class PwConfirmServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		
		String contextPath = req.getContextPath();
		
		String command = uri.substring((contextPath + "/member/pwConfirm/").length());
		
		ManageService service = new ManageService();
		
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
		
		doGet(req, resp);
	}
}
