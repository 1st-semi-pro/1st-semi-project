package edu.kh.festival.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Dip {
	private int festivalNo; // 축제번호
	private String festivalTitle; // 축제이름
	private String festivalArea; // 축제지역
	private String festivalDate; // 축제기간
	private String festivalImage; // 축제 대표이미지
	
}
