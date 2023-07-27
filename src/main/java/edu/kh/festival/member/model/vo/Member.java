package edu.kh.festival.member.model.vo;

import java.sql.Date;

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
/*@Getter // getter 자동 추가
@Setter // setter 자동 추가
@ToString // toString 자동 추가
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 초기화하는 매개변수 생성자
*/

//Lombok 라이브러리
//- VO(Value Object) 또는 DTO(Data Transfer Object)에
//	 작성되는 공통 코드(getter/setter/생성자)를 자동 추가해주는 라이브러리

public class Member {

	private int memberNo; // 회원번호
	
	private String memberId; // 회원 아이디
	
	private String memberPw; // 회원 비밀번호
	
	private String memberEmail; // 회원 이메일
	
	private String memberNickname; // 회원 닉네임
	
	private String memberName; // 회원 이름

	private int memberBirth; // 회원 생년월일
	
	private String memberRegion; // 회원 주 활동지역
	
	private String memberGender; // 회원 성별 << 라디오
	
	private String memberNationality; // 회원 국적 << 라디오
	
	private String memberPhone; // 회원 전화번호
	
	private Date enrollDate; // 회원의 가입일
	
	private String adminFl; // 관리자 여부
	
	private String secessionFl; // 회원 탈퇴 여부
	
	public String memberProfileImage; // 회원 프로필 이미지 
	
	public String memberMessage; // 회원 프로필 메세지
	
}


