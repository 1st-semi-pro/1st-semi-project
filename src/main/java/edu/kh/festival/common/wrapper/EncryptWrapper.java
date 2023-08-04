package edu.kh.festival.common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

// HttpServletRequest의 getparameter 메소드를 오버라이딩 하기위해 만든 클래스
// 서블릿으로 넘어가기 전 필터를 거쳐서 모든 pw에 대해 parameter로 넘길 때 암호화 하겠다.
public class EncryptWrapper extends HttpServletRequestWrapper {

	
	// HttpServletRequest 객체를 매개변수로 전달
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
	// pw들만 name으로 갖고 와서 암호화 한다.
		
		String value = null;
		
		switch(name) {
			
		case "inputPw" : case "newPw" : case "newPwCheck" : // getParameter("inputPw")
			
			value = getSha512(super.getParameter(name)); //(switch에 pw만 넣었음)
			break;
			
			default : value = super.getParameter(name); // 비번이 아니라면 원래 getParameter 메소드 방식을 사용
			
		}
		
		return value;
	}
	
	private String getSha512(String pw) { // String pw = 암호화 되기 전 비번
		
		String encryptPw = null; // 암호화 할 비번이 담길 변수
		
		MessageDigest md = null; // 해시 함수 수행할 객체
		
		try {
			
			md = MessageDigest.getInstance("SHA-512"); // SHA-512 방식의 해시함수 수행할수 잇는 객체 얻어오기 
			
			byte[] bytes = pw.getBytes(Charset.forName("UTF-8")); // pw 를 byte[] 형태로 변환
			
			md.update(bytes); // 암호화 수행 -> md에 저장
			
			encryptPw = Base64.getEncoder().encodeToString(md.digest());
			// md에 저장된 암호화된 pw를 encryptPw에 대입. byte[]를 String으로 변환함.
			// base64는 byte코드를 String으로 변환하는 객체
			
			// test
			System.out.println("암호화 전 암호 : " + pw);
			System.out.println("암호화 후 암호 : " + encryptPw);
			
		}catch(Exception e) { // NoSuchAlgorithmException -> SHA-512 해시함수가 존재하지 않을 때 예외
			e.printStackTrace();
		}
		
		return encryptPw;
		
	}
	
}
