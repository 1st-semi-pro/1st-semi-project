package edu.kh.festival.board.model.dao;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import edu.kh.festival.board.model.vo.Pagination;
import edu.kh.festival.member.model.vo.Member;

public class ManageDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	public int getListCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getMemberCount(Connection conn, int type) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
