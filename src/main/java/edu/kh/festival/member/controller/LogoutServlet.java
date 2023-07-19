package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/member/logout")
public class LogoutServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션 얻어오기 (로그인하면 담겨있음)
		HttpSession session = req.getSession();

		// Session 자체 없애기 (현재 세션 없애면 자동으로 세션 생성)
		session.invalidate();
		
		// 메인페이지로 (다시 로그인하는 창으로 바뀜)
		resp.sendRedirect(req.getContextPath());
		
	}
	
}
