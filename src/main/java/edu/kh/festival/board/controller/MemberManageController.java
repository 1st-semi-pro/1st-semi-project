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
		String contextPath = req.getContextPath();
		String command = uri.substring((contextPath + "/board/").length());
		
		ManageService service = new ManageService();
		
		// 전체 회원 조회
		
		
		try {
			if(command.equals("memberList")) {
				
				
				
				int cp =1;
				
				if(req.getParameter("cp")!=null) { // 쿼리스트링에 "cp"가 존재한다면
					cp = Integer.parseInt(req.getParameter("cp"));
				}
				
				
				Map<String,Object> map = null;
				
				if(req.getParameter("ctg") == null) {
					map = service.selectAllMember(cp);
				} else {
					String ctg = req.getParameter("ctg");
					String search = req.getParameter("search");
					
					map = service.searchBoardList(cp, ctg, search);
				}
				
				req.setAttribute("map", map);
				
				// 선택된 회원 탈퇴
				
				if(req.getParameter("checkRow") != null) {
					
					String[] checkRow = req.getParameterValues("checkRow");
					for(int i = 0 ; i < checkRow.length ; i++) {
						
						int result = service.deleteMember(checkRow);
						
					}
				}
				      
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
