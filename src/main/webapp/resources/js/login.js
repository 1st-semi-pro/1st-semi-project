const inputId = document.getElementById("inputId");
const inputPw = document.getElementById("inputPw");
const sec1 = document.getElementById("sec1");
const sec2 = document.getElementById("sec2");

// 로그인 유효성 검사
function loginValidate(){
	
	if(inputId.value.trim().length == 0){
		
		alert("아이디를 입력해주세요.");
		
		inputId.value="";
		inputId.focus();

		return false;

	}

	if(inputPw.value.trim() == ""){

		alert("비밀번호를 입력해주세요.");

		inputPw.value="";
		inputPw.focus();

		return false;

	}
	
	return true;

}

// 아이디 저장 
document.getElementById("idSave").addEventListener("change",function(){

	if(this.checked){

		const str = "개인정보를 위해 개인 PC에서만의 사용을 권장합니다. 저장하시겠습니까?";

		if(!confirm(str)){
			this.checked = false;
		}

	}

})


// 효과주기
inputId.addEventListener("focus",function(){

	sec1.style.border = "2px solid lightcoral";

})

inputId.addEventListener("blur",function(){

	if(inputId.value == ""){
		sec1.style.border = "1px solid lightgray";
	}

})

inputPw.addEventListener("focus",function(){

	sec2.style.border = "2px solid lightcoral";

})

inputPw.addEventListener("blur",function(){

	if(inputPw.value == ""){
		sec2.style.border = "1px solid lightgray";
	}

})