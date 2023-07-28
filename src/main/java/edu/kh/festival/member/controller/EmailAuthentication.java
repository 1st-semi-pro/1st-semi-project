package edu.kh.festival.member.controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailAuthentication {
	
	public static void main(String[] args) {
		String username = "dbstnrla1124";
		String password = "G3EMTGYG4H5Q";
		String from = "dbstnrla1124@naver.com";
		String to = "dbstnrla1124@gmail.com";
		String host = "smtp.naver.com";
		int port = 465;
		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", port);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.naver.com");
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Test Subject");
            message.setText("세미프로젝트 이메일인증 테스트");

            Transport.send(message);

            System.out.println("Sent Message successfully");
		}catch (MessagingException e){
            throw new RuntimeException(e);
        }
	}
	
}
