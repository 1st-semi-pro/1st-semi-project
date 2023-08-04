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
	private String festivalDetailInfo; // 상세정보
	private String festivalSlogan; // 슬로건
	private String festivalPhone; // 축제 번호
	private String festivalFreeFl; // 유/무료 여부
	private String festivalYoutube; // 축제 유튜브
	private String festivalRelatedAgencies; // 관련 기관
	private String festivalHomepage; // 축제 홈피
	
	private List<FestivalImage> fesImageList;
	
}
