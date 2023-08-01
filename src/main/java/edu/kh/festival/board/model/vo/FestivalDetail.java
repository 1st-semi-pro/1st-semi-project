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

public class FestivalDetail {

	private int festivalNo; // festival pk와 연결된 fk
	private String festivalContent; // 상세내용
	private String festivalDetailInfo; // 상세정보
	
	private List<FestivalImage> fesImageList;
	
}
