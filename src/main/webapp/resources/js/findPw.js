const inputName = document.getElementsByName("memberName")[0];
const inputId = document.getElementsByName("memberId")[0];
const inputEmail = document.getElementsByName("memberEmail")[0];
const inputkey = document.getElementsByName("authenticationKey")[0];
const check = document.getElementsByName("sendEmail-check")[0];

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
	
    if(check.value != inputkey.value){
        alert("인증번호가 일치하지 않습니다, 다시 확인해주세요.");

		return false;
    }

	return true;

}

document.getElementById("sendEmail-btn").addEventListener("click", function(){
    
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
            console.log(key);
            check.value = key;
        },

        error : function(){
            console.log("에러 발생");
        }

    })
    check.value="인증번호 전송 완료";

})