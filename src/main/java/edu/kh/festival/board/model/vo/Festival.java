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
	private String festivalCat;
	private String festivalArea;
	private int readCount;
	private int boardCode;
	private String festivalImage;
	
	private List<Festival> festivalList;
	private List<FestivalImage> festivalImageList;
	
	
}
