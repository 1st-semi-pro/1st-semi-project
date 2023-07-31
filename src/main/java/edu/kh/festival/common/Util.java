package edu.kh.festival.common;

public class Util {

	// 개행 문자 -> br로 변경하는 메서드가 담긴 클래스
	
	public static String newLineHandling(String content) {
		
		return content.replaceAll("\r\n|\n|\r|\n\r", "<br>"); //\r\n 일때 먼저 br로 바뀜
	
		// textarea의 엔터 : \r\n
		// \r : 캐리지 리턴(첫 번째로 돌아가기) -> 현재는 개행문자로 인식함
		// \n : new line(다음 줄로 이동)
	
	}
	
	// XSS : 관리자가 아닌 이용자가 악성 스크립트를 삽입해서 공격할 수 있다.
	
	// Cross Site Scripting(XSS, 크로스 사이트 스크럽팅) 공격 방지 처리 메소드
	
	public static String XSSHandling(String content) {
		
		// <, >, &, " 문자를 HTML 코드가 아닌 문자 그대로 보이도록 변경
		
		if(content != null) {
			content = content.replaceAll("&", "&amp;"); // <h1> 밑에쓰면 글자깨짐
			content = content.replaceAll("<", "&lt;"); // &lt;h1> 이렇게 바뀌게 됨. 보여질때는 꺽쇠로 보임.
			content = content.replaceAll(">", "&gt;"); // &lt;h1&gt;
			content = content.replaceAll("\"", "&quot;"); // &lt;h1&gt;
		}
		
		return content;
		
	}
	
	
	
	
}
