const inputId = document.getElementById("inputId");
const inputPw = document.getElementById("inputPw");
const sec1 = document.getElementById("sec1");
const sec2 = document.getElementById("sec2");

// 로그인 유효성 검사

/* 즉시실행 - 아이디 저장하면 페이지 들어가자마자 아이디 있어서 border주기 */
(function(){

	if(inputId.value.trim().length != 0){
		sec1.style.border = "2px solid lightcoral";
	}
		
})()




function loginValidate(){
	
	if(inputId.value.trim().length == 0){
		
		Swal.fire(
			'아이디 오류',
			'아이디를 입력해주세요.',
			'error'
		  )

		inputId.value="";
		inputId.focus();

		return false;

	}

	if(inputPw.value.trim() == ""){

		Swal.fire(
			'비밀번호 오류',
			'비밀번호를 입력해주세요.',
			'error'
		  )

		inputPw.value="";
		inputPw.focus();

		return false;

	}
	
	return true;

}

// 아이디 저장 
document.getElementById("idSave").addEventListener("change",function(){


	Swal.fire(
		festivalTitle ,
		'축제를 찜하셨습니다.',
		'success'
	  )

	/* if(this.checked){

	
	} */

		
		/* const str = "개인정보를 위해 개인 PC에서만의 사용을 권장합니다. 저장하시겠습니까?";

		if(!confirm(str)){
			this.checked = false;
		} */

	

})

// 아이디가 쿠키에 남아서 저장되어있다면



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