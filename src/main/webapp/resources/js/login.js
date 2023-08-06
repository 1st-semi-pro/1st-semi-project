const inputId = document.getElementById("inputId");
const inputPw = document.getElementById("inputPw");
const sec1 = document.getElementById("sec1");
const sec2 = document.getElementById("sec2");
const cont = document.getElementById("cont");

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
			'아이디 확인',
			'아이디를 입력해주세요.',
			'error',
		  ) 
		
		inputId.value="";
		inputId.focus();

		return false;

	}

	if(inputPw.value.trim() == ""){

		Swal.fire(
			'비밀번호 확인',
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

		if(this.checked != false ){

		if(inputId.value.trim().length == 0){
			
			Swal.fire(
				'아이디 입력 후 체크해주세요.'
			  ) 
		
		}else{

			Swal.fire({
			title: '개인정보를 위해 개인 PC에서만의 사용을 권장합니다.',
			text: "저장하시겠습니까?",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '저장',
			cancelButtonText: '취소'
			}).then((result) => {
			if (result.value) {
					this.checked = true;
				//"저장" 버튼을 눌렀을 때 작업할 내용을 이곳에 넣어주면 된다. 
			}else{
				this.checked = false;
			}
			})
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