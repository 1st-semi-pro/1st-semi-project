package edu.kh.festival.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplate {

	/* DB연결, JDBC 자원 반환, 트랜잭션 제어 같은
	 * 반복적으로 사용되는 JDBC 관련 코드를 모아둔 클래스 
	 * 
	 * getConnection() 메소드
	 * 
	 * close( Connection | Statement | ResultSet ) 메소드
	 * --> PreparedStatement는 Statement의 자식이므로
	 * 	   매개변수의 다형성으로 한번에 처리
	 * 
	 * commit(Connection)
	 * rollback(Connection)
	 * 
	 * 
	 * */

	// 필드
	
	private static Connection conn; // 초기값 = null;
	// private static Connection conn = null;
	
	// 메소드
	// DB 연결 정보를 담고 있는 Connection 객체 반환 메소드
	public static Connection getConnection() { // 스태틱끼리만 호출가능
		
		try {
			
			// JNDI(Java Naming and Directory Interface API)
					 //자바에서 부를 이름 // 폴더 //접점
			// - 디렉토리에 접근하는데 사용하는 Java API
			// - 애플리케이션(프로그램, 웹앱)은 JNDI를 이용해서 파일 또는 서버 Resource를 찾을 수 있다.
			
			Context initContext = new InitialContext();	
			
			// servers -> context.xml 파일 찾기
			Context envContext = (Context)initContext.lookup("java:/comp/env"); 
			
			// DBCP 세팅의 <Resource> 태그를 찾아 DataSource 형식의 객체로 얻어오기
			// DataSource : Connection Pool을 구현하는 객체(Connection 얻어오기 가능)
			DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");
			
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return conn;
	
	}
	
	// close() 메소드 작성
	// Connection 반환 메소드
	public static void close(Connection conn) {
		
		try {
			// 참조하는 Connection이 있으면서 닫혀있지 않은 경우
			if(conn != null && !conn.isClosed()) {
				// conn.isClosed() : 닫혀있으면 true 반환
				conn.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	// Statement(부모), PreparedStatement(자식) 반환 메소드(다형성 적용)
	public static void close(Statement stmt) {
		
		try {
			// 참조하는 Connection이 있으면서 닫혀있지 않은 경우
			if(stmt != null && !stmt.isClosed()) {
				// conn.isClosed() : 닫혀있으면 true 반환
				stmt.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// ResultSet 반환 메소드
	public static void close(ResultSet rs) {
		
		try {
			// 참조하는 Connection이 있으면서 닫혀있지 않은 경우
			if(rs != null && !rs.isClosed()) {
				// conn.isClosed() : 닫혀있으면 true 반환
				rs.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	// 트랜잭션 제어
	// commit 반환 메소드
	public static void commit(Connection conn) {
		
		try {
			// 참조하는 Connection이 있으면서 닫혀있지 않은 경우
			if(conn != null && !conn.isClosed()) {
				// conn.isClosed() : 닫혀있으면 true 반환
				conn.commit();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		
		try {
			// 참조하는 Connection이 있으면서 닫혀있지 않은 경우
			if(conn != null && !conn.isClosed()) {
				// conn.isClosed() : 닫혀있으면 true 반환
				conn.rollback();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
