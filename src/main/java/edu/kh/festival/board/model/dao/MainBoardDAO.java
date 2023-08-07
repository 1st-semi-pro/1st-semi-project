package edu.kh.festival.board.model.dao;

import static edu.kh.festival.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.festival.board.model.vo.Board;
import edu.kh.festival.board.model.vo.BoardDetail;
import edu.kh.festival.board.model.vo.Festival;
import edu.kh.festival.board.model.vo.Pagination;

public class MainBoardDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop; // sql을 읽어와 저장

	public MainBoardDAO() {
		try {
			prop = new Properties();

			String filePath = BoardDAO.class.getResource("/edu/kh/festival/sql/Searchboard-sql.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 메인에서 게시판1 최신글 목록 조회 DAO
	 * 
	 * @param conn
	 * @return boardList1
	 * @throws Exception
	 */
	public List<BoardDetail> selectBoardList(Connection conn) throws Exception {

		List<BoardDetail> boardList1 = new ArrayList<BoardDetail>();

		try {

			String sql = "SELECT * FROM (SELECT * FROM BOARD WHERE BOARD_CD = 2	AND BOARD_ST = 'N' ORDER BY BOARD_NO DESC) WHERE ROWNUM BETWEEN 1 AND 10";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardDetail board = new BoardDetail();

				board.setBoardNo(rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setBoardContent(rs.getString(3));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setMemberNo(rs.getInt("MEMBER_NO"));
				board.setBoardCd(rs.getString("BOARD_CD"));

				boardList1.add(board);
			}
		} finally {
			close(rs);
			close(stmt);
		}

		return boardList1;
	}

	/**
	 * 메인에서 게시판2 최신글 목록 조회 DAO
	 * 
	 * @param conn
	 * @return boardList2
	 * @throws Exception
	 */
	public List<BoardDetail> selectBoardList2(Connection conn) throws Exception {
		List<BoardDetail> boardList2 = new ArrayList<BoardDetail>();

		try {

			String sql = "SELECT * FROM (SELECT * FROM BOARD WHERE BOARD_CD = 3	AND BOARD_ST = 'N' ORDER BY BOARD_NO DESC) WHERE ROWNUM BETWEEN 1 AND 10";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardDetail board = new BoardDetail();

				board.setBoardNo(rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setBoardContent(rs.getString(3));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setMemberNo(rs.getInt("MEMBER_NO"));
				board.setBoardCd(rs.getString("BOARD_CD"));

				boardList2.add(board);
			}
		} finally {
			close(rs);
			close(stmt);
		}

		return boardList2;
	}

	/**
	 * 메인에서 게시판3 최신글 목록 조회 DAO
	 * 
	 * @param conn
	 * @return boardList3
	 * @throws Exception
	 */
	public List<BoardDetail> selectBoardList3(Connection conn) throws Exception {
		List<BoardDetail> boardList3 = new ArrayList<BoardDetail>();

		try {

			String sql = "SELECT * FROM (SELECT * FROM BOARD WHERE BOARD_CD = 4	AND BOARD_ST = 'N' ORDER BY BOARD_NO DESC) WHERE ROWNUM BETWEEN 1 AND 10";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardDetail board = new BoardDetail();

				board.setBoardNo(rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setBoardContent(rs.getString(3));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setMemberNo(rs.getInt("MEMBER_NO"));
				board.setBoardCd(rs.getString("BOARD_CD"));

				boardList3.add(board);
			}
		} finally {
			close(rs);
			close(stmt);
		}

		return boardList3;
	}

	/**
	 * 게시글 이름 조회 DAO
	 * 
	 * @param conn
	 * @param type
	 * @return boardName
	 * @throws Exception
	 */
	public String selectBoardName(Connection conn, int i) throws Exception {
		String boardName = null;

		try {
			String sql = prop.getProperty("selectBoardName");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				boardName = rs.getString(1);
			}

		} finally {
			close(rs);
			close(stmt);
		}

		return boardName;
	}

	public List<Board> searchBoardList(Connection conn, int i, String query) throws Exception {
		List<Board> boardList = new ArrayList<Board>();
		try {

				String sql = prop.getProperty("searchBoardList1") + " AND (BOARD_CONTENT LIKE '%" + query + "%' OR BOARD_TITLE LIKE '%" + query + "%') " + prop.getProperty("searchBoardList2");

				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, i);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					Board board = new Board();

					board.setBoardNo(rs.getInt("BOARD_NO"));
					board.setBoardTitle(rs.getString("BOARD_TITLE"));

					String preStr = rs.getString("BOARD_CONTENT");

					// --- 게시글 내용 가져와서 15자만 미리보기로 보여줌 ---
					if (preStr.length() > 30) {
						preStr = preStr.substring(0, 15) + "..."; // 자르고 ... 붙이기
					}
					board.setBoardContent(preStr);
					
					board.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
					board.setCreateDate(rs.getString("CREATE_DT"));
					board.setReadCount(rs.getInt("READ_COUNT"));

					boardList.add(board);
				}
			
		} finally {

			close(rs);
			close(pstmt);
		}

		return boardList;
	}

	
	public List<Festival> selectFestival1(Connection conn) throws Exception {
		
		List<Festival> festivalList1 = new ArrayList<Festival>();
		
		try {
			
			String sql = "SELECT * FROM(\r\n"
					+ "SELECT * FROM FESTIVAL_IMG JOIN INFO_BOARD ON (FESTIVAL_NO = IMG_NO)\r\n"
					+ "WHERE FESTIVAL_AREA = '서울특별시' AND IMG_LEVEL = 0 ORDER BY READ_COUNT DESC)\r\n"
					+ "WHERE ROWNUM BETWEEN 1 AND 4";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Festival festival = new Festival();
				
				festival.setFestivalNo(rs.getInt("FESTIVAL_NO"));
				festival.setFestivalTitle(rs.getString("FESTIVAL_TITLE"));
				festival.setFestivalImage(rs.getString("IMG_RENAME"));
				
				festivalList1.add(festival);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		return festivalList1;
	}

	public List<Festival> selectFestival2(Connection conn) throws Exception {
		List<Festival> festivalList2 = new ArrayList<Festival>();
		
		try {
			
			String sql = "SELECT * FROM(\r\n"
					+ "SELECT * FROM FESTIVAL_IMG JOIN INFO_BOARD ON (FESTIVAL_NO = IMG_NO)\r\n"
					+ "WHERE FESTIVAL_AREA = '경기도' AND IMG_LEVEL = 0 ORDER BY READ_COUNT DESC)\r\n"
					+ "WHERE ROWNUM BETWEEN 1 AND 4";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Festival festival = new Festival();
				
				festival.setFestivalNo(rs.getInt("FESTIVAL_NO"));
				festival.setFestivalTitle(rs.getString("FESTIVAL_TITLE"));
				festival.setFestivalImage(rs.getString("IMG_RENAME"));
				
				festivalList2.add(festival);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		return festivalList2;
	}

	public List<Festival> selectFestival3(Connection conn) throws Exception {
		List<Festival> festivalList3 = new ArrayList<Festival>();
		
		try {
			
			String sql = "SELECT * FROM(\r\n"
					+ "SELECT * FROM FESTIVAL_IMG JOIN INFO_BOARD ON (FESTIVAL_NO = IMG_NO)\r\n"
					+ "WHERE FESTIVAL_AREA = '인천' AND IMG_LEVEL = 0 ORDER BY READ_COUNT DESC)\r\n"
					+ "WHERE ROWNUM BETWEEN 1 AND 4";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Festival festival = new Festival();
				
				festival.setFestivalNo(rs.getInt("FESTIVAL_NO"));
				festival.setFestivalTitle(rs.getString("FESTIVAL_TITLE"));
				festival.setFestivalImage(rs.getString("IMG_RENAME"));
				
				festivalList3.add(festival);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		return festivalList3;
	}

	public List<Board> companionList(Connection conn) throws Exception {
		
		List<Board> companionList = new ArrayList<Board>();
		
		try {
			String sql = "SELECT * FROM(\r\n"
					+ "		   SELECT ROWNUM RNUM, A.* FROM(\r\n"
					+ "		   		SELECT BOARD_NO, BOARD_TITLE,BOARD_CONTENT, MEMBER_NO, MEMBER_NICKNAME, MEMBER_PROFILE, FESTIVAL_TITLE,FESTIVAL_AREA,FESTIVAL_DT,FESTIVAL_NO,\r\n"
					+ "		 		TO_CHAR(CREATE_DT, 'YYYY-MM-DD')AS CREATE_DT \r\n"
					+ "		 FROM BOARD B\r\n"
					+ "             JOIN INFO_BOARD USING (FESTIVAL_NO)\r\n"
					+ "             JOIN MEMBER USING(MEMBER_NO)\r\n"
					+ "			 WHERE B.BOARD_CD = 5\r\n"
					+ "		 	AND BOARD_ST = 'N'\r\n"
					+ "			ORDER BY FESTIVAL_NO DESC"
					+ "		 	\r\n"
					+ "		 	) A\r\n"
					+ "		 )\r\n"
					+ "		 	WHERE RNUM BETWEEN 1 AND 10";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setCreateDate(rs.getString("CREATE_DT"));
				board.setMemberNo(rs.getInt("MEMBER_NO"));
				board.setFestivalTitle(rs.getString("FESTIVAL_TITLE"));
				board.setFestivalArea(rs.getString("FESTIVAL_AREA"));
				board.setFestivalDate(rs.getNString("FESTIVAL_DT"));
				board.setFestivalNo(rs.getInt("FESTIVAL_NO"));
				board.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
				board.setMemberProfile(rs.getString("MEMBER_PROFILE"));
				

				companionList.add(board);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return companionList;
	}

}