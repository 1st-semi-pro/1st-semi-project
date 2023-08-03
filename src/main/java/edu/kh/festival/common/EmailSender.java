package edu.kh.festival.common;
 
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSender extends Exception{
    static final String user_email= "dbstnrla1124@gmail.com";
    static final String user_pw = "acdfmhnpwviuenzy";
    static final String smtp_host = "smtp.gmail.com";
    static final int smtp_port = 465;  // TLS : 587, SSL : 465

    public static String sendEmail(String incomingEmail) {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", smtp_host); 
        props.put("mail.smtp.port", smtp_port); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.ssl.enable", "true"); 
        props.put("mail.smtp.ssl.trust", smtp_host);
        
        Session session = Session.getInstance(props,
        		new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                    	return new PasswordAuthentication(user_email, user_pw);
                        }
                    });
        
        StringBuffer temp = new StringBuffer();
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
        
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user_email));

            // 받는 이메일
            message.setRecipients(
                    Message.RecipientType.TO,InternetAddress.parse(incomingEmail)    
            );
	
            // 제목
            message.setSubject("축제축제 이메일 인증입니다."); 
	  
            // 내용
            message.setText("인증번호는 "+AuthenticationKey+ " 입니다." );

            // 발송
            Transport.send(message);
            
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return AuthenticationKey;
    }
}