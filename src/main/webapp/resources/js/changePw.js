const container = document.getElementsByClassName("container1")[0];
const newPw = document.getElementsByName("newPw")[0];
const newPwCheck = document.getElementsByName("newPwCheck")[0];
const span = document.getElementById("password-span");


function changePwValidate(){

	if(newPw.value.trim().length == 0){
		alert("새 비밀번호를 입력해주세요.");
		newPw.value="";
		newPw.focus();

		return false;
	}

    if(newPwCheck.value.trim().length == 0){
		alert("새 비밀번호를 한번 더 입력해주세요.");
		newPwCheck.value="";
		newPwCheck.focus();

		return false;
	}

    if(newPw.value != newPwCheck.value){
        alert("입력하신 비밀번호가 서로 다릅니다. 다시 입력해주세요.");
        newPw.value="";
        newPwCheck.value="";
		newPw.focus();

        return false;
    }

	return true;

}

// 비밀번호

newPw.addEventListener("input",function(){
    
    if(newPw.value.trim().length == 0){
        span.innerText = "비밀번호를 입력해주세요.";
        span.classList.remove("true", "false");
        
        // 비밀번호를 통째로 지워버렸을 때를 대비
        container.style.border = "10px solid lightgray";
        newPw.style.borderBottom = "2px solid lightgray";
        newPwCheck.style.borderBottom = "2px solid lightgray";

        checkInputs.newPw = false;

        return;
    }    
    
    const regExp = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/;
    //(?=.*?)는 전방탐색(lookahead) -> 패턴이 일치하는지 확인하고 다음에 일치할 문자를 건너뛰는 것
    
    //최소 8자 이상, 최대 16자 이하 , 하나 이상의 소문자, 숫자, 특수 문자 (#?!@$%^&-)를 포함
    
    //"비밀번호 : 소문자, 숫자, 특수문자를 포함한 8~16자리로 입력해주세요.";

    if(regExp.test(newPw.value)){ // 비밀번호 유효

        checkInputs.newPw = true; 

        if(newPwCheck.value.trim().length == 0){
            // 비밀번호 유효하면서, 비밀번호 확인이 작성 안됐을 때 경우
            span.innerText = "유효한 비밀번호 형식입니다.";
            span.classList.add("true");
            span.classList.remove("false");
            newPw.style.borderBottom = "2px solid lightcoral";
            

        }else{ // 비밀번호 유효하면서 비밀번호 확인도 작성이 된 경우

            pwCheck(); // 비밀번호 일치  검사 함수를 호출

        }

    }else{

        span.innerText = "비밀번호 : 소문자, 숫자, 특수문자를 포함한 8~16자리로 입력해주세요.";
        span.classList.add("false");
        span.classList.remove("true");
        newPw.style.borderBottom = "2px solid lightgray";

        checkInputs.newPw = false;

    }

})

// -------------------------------------------------------------------------------------- //

// 비밀번호 확인
newPwCheck.addEventListener("input",pwCheck()); // Pwcheck true나 false로

// -------------------------------------------------------------------------------------- //

// 비밀번호 일치 검사

function pwCheck(){

    // 비번 확인을 입력하는데 비번이 유효하지 않다면
    const regExp = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/;
    if(!regExp.test(newPw.value)){
        alert("비밀번호를 올바르게 입력해주세요.");
        newPwCheck.value = "";
        newPw.focus();
        return;
    }


    if(newPw.value != newPwCheck.value){
    
        span.innerText = "비밀번호가 일치하지 않습니다.";
        span.classList.add("false");
        span.classList.remove("true");
        newPwCheck.style.borderBottom = "2px solid lightgray";
        container.style.border = "10px solid lightgray";
        checkInputs.newPwCheck = false;
    
    }else {

        span.innerText = "유효한  비밀번호입니다.";
        span.classList.add("true");
        span.classList.remove("false");
        newPw.style.borderBottom = "2px solid lightcoral";
        newPwCheck.style.borderBottom = "2px solid lightcoral";
        container.style.border = "10px solid lightcoral";

        checkInputs.newPwCheck = true;

    }

}