const checkInputs = {

    "memberNickname" : false,
    "memberEmail" : false,
    "emailBtn" : false
    

}

const memberNickname = document.getElementById("memberNickname");
const in2 = document.getElementById("innerTextSpan2");

memberNickname.addEventListener("input",function(){
    if(memberNickname.value.trim().length == 0){
        in2.innerText = "2~12글자 사이의 영어/숫자/한글로 입력해주세요.";
        in2.classList.remove("true","false");
        checkInputs.memberNickname = false;
        return;
    }

    const repExp = /^[가-힇a-zA-Z0-9]{2,12}$/;
    
    if(repExp.test(memberNickname.value)){ // 닉네임이 유효하다면
        $.ajax({ // 닉네임 중복검사
         
            url : "NicknameDupCheck",

            data : {"memberNickname" : memberNickname.value},

            type : "GET",

            success : function(result){

                if( result > 0){

                    in2.innerText = "이미 사용중인 닉네임입니다.";
                    in2.classList.add("false");
                    in2.classList.remove("true");
                    memberNickname.style.color="red";

                    checkInputs.memberNickname = false;

                }else{

                    in2.innerText = "사용 가능한 닉네임입니다.";
                    in2.classList.add("true");
                    in2.classList.remove("false");
                    memberNickname.style.color="blue";
                    
                    checkInputs.memberNickname = true;

                }

            },

            error: function(){
                console.log("에러 발생");
            }

        })

    }else{

        in2.innerText = "닉네임 : 2~12글자 사이의 영어/숫자/한글로 입력해주세요.";

        in2.classList.add("false");
        in2.classList.remove("true");

       checkInputs.memberNickname = false; // 유효 x 기록

    }


})
function infoValidate(){

  console.log("myPage.js loaded.");
/*   const nick = document.getElementsByName("memberNickname")[0]; */
  const tel = document.getElementsByName("memberPhone")[0];

 
  /* 선생님 */
  const regExp1= /^[a-zA-z0-9가-힣]{2,10}$/;
  const regExp2= /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

/*   if(nick.value.trim()==""){
      alert("닉네임을 입력해주세요")
      nick.focus();
      return false;
  }
  if(!regExp1.test(nick.value)){
      alert("닉네임은 영어/숫자/한글 2~10글자 사이로 작성해주세요")
      nick.focus();
      return false;
  } */

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


// 경고 출력 + 포커스 + false 반환 함수
function printAlert(el, message){ // 매개변수 el 요소
  
  alert(message);
  el.focus();
  return false;

}
//--------------------------------------------------------------------//
/* 비밀번호 변경 */
function changePwValidate(){

  const pw = document.getElementById("currentPw");
  const newPw1 = document.getElementById("newPw1");
  const newPw2 = document.getElementById("newPw2");

  const regExp= /^[a-zA-z0-9!@#\-_]{6,30}$/

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
const memberEmail = document.getElementById("memberEmail");
const emailBtn = document.getElementById("emailBtn");
const in1 = document.getElementById("innerTextSpan");
var authenticationInput = document.getElementById("authenticationInput");
var authenticationButton = document.getElementById("authenticationButton");

const display = document.getElementById("timer");
let timer;
let isRunning = false;
// ----------------------------------------------------------------------------- //
// 이메일 인증 
emailBtn.addEventListener("click", function(){


    if(checkInputs.memberEmail != true){
        Swal.fire(
            '이메일',
            '유효한 이메일을 입력해주세요.',
            'error'
          )
        checkInputs.emailBtn = false;
        return;
    }

    $.ajax({
        url : "emailcheck",

        data : {"Email" : memberEmail.value},

        type : "GET",

        dataType : "JSON",

        success : function(key){
            if(key == ""){

                Swal.fire(
                    '인증번호 전송 실패.',
                    'error'
                  )
                checkInputs.emailBtn = false;
                return;

            }else{
                Swal.fire(
                    '인증번호를 전송했습니다.'
                    )
                    sendAuthNum();
                authenticationInput.setAttribute('type','text');
                authenticationButton.setAttribute('type','button'); 
                authenticationButton.value = "인증";  
                in2.innerText = "";
            
                authenticationButton.addEventListener("click",function(){

                    if(key == authenticationInput.value){

                        console.log("에이짺쓰 성공");
                        Swal.fire(
                            '인증번호가 일치합니다.',
                            '성공',
                            'success'
                          )
                          in2.innerText = "사용 가능한 이메일 입니다.";
                        checkInputs.emailBtn = true;
                        clearInterval(timer);
                        display.innerText = "";
                        

                        }else{
                        Swal.fire(
                            '인증번호가 일치하지 않습니다.',
                            '실패',
                            'error'
                          )
                          in2.innerText = "이메일 인증 에러 발생";
                        checkInputs.emailBtn = false;
                    }
              
                })

            }

        },

        error : function(){

        }
        

    })

    // 타이머 함수 실행
    
    function sendAuthNum(){
       // 이미 타이머가 작동중이면 초기화
       if (isRunning) clearInterval(timer);
       startTimer(60*3, display);
    }
    
    function startTimer(count, display) {
       let minutes, seconds;
       timer = setInterval(function () {
           minutes = parseInt(count / 60, 10);
           seconds = parseInt(count % 60, 10);
           minutes = minutes < 10 ? "0" + minutes : minutes;
           seconds = seconds < 10 ? "0" + seconds : seconds;
           display.innerText ="남은 시간 : " + minutes + "분 " + seconds +"초";
           // 타이머 종료
           if (--count < 0) {
               clearInterval(timer);
               display.innerText = "";
               isRunning = false;
           }
       }, 1000);
       isRunning = true;
    }
})





//const in2 = document.getElementById("innerTextSpan2");
memberEmail.addEventListener("input", function(){

    // 입력이 되지 않은 경우
    if(memberEmail.value.trim().length == 0){
        in2.innerText = "메일을 받을 수 있는 이메일을 입력해주세요.";
        in2.classList.remove("confirm", "error");

        checkInputs.memberEmail = false; // 유효하지 않은 상태임을 기록
        return;
    }

    // 입력된 경우
    const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

    $.ajax({
    url : "emailDupCheck", // ★★★★ 필수 속성 url ★★★★
    
    // 현재 주소 : /community/member/signUp
    // 상대 주소 : /community/member/emailDupCheck

    data : { "memberEmail" : memberEmail.value},
    // data속성 : 비동기 통신 시 서버로 전달할 값을 작성(JS 객체 형식)
    // -> 비동기 통신 시 input에 입력된 값을 "memberEmail" 이라는 key 값(파라미터) 전달

    type : "GET", // 데이터 전달 방식 type /안적으면 get이 기본값/

    success : function(result){

        // 비동기 통신(ajax)가 오류없이 요청 / 응답 성공한 경우

        // 매개변수 result : servlet에서 출력된 result 값이 담겨있음

            if(result >0){ // 중복 o

                in2.innerText = "이미 사용중인 이메일 입니다.";
                in2.classList.add("error");
                in2.classList.remove("confirm");
                in2.style.color="red";
                checkInputs.memberEmail = false; // 유효 X 기록

            } else{ // 중복 x

                in2.innerText = "이메일 인증 가능합니다.";
                in2.classList.add("confirm");
                in2.classList.remove("error");
                in2.style.color="blue";
                checkInputs.memberEmail = true; // 유효 O 기록
            }
    },
            
    error  : function(){

        console.log("에러발생");
    }
}); 
})
//-----------------------------------------------------------------//
/* 회원탈퇴 */

function secessionValidate() {

  const memberPw = document.getElementById("memberPw");
  const agree = document.getElementById("agree");

  if(memberPw.value.trim() == "") {
      return printAlert(memberPw, "비밀번호를 입력해주세요.");
  }
  if(!agree.checked) {
      return printAlert(agree, "약관 동의 후 탈퇴 버튼을 클릭해주세요");
  }

  // 정말 탈퇴할지 확인
  // - window.confirm("내용") : 대화 상자에 확인/취소 생성
  //      -> 확인 클릭시 true / 취소 클리식 false

  if(!confirm("정말 탈퇴 하시겠습니까?")){ // 취소를 눌렀을 때
      return false
  } 
  return true;
}



