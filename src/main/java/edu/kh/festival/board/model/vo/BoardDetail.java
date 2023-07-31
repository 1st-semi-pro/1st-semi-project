package edu.kh.festival.board.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class BoardDetail {

	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String createDate;
	private String updateDate;
	private int readCount;
	private String boardSt; // 게시글 상태
	private String memberNickname;
	private String profileImage;
	private int memberNo;
	private String boardCd; // 게시판 번호
	
	private List<BoardImage> imageList; // boardImage vo만들고 list로 받기
	
}