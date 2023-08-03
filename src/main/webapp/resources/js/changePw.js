const newPw = document.getElementsByName("newPw")[0];
const newPwCheck = document.getElementsByName("newPwCheck")[0];

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
