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

import edu.kh.festival.board.model.dao.ReplyDAO;
import edu.kh.festival.board.model.vo.Reply;
import edu.kh.festival.member.model.dao.MemberDAO;

public class ReplyDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public ReplyDAO() {
		
		try {
			prop = new Properties();

			String filePath = MemberDAO.class.getResource("/edu/kh/festival/sql/reply-sql.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	/** 댓글 목록 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return replyList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(Connection conn, int boardNo) throws Exception{
		
		List<Reply> replyList = new ArrayList<Reply>();
		
		try {
			
			String sql = prop.getProperty("selectReplyList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Reply reply = new Reply();
				
				reply.setReplyNo(rs.getInt("REPLY_NO"));
				reply.setReplyContent(rs.getString("REPLY_CT"));
				reply.setCreateDate(rs.getString("REPLY_TI"));
				reply.setBoardNo(rs.getInt("BOARD_NO"));
				reply.setMemberNo(rs.getInt("MEMBER_NO"));
				reply.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
				reply.setProfileImage(rs.getString("MEMBER_PROFILE"));
				
				replyList.add(reply); // 한 댓글의 모든 정보 list로 담기
									  // 댓글 수정일은 안담아옴 할수있으면 하게
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
			
		}
		
		
		return replyList;
	}

	
	/** 댓글 삽입 DAO
	 * @param conn
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Connection conn, Reply reply) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertReply");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getBoardNo());
			pstmt.setInt(3, reply.getMemberNo());
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		return result;
		
	}

	/** 댓글 수정 DAO
	 * @param conn
	 * @param replyNo
	 * @param replyContent
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(Connection conn, int replyNo, String replyContent) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateReply");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, replyContent);
			
			pstmt.setInt(2, replyNo);
			
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
	
		return result;
	}

	/** 댓글 삭제 DAO
	 * @param conn
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReply(Connection conn, int replyNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteReply");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
	
}
