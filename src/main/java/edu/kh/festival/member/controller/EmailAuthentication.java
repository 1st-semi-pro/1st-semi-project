package edu.kh.festival.member.controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.festival.member.model.service.MemberService;
import edu.kh.festival.member.model.vo.Member;

import java.io.Console;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

@WebServlet("/member/findPw/changePw")
public class EmailAuthentication extends HttpServlet{
	
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
            if(m==null || !m.getMemberEmail().equals(memberEmail))
            {
                req.setAttribute("message", "아이디나 이메일 정보가 맞지 않습니다");
                //req.setAttribute("loc", "/member/findPw");
                //req.getreqDispatcher("/views/common/msg.jsp").forward(req, resp);
                return;
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        //mail server 설정
        String host = "smtp.naver.com";
        String user = "dbstnrla1124"; //자신의 네이버 계정
        String password = "G3EMTGYG4H5Q";//자신의 네이버 패스워드
        
        //메일 받을 주소
        String to_email = "dbstnrla1124@gmail.com"; //m.getMemberEmail();
        
        //SMTP 서버 정보를 설정한다.
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        
        //인증 번호 생성기
        StringBuffer temp =new StringBuffer();
        Random r = new Random();
        for(int i=0;i<10;i++)
        {
            int rIndex = r.nextInt(3);
            switch (rIndex) {
            case 0:
                // a-z
                temp.append((char) ((int) (r.nextInt(26)) + 97));
                break;
            case 1:
                // A-Z
                temp.append((char) ((int) (r.nextInt(26)) + 65));
                break;
            case 2:
                // 0-9
                temp.append(r.nextInt(10));
                break;
            }
        }
        String AuthenticationKey = temp.toString();
        System.out.println(AuthenticationKey);
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });
        
        //email 전송
        try {
        	System.out.println("1");
        	System.out.println(session);
        	System.out.println("2");
            MimeMessage msg = new MimeMessage(session);
            System.out.println("3");
            msg.setFrom(new InternetAddress(user, "대한민국 축제축제"));
            System.out.println("4");
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
            
            System.out.println("5");
            //메일 제목
            msg.setSubject("안녕하세요 축제축제 인증번호 입니다.");
            System.out.println("6");
            //메일 내용
            msg.setText("인증 번호는 :"+temp);
            
            System.out.println("7");
            Transport.send(msg);
            System.out.println("이메일 전송");
            
            
        }catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
        HttpSession saveKey = req.getSession();
        saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
        //패스워드 바꿀때 뭘 바꿀지 조건에 들어가는 id
        req.setAttribute("id", memberId);
        String path = "/WEB-INF/views/member/changePw.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
    }

	
}
