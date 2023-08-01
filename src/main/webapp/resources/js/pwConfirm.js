const inputPw = document.getElementById("inputPw");
const realPw = document.getElementById("realPw");

function confirmValidate(){
    if(inputPw.value.trim().length == 0){
		
		alert("비밀번호를 입력해주세요.");
		
		inputPw.value="";
		inputPw.focus();

		return false;
	} 
    
    return true;
}





    

