package edu.kh.festival.member.controller;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mailTest")
public class SendEmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 이메일 설정 정보
    	System.out.println("test1");
    	
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "gudtjr1350@gmail.com";
        String password = "g";
        
        // 보내는 이메일 주소와 수신자 정보
        String senderEmail = "gudtjr1350@gmail.com";
        String recipientEmail = "gudtjr1355@gmail.com"; /*request.getParameter("recipientEmail");
        */
        // 이메일 제목과 내용
        String subject = "이메일 인증 코드";
        String content = "인증 코드: " + generateVerificationCode();
        
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        try {
            Session session = Session.getInstance(properties, authenticator);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            // 인증 코드를 세션 등의 저장소에 저장하는 코드 작성

			/* response.sendRedirect("verification.jsp"); */
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String generateVerificationCode() {
    	int codeLength = 6;
        
        // 사용할 문자들
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        // 인증 코드 생성
        StringBuilder code = new StringBuilder();
        
        for (int i = 0; i < codeLength; i++) {
            int index = (int) (Math.random() * characters.length());
            code.append(characters.charAt(index));
        }
        
        return code.toString();
    }
}
