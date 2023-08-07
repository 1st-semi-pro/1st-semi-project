const container = document.getElementsByClassName("container1")[0];
const inputName = document.getElementsByName("memberName")[0];
const inputId = document.getElementsByName("memberId")[0];
const inputEmail = document.getElementsByName("memberEmail")[0];
const inputkey = document.getElementsByName("authenticationKey")[0];
const check = document.getElementsByName("sendEmail-check")[0];
const display = document.getElementById("timer");
let timer;
let isRunning = false;

function findPwValidate(){

	if(inputName.value.trim().length == 0){
		alert("이름을 입력해주세요.");
		inputName.value="";
		inputName.focus();
		return false;
	}

    if(inputId.value.trim().length == 0){
		alert("아이디를 입력해주세요.");
		inputId.value="";
		inputId.focus();
		return false;
	}

    if(inputEmail.value.trim().length == 0){
		alert("이메일을 입력해주세요.");
		inputEmail.value="";
		inputEmail.focus();
		return false;
	}

    if(inputkey.value.trim().length == 0){
		alert("인증번호를 입력해주세요.");
		inputkey.value="";
		inputkey.focus();
		return false;
	}

    if(check.value.trim().length == 0){
		alert("인증번호가 전송되지 않았습니다, 인증번호를 전송 해주세요.");
		return false;
	}
	
    if( sessionStorage.getItem('authenticationKey') != inputkey.value){ // 세션에 있는 인증번호와 입력값이 같지 않으면
        alert("인증번호가 일치하지 않습니다, 다시 확인해주세요.");
		return false;
    }

    if(display.innerText == ""){ //  인증시간이 초과된 경우
        alert("시간이 만료되었습니다. 인증번호를 재전송 해주세요.");
        return false;
    }

    sessionStorage.removeItem('authenticationKey'); //세션에 있는 인증번호 삭제
	return true;
}

document.getElementById("sendEmail-btn").addEventListener("click", function(){
    sessionStorage.removeItem('authenticationKey'); // 이전 인증번호 무효화
    document.getElementsByClassName("divide4")[4].style.display="flex"; // 인증번호 확인란 추가
    container.style.border = "10px solid lightcoral";

    // ajax 코드
    $.ajax({
        url : "sendEmail",
        data : {
            "memberName" : inputName.value,
            "memberId" : inputId.value,
            "memberEmail" : inputEmail.value
        },
        dataType : "JSON",
        type : "POST",
        success : function(key){
            sessionStorage.setItem('authenticationKey', key); // 세션에 값을 담아줌
            check.value="인증번호 전송 완료";
            sendAuthNum();
        },

        error : function(){
            console.log("에러 발생");
        }

    })

    // 타이머 함수 실행
    function sendAuthNum(){
        // 이미 타이머가 작동중이면 초기화
        if (isRunning) clearInterval(timer);
        startTimer(10, display);
    }

    function startTimer(count, display) {
        let minutes, seconds;
        timer = setInterval(function () {
            minutes = parseInt(count / 60, 10);
            seconds = parseInt(count % 60, 10);
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;
            display.innerText = minutes + ":" + seconds;
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