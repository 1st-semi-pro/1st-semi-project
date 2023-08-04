package edu.kh.festival.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.festival.member.model.service.AssessService;

@WebServlet("/member/myPage2/*")
public class assessController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); 
		String contextPath = req.getContextPath(); 
		String command = uri.substring(  (contextPath + "/member/myPage2/").length());
		
		AssessService service = new AssessService();
		
		try {
			
			if(command.equals("good")) {
				int recNo = Integer.parseInt(req.getParameter("recNo"));
				int goodNo = Integer.parseInt(req.getParameter("goodNo"));
				
				System.out.println("goodNO : " + goodNo);
				System.out.println("recNo : " + recNo);
				
				// 중복 조회
				int check = service.checkAssess(recNo, goodNo);
				
				// 조회해서 존재하면 삭제/ 없으면 추가
				if(check == 0) {
					// 추가
					int result = service.addAssess(recNo, goodNo);
					
				} else {
					int result = service.deleteAssess(recNo, goodNo);
				}
				
				// 칭찬횟수 출력
				int assessNum = service.selectAssess(goodNo);
				
				new Gson().toJson( assessNum, resp.getWriter());
			}
			
			
			if(command.equals("bad")) {
				int recNo = Integer.parseInt(req.getParameter("recNo"));
				int badNo = Integer.parseInt(req.getParameter("badNo"));
				
				
				// 중복 조회
				int check = service.checkAssess1(recNo, badNo);
				
				// 조회해서 존재하면 삭제/ 없으면 추가
				if(check == 0) {
					// 추가
					int result = service.addAssess1(recNo, badNo);
					
				} else {
					int result = service.deleteAssess1(recNo, badNo);
				}
				
				
				// 칭찬횟수 출력
				int assessNum1 = service.selectAssess1(badNo);
				
				new Gson().toJson( assessNum1, resp.getWriter());
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
