package edu.kh.festival.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String memberNickname;
	private String createDate;
	private int readCount;
	private String thumbnail;
	private String memberNo;
	private String festivalTitle;
	private String festivalDate;
	private String festivalArea;

}
