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
public class Festival {
	
	private int festivalNo;
	private String festivalTitle;
	private String festivalContent;
	private String festivalDate;
	private String readCount;
	private int boardCode;
	
	private List<Festival> imageList;

}
