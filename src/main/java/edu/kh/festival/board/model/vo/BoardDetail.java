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
	
	private int festivalNo; // 축제번호
	private String festivalTitle; // 축제이름
	private String appointmentDate; // 약속날짜
	private int numberOfPeople; // 모집인원
	private String recruit; // 구인 상태
	
	private List<BoardImage> imageList; // boardImage vo만들고 list로 받기
	
}