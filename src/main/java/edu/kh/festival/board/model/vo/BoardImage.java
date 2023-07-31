package edu.kh.festival.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor

public class BoardImage {

	private int imageNo;
	private int imageLevel;
	private String imageReName;
	private String imageOriginal;
	
	private int boardNo;
	
}
