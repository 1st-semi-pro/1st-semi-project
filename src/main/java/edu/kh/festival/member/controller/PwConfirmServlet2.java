package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.festival.member.model.vo.Member;


@WebServlet("/member/pwConfirm/check")
public class PwConfirmServlet2 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputPw = req.getParameter("inputPw");

		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		try {
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
