package edu.kh.festival.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.festival.common.EmailSender;
import edu.kh.festival.member.model.service.ConfirmService;
import edu.kh.festival.member.model.vo.Member;



@WebServlet("/member/findId/sendEmail")
public class SendEmailServletForId extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputName = req.getParameter("inputName");
		String inputEmail = req.getParameter("inputEmail");
		
		
		
		System.out.println(inputName);
		System.out.println(inputEmail);
		
		ConfirmService service = new ConfirmService();
		
		try {
			// 이름, 이메일이 일치하는 회원수 조회해서 존재하면 인증번호 발송, 0이면 미실행
			Member member = service.checkEmail(inputName, inputEmail);
			String findedId = member.getMemberId();
			
			
			if(findedId != null) {
				
				String key1 = EmailSender.sendEmail(inputEmail);
				
	
				 new Gson().toJson(key1, resp.getWriter());
				 new Gson().toJson(findedId, resp.getWriter());
				 
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
