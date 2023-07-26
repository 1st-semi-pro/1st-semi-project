
  function infoValidate() {
  const tel = document.getElementsByName("memberPhone")[0];
  const regExp2 = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

  if (tel.value.trim() != "" && !regExp2.test(tel.value)) {
    return printAlert(tel, "전화번호 형식이 올바르지 않습니다.");
  }

  const pw = document.getElementById("currentPw");
  const newPw1 = document.getElementById("newPw1");
  const newPw2 = document.getElementById("newPw2");
  const regExp = /^[a-zA-z0-9!@#\-_]{6,30}$/;

  if (pw.value.trim() != "" && !regExp.test(pw.value)) {
    return printAlert(pw, "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.");
  }

  if (newPw1.value.trim() != "" && !regExp.test(newPw1.value)) {
    return printAlert(newPw1, "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.");
  }

  if (newPw2.value.trim() != "" && newPw1.value != newPw2.value) {
    alert("새 비밀번호가 일치하지않습니다");
    return false;
  }

  const memberNickname = document.getElementById("memberNickname");
  const nicknameMessage = document.getElementById("nicknameMessage");

  if (memberNickname.value.trim() != "") {
    const regExp = /^[a-zA-Z0-9가-힣]{2,10}$/;
    if (!regExp.test(memberNickname.value)) {
      return printAlert(memberNickname, "닉네임 형식이 유효하지 않습니다.");
    }
  }

  return true;
}

(function () {
  const outBtn = document.getElementById("outBtn");

  if (outBtn != null) { // 목록으로 버튼이 화면에 있을 때만 이벤트 추가
    outBtn.addEventListener("click", function () {

    /*   // location 객체(BOM)

      // 문자열.substring(시작, 끝) : 시작 이상 끝 미만 인덱스까지 문자열 자르기

      // 문자열.indexOf("검색 문자열", 시작 인덱스)
      // : 문자열에서 "검색 문자열"의 위치(인덱스)를 찾아서 반환
      //   단, 시작 인덱스 이후부터 검색

      const pathname = location.pathname; // 주소상에서 요청 경로 반환
      //      /community/board/detail

      // 이동할 주소 저장
      let url = pathname.substring(0, pathname.indexOf("/", 1));
      //  /community

      url = "/member/main   //  /community/board/list?

      // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
      // location.href : 현재 페이지 주소  쿼리스트링
      // URL.searchParams : 쿼리 스트링만 별도 객체로 변환

      // http://localhost:8080/community/board/detail?no=500&cp=1&type=1
      const params = new URL(location.href).searchParams;

      const type = "type=" + params.get("type");
      const cp = "cp=" + params.get("cp");

      // 조립
      //  /community/board/list?type=1&cp=1
      url = type + "&" + cp; */


      // location.href = "주소"; -> 해당 주소로 이동
      //location.href = "http://localhost:8080/community/board/list?type=1";
      history.go(-1);

    })
  }
})();
