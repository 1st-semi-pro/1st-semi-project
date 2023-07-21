function sendEmailVerification() {
  // 이메일 인증 버튼 동작
}

function sendPhoneNumberVerification() {
  // 휴대폰 번호 변경 버튼 동작
  const tel = document.getElementsByName("memberTel")[0];
  const regExp2= /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;
  
    if(tel.value.trim()==""){
      alert("전화번호를 입력해주세요.(-제외)")
      tel.focus();
      return false;
    }
    if(!regExp2.test(tel.value)){
      /* alert("전화번호 형식이 올바르지 않습니다.")
      tel.focus();
      return false; */

      return printAlert(tel,"전화번호 형식이 올바르지 않습니다.");
    }

  return true; // true를 반환해서 form 제출 수행

}

function changePassword() {
  // 비밀번호 변경 버튼 동작
 
  const pw = document.getElementById("currentPw");
  const newPw1 = document.getElementById("newPw1");
  const newPw2 = document.getElementById("newPw2");

  const regExp= /^[a-zA-z0-9!@#\-_]{6,30}$/;

  if(pw.value.trim()==""){
      return printAlert(pw,"현재 비밀번호를 입력해주세요");
  }
  if(newPw1.value.trim()==""){
      return printAlert(newPw1,"새 비밀번호를 입력해주세요");
  }
  if(!regExp.test(newPw1.value)){
      return printAlert(newPw1,"영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.");
  }
  if(newPw2.value.trim()==""){
      return printAlert(newPw2,"새 비밀번호 확인을 입력해주세요");
  }
  if(newPw1.value!=newPw2.value){
      alert("새 비밀번호가 일치하지않습니다");
      return false;
  }
  
  return true;
}


// 닉네임 유효성 검사
const memberNickname = document.getElementById("memberNickname");
const nicknameMessage = document.getElementById("nicknameMessage");

memberNickname.addEventListener("input", function(){

    // 입력되지 않은 경우
    if(memberNickname.value.trim().length == 0){
        nicknameMessage.innerText = "영어/숫자/한글 2~10글자 사이로 작성해주세요.";
        nicknameMessage.classList.remove("confirm", "error");
        checkObj.memberNickname = false; // 유효 X 기록
        return;
    }

    const regExp = /^[a-zA-Z0-9가-힣]{2,10}$/; 

    if(regExp.test(memberNickname.value)){ // 유효한 경우
        
        // ************* 닉네임 중복 검사(ajax) 진행 예정 *************
        $.ajax({
            
            url : "nicknameDupCheck", // 필수 작성 속성
            data : { "memberNickname" : memberNickname.value }, // 서버로 전달할 값(파라미터)
            type : "GET", // 데이터 전달 방식(기본값 GET)

            success : function(rs){  // 비동기 통신 성공 시(에러 발생 X)

                if(rs == 0){ // 중복 x

                    nicknameMessage.innerText = "사용 가능한 닉네임입니다.";
                    nicknameMessage.classList.add("confirm");
                    nicknameMessage.classList.remove("error");
                    checkObj.memberNickname = true; // 유효 O 기록

                }else{ // 중복 O

                    nicknameMessage.innerText = "이미 사용중인 닉네임입니다.";
                    nicknameMessage.classList.add("error");
                    nicknameMessage.classList.remove("confirm");
                    checkObj.memberNickname = false; // 유효 X 기록
                }
            },
            error : function(){ // 비동기 통신 중 에러가 발생한 경우
                console.log("에러 발생");
            }
        });
    } else{
        nicknameMessage.innerText = "닉네임 형식이 유효하지 않습니다.";
        nicknameMessage.classList.add("error");
        nicknameMessage.classList.remove("confirm");
        checkObj.memberNickname = false; // 유효 X 기록
    }

});


  // 나가기 버튼 동작
  (function(){
    const outBtn = document.getElementById("outBtn");

    if(outBtn != null){ // 목록으로 버튼이 화면에 있을 때만 이벤트 추가
      outBtn.addEventListener("click", function(){

            // location 객체(BOM)

            // 문자열.substring(시작, 끝) : 시작 이상 끝 미만 인덱스까지 문자열 자르기

            // 문자열.indexOf("검색 문자열", 시작 인덱스)
            // : 문자열에서 "검색 문자열"의 위치(인덱스)를 찾아서 반환
            //   단, 시작 인덱스 이후부터 검색

            const pathname = location.pathname; // 주소상에서 요청 경로 반환
            //      /community/board/detail

            // 이동할 주소 저장
            let url = pathname.substring(0,pathname.indexOf("/", 1));
            //  /community

            url += "/member/myPage"   //  /community/board/list?

            // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
            // location.href : 현재 페이지 주소 + 쿼리스트링
            // URL.searchParams : 쿼리 스트링만 별도 객체로 변환

            // http://localhost:8080/community/board/detail?no=500&cp=1&type=1
            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type");
            const cp = "cp=" + params.get("cp");

            // 조립
            //  /community/board/list?type=1&cp=1
            url += type + "&" + cp;


            // location.href = "주소"; -> 해당 주소로 이동
            //location.href = "http://localhost:8080/community/board/list?type=1";
            //history.go(-1);

        })
    }
})();

function save() {
  // 저장하기 버튼 동작

}

// 경고 출력 + 포커스 + false 반환 함수
function printAlert(el, message){ // 매개변수 el 요소
    
  alert(message);
  el.focus();
  return false;

}
  