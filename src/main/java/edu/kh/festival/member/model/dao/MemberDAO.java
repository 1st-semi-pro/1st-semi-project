package edu.kh.festival.member.model.dao;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.festival.member.model.vo.Member;

public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
		
	// 기본 생성자
	public MemberDAO() {
		try {
			prop = new Properties();
			
			String filePath =  MemberDAO.class.getResource("/edu/kh/festival/sql/member-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	/** 로그인 DAO
	 * @param mem
	 * @param conn
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem, Connection conn) throws Exception {
		
		Member loginMember = null; 
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			
			System.out.println("mem.getMemberId:: " + mem.getMemberId());
			System.out.println("mem.getMemberPw:: " + mem.getMemberPw());
			
			rs = pstmt.executeQuery();
			
			//System.out.println("rs.next():::" + rs.next());
			
			if(rs.next()) {
				loginMember = new Member();
				
				loginMember.setMemberId(rs.getString("MEMBER_ID"));
				loginMember.setMemberPw(rs.getString("MEMBER_PW"));
				
				System.out.println("loginMember rs:: " + loginMember);
			}
			
			if(true) {
				System.out.println("true입니다");
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember;
		
	}

	}		
		
/*		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			
			System.out.println("mem.getMemberId:: " + mem.getMemberId());
			System.out.println("mem.getMemberPw:: " + mem.getMemberPw());
			
			rs = pstmt.executeQuery();
			
			System.out.println("rs.next():::" + rs.next());
			
			if(rs.next()){
				loginMember = new Member();
				
				loginMember.setMemberId(rs.getString("MEMBER_ID"));
				loginMember.setMemberPw(rs.getString("MEMBER_PW"));
				
				System.out.println("loginMember rs:: " + loginMember);
			}
			
			if(true) {
				System.out.println("true입니다");
			}

			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		System.out.println("loginMember:: " + loginMember);
		return loginMember;
	}
*/

