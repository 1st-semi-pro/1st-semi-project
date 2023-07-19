package edu.kh.festival.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.festival.member.model.service.MemberService;

@WebServlet("/member/manage")
public class ManageMemberServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		try {
	         
	         int type = Integer.parseInt(req.getParameter("type"));
	         
	         int cp = 1;
	         
	         if(req.getParameter("cp") != null) { 
	        	 cp = Integer.parseInt(req.getParameter("cp"));
	         }
	         
	         MemberService service = new MemberService();
	         
	         // 게시판 이름, 페이지네이션 객체, 게시글 리스트를 한번에 반환하는 Service 호출
	         Map<String, Object> map = service.manageMember(type, cp);
	         
	         // request 범위로 map을 세팅
	         req.setAttribute("map", map);
	         
	         String path = "/WEB-INF/views/member/memberManagement.jsp";
	         
	         RequestDispatcher dispatcher = req.getRequestDispatcher(path);
	         
	         dispatcher.forward(req, resp);
	         // request 범위로 보내줌
	         
	         
	         
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
		
	}

}
