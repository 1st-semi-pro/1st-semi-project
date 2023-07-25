package edu.kh.festival.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.festival.board.model.service.BoardService;
import edu.kh.festival.board.model.service.ManageService;
import edu.kh.festival.member.model.vo.Member;


@WebServlet("/board/*")
public class MemberManageController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		// /community/reply/selectReplyList
		String contextPath = req.getContextPath();
		// /community
		String command = uri.substring((contextPath + "/board/").length());
		
		ManageService service = new ManageService();
		
		// 전체 회원 조회
		
		
		try {
			if(command.equals("memberList")) {
				
				int type = Integer.parseInt(req.getParameter("type"));
				
				int cp =1;
				
				if(req.getParameter("cp")!=null) { // 쿼리스트링에 "cp"가 존재한다면
					cp = Integer.parseInt(req.getParameter("cp"));
				}
				
				Map<String,Object> map = service.selectAllMember(type, cp);
				
				req.setAttribute("map", map);
				
				String path = "/WEB-INF/views/member/memberManagement.jsp";
				
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				dispatcher.forward(req, resp);
				
			}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req, resp);
	}

}
