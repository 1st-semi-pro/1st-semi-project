package edu.kh.festival.member.controller;

import java.util.List;

import java.util.Properties;

import javax.mail.Address;

import javax.mail.Authenticator;

import javax.mail.Message;

import javax.mail.PasswordAuthentication;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

public class mailtest {

	

	public static void send(List<String> toMail, String fromMail, String message, String title,String gmail, String id, String pwd)throws Exception{

		Properties p = new Properties();

		p.put("mail.smtp.user", "gudtjr1350@gmail.com"); 

		p.put("mail.smtp.host", "smtp.gmail.com");

		p.put("mail.smtp.port", "465");

		p.put("mail.smtp.starttls.enable","true");

		p.put( "mail.smtp.auth", "true");

		

		p.put("mail.smtp.debug", "true");

		p.put("mail.smtp.socketFactory.port", "465"); 

		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 

		p.put("mail.smtp.socketFactory.fallback", "false");    

		

		Authenticator auth = new SMTPAuthenticator(id,pwd);

		Session session = Session.getInstance(p, auth);

		session.setDebug(true); // 메일을 전송할 때 상세한 상황을 콘솔에 출력한다.

		

		MimeMessage msg = new MimeMessage(session);

		msg.setSubject(title,"UTF-8");

		Address fromAddr = new InternetAddress("gudtjr1355@gmail.com"); // 보내는 사람의 메일주소

		msg.setFrom(fromAddr);

		

		  InternetAddress[] addressTo = new InternetAddress[toMail.size()];

		  for (int i = 0; i < toMail.size(); i++) {

		   addressTo[i] = new InternetAddress(toMail.get(i));

		  }

		  msg.setRecipients(Message.RecipientType.TO, addressTo);

		



		msg.setContent(message, "text/html;charset=utf-8");

		  

		Transport.send(msg);

	}

	

	public static class SMTPAuthenticator extends javax.mail.Authenticator {

		String id;

		String pwd;

		

		SMTPAuthenticator(String id , String pwd){

			this.id = id;

			this.pwd = pwd;

		}

		public PasswordAuthentication getPasswordAuthentication() {

			return new PasswordAuthentication("gudtjr1355", "kxmivfdbnyboskpt"); //구글아이디는 구글계정에서 @이후를 제외한 값이다. (예: abcd@gmail.com --> abcd)

		}

	} 

}