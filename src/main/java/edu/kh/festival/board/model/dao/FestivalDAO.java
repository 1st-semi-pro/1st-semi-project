package edu.kh.festival.board.model.dao;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class FestivalDAO {
	
	   private Statement stmt;
	   private PreparedStatement pstmt;
	   private ResultSet rs;
	   
	   private Properties prop;
	   
	   public FestivalDAO() {
	      try {
	         prop = new Properties();
	         
	         String filePath = FestivalDAO.class.getResource("/edu/kh/festival/sql/festival-sql.xml").getPath();
	         
	         prop.loadFromXML(new FileInputStream(filePath));
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	   }

}
