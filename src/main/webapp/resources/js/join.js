// ----------------------------------------------------------------------------- //

/* 정규식 */
const inputId = document.getElementById("inputId");
const inputPw = document.getElementById("inputPw");
const inputPwCheck = document.getElementById("inputPwCheck");
const in1 = document.getElementById("innerTextSpan1");

const memberNickname = document.getElementById("memberNickname");
const memberName = document.getElementById("memberName");
const memberBirth = document.getElementById("memberBirth");

/* select 박스 감싼 div에서 select 된 값 가져오는법 찾기 */
const regionSelect = document.getElementById("regionSelect");


/* genderNationality div 안에 감싸져있는 div 각각 radio 2개씩 이슴 */
const gender = document.getElementById("gender");
const nationality = document.getElementById("nationality");

const memberPhone = document.getElementById("memberPhone");

const inputEmail = document.getElementById("inputEmail");
const in2 = document.getElementById("innerTextSpan2");

const secondBox = document.getElementById("secondBox");

/* 라디오 선택부분 */
const manDiv = document.getElementById("manDiv");
const womanDiv = document.getElementById("womanDiv");
const manLabel = document.getElementById("manLabel");
const womanLabel = document.getElementById("womanLabel");
const korDiv = document.getElementById("korDiv");
const forDiv = document.getElementById("forDiv");
const korLabel = document.getElementById("korLabel");
const forLabel = document.getElementById("forLabel");




/* 각 input 별 true, false 담을 객체 */
const checkInputs = {

    "inputId" : false,
    "inputPw" : false,
    "inputPwCheck" : false,
    "memberNickname" : false,
    "memberName" : false,
    "memberBirth" : false,
    /* radio 안넣었음 몰라서 */

}

// firstbox-------------------------------------------------------------------------------------- //

// -------------------------------------------------------------------------------------- //
// 아이디

inputId.addEventListener("input",function(){

    in1.innerText = "";

    if(inputId.value.trim().length == 0){
        in1.innerText = "아이디를 입력해주세요.";
        in1.classList.remove("true", "false");
        this.style.borderBottom = "2px solid lightgray";
        firstbox.style.border = "5px solid lightgray";
        
        checkInputs.inputId = false;

        return;
    }

    const regExp = /^([a-z]|[0-9]){6,14}$/;

    if(regExp.test(inputId.value)){

        // 형식에 맞을 때 중복검사
        $.ajax({
            url : "idDupCheck",
            data : {"inputId" : inputId.value},
            type : "GET",

            success : function(result){

                if( result == 1){

                    in1.innerText = "이미 사용중인 아이디입니다.";
                    in1.classList.add("false");
                    in1.classList.remove("true");
                    inputId.style.borderBottom = "2px solid lightgray";
                    firstbox.style.border = "5px solid lightgray";

                    checkInputs.inputId = false;

                }else{

                    in1.innerText = "사용 가능한 아이디입니다.";
                    in1.classList.add("true");
                    in1.classList.remove("false");
                    inputId.style.borderBottom = "2px solid lightcoral"; // 여기서의 this는 inputId가 아닌듯
                    checkInputs.inputId = true;

                    // 아이디 통으로 지웠다가 다시 작성했을때 border 
                    if(checkInputs.inputPw == true && checkInputs.inputPwCheck == true && checkInputs.inputId == true){
                        in1.innerText = "유효한 아이디, 비밀번호입니다.";
                        in1.classList.add("true");
                        in1.classList.remove("false");
                        inputPw.style.borderBottom = "2px solid lightcoral";
                        inputPwCheck.style.borderBottom = "2px solid lightcoral";
                        firstbox.style.border = "5px solid lightcoral";
                
                    }
               
                }

            },

            error : function(){
                console.log("에러 발생함");
            }

        })
        
    }else{
        in1.innerText = "아이디 : 영어(소문자) , 숫자로만 이루어진 6~14 글자로 입력해주세요.";
        in1.classList.add("false");
        in1.classList.remove("true");
        inputId.style.borderBottom = "2px solid lightgray";
        firstbox.style.border = "5px solid lightgray";

        checkInputs.inputId = false;
        

    }

});

// -------------------------------------------------------------------------------------- //
// 비밀번호

inputPw.addEventListener("input",function(){
    
    if(checkInputs.inputId != true){
        alert("아이디를 올바른 형식으로 입력해주세요.");
        
        inputId.focus();

        inputPw.value = "";
        
        return;
    }

    in1.innerText = ""; // 아이디 텍스트 없애기

    
    if(inputPw.value.trim().length == 0){
        in1.innerText = "비밀번호를 입력해주세요.";
        in1.classList.remove("true", "false");
        
        // 비밀번호를 통째로 지워버렸을 때를 대비
        firstbox.style.border = "5px solid lightgray";
        inputPw.style.borderBottom = "2px solid lightgray";
        inputPwCheck.style.borderBottom = "2px solid lightgray";

        return;
    }    
    
    const regExp = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/;
    //(?=.*?)는 전방탐색(lookahead) -> 패턴이 일치하는지 확인하고 다음에 일치할 문자를 건너뛰는 것
    
    //최소 8자 이상, 최대 16자 이하 , 하나 이상의 소문자, 숫자, 특수 문자 (#?!@$%^&-)를 포함
    
    //"비밀번호 : 소문자, 숫자, 특수문자를 포함한 8~16자리로 입력해주세요.";

    if(regExp.test(inputPw.value)){ // 비밀번호 유효

        checkInputs.inputPw = true; 

        if(inputPwCheck.value.trim().length == 0){
            // 비밀번호 유효하면서, 비밀번호 확인이 작성 안됐을 때 경우
            in1.innerText = "유효한 비밀번호 형식입니다.";
            in1.classList.add("true");
            in1.classList.remove("false");
            inputPw.style.borderBottom = "2px solid lightcoral";
            

        }else{ // 비밀번호 유효하면서 비밀번호 확인도 작성이 된 경우

            pwCheck(); // 비밀번호 일치  검사 함수를 호출

        }

    }else{

     
        in1.innerText = "비밀번호 : 소문자, 숫자, 특수문자를 포함한 8~16자리로 입력해주세요.";
        in1.classList.add("false");
        in1.classList.remove("true");
        inputPw.style.borderBottom = "2px solid lightgray";

        checkInputs.inputPw = false;

    }

})

// -------------------------------------------------------------------------------------- //

// 비밀번호 확인
inputPwCheck.addEventListener("input",pwCheck); // Pwcheck true나 false로

// -------------------------------------------------------------------------------------- //

// 비밀번호 일치 검사

function pwCheck(){

    // 비번 확인을 입력하는데 비번이 유효하지 않다면
    const regExp = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/;
    if(!regExp.test(inputPw.value)){
        alert("비밀번호를 올바르게 입력해주세요.");
        inputPwCheck.value = "";
        inputPw.focus();
        return;
    }


    if(inputPw.value != inputPwCheck.value){
    
        in1.innerText = "비밀번호가 일치하지 않습니다.";
        in1.classList.add("false");
        in1.classList.remove("true");
        inputPwCheck.style.borderBottom = "2px solid lightgray";
        firstbox.style.border = "5px solid lightgray";
        checkInputs.inputPwCheck = false;
    
    }else {

        in1.innerText = "유효한 아이디, 비밀번호입니다.";
        in1.classList.add("true");
        in1.classList.remove("false");
        inputPw.style.borderBottom = "2px solid lightcoral";
        inputPwCheck.style.borderBottom = "2px solid lightcoral";
        firstbox.style.border = "5px solid lightcoral";
       
        checkInputs.inputPwCheck = true;

        

    }

}

// secondBox -------------------------------------------------------------------------------------- //
//-------------------------------------------------------------------------------------- //
// 닉네임

memberNickname.addEventListener("input",function(){

    if(memberNickname.value.trim().length == 0){
        in2.innerText = "2~12글자 사이의 영어/숫자/한글로 입력해주세요.";
        in2.classList.remove("true","false");
        checkInputs.memberNickname = false;
        return;
    }

    const repExp = /^[가-힇a-zA-Z0-9]{2,12}$/;
    
    if(repExp.test(this.value)){ // 닉네임이 유효하다면

        $.ajax({ // 닉네임 중복검사

            url : "nicknameDupCheck",

            data : {"memberNickname" : memberNickname.value},

            type : "GET",

            success : function(result){

                if( result == 1){

                    in2.innerText = "이미 사용중인 닉네임입니다.";
                    in2.classList.add("false");
                    in2.classList.remove("true");
                    memberNickname.style.borderBottom = "2px solid lightgray";

                    checkInputs.memberNickname = false;

                }else{

                    in2.innerText = "사용 가능한 닉네임입니다.";
                    in2.classList.add("true");
                    in2.classList.remove("false");
                    memberNickname.style.borderBottom = "2px solid lightcoral"; // 여기서의 this는 inputId가 아닌듯
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
// -------------------------------------------------------------------------------------- //

// 이름
memberName.addEventListener("input",function(){

    in2.innerText = ""; 

    if(checkInputs.memberNickname != true){
        alert("닉네임을 올바르게 입력해주세요.");
        this.value = "";
        memberNickname.focus();
    }

    if(this.value.trim().length == 0){
        in2.innerText = "이름을 입력해주세요.";
        in2.classList.remove("true","false");
        checkInputs.memberName = false;
        return;
    }

    const regExp = /^[가-힇a-zA-Z]{2,20}$/; // 내/외국인 구분하니까 영어도 넣었음

    if(regExp.test(this.value)){

        in2.innerText = "이름이 유효한 형식입니다.";

        in2.classList.add("true");
        in2.classList.remove("false");

        checkInputs.memberName = true;

        this.style.borderBottom = "2px solid lightcoral";

    }else{

        in2.innerText = "유효한 형식의 이름이 아닙니다.";

        in2.classList.add("false");
        in2.classList.remove("true");

        this.style.borderBottom = "2px solid lightgray";

        checkInputs.memberName = false;

    }

})


// -------------------------------------------------------------------------------------- //
// 생년월일

memberBirth.addEventListener("input", function(){

    in2.innerText = "";

    if(checkInputs.memberName != true){
       
        alert("이름을 올바르게 입력해주세요.");
        this.value = "";
        memberName.focus();
    }


    if(this.value.trim().length == 0){
        in2.innerText = "생년월일을 8자리로 입력해주세요. (-제외)";
        in2.classList.remove("true", "false");
        checkInputs.memberBirth = false;
        return;
    }

    const regExp = /^(?:19|20)\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|1[0-9]|2[0-9]|30|31)$/;
    // (?:19|20)\d{2}: 1900년부터 2099년까지의 연도를 의미하는 4자리 숫자
    // (?:0[1-9]|1[0-2]): 01월부터 12월까지의 월을 의미하는 2자리 숫자.
    // (?:0[1-9]|1[0-9]|2[0-9]|30|31): 01일부터 31일까지의 일을 의미하는 2자리 숫자.
    // ?:는 빼도 되긴 함 왜쓰는지 모르겠음

    if(regExp.test(this.value)){

        in2.innerText = "생년월일이 유효한 형식입니다.";

        in2.classList.add("true");
        in2.classList.remove("false");

        checkInputs.memberBirth = true;

        this.style.borderBottom = "2px solid lightcoral";

    }else{

        in2.innerText = "유효한 형식의 생년월일이 아닙니다.";

        in2.classList.add("false");
        in2.classList.remove("true");

        this.style.borderBottom = "2px solid lightgray";

        checkInputs.memberBirth = false;

    }

})

// -------------------------------------------------------------------------------------- //
// 활동지역

regionSelect.addEventListener("click",function(){

    in2.innerText = "";

    if(checkInputs.memberBirth != true){
       
        alert("생년월일을 올바르게 입력해주세요.");
        memberBirth.focus();
    }


    // 주 활동지역을 선택해주세요. 선택되어있을때 안넘어가는법?

})

// -------------------------------------------------------------------------------------- //
// 전화번호

memberPhone.addEventListener("input",function(){

    //if(regionSelect ) 지역 선택이 안됐을때 입력 못하게 하기 모르겠음

    // 왜 autocomplete off인데 저장된정보뜸

    in2.innerText = "";


    if(this.value.trim().length == 0){
        in2.innerText = "전화번호를 입력해주세요. (-제외)";
        in2.classList.remove("true", "false");
        checkInputs.memberPhone = false;
        return;
    }

    const regExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;
    // (?:19|20)\d{2}: 1900년부터 2099년까지의 연도를 의미하는 4자리 숫자
    // (?:0[1-9]|1[0-2]): 01월부터 12월까지의 월을 의미하는 2자리 숫자.
    // (?:0[1-9]|1[0-9]|2[0-9]|30|31): 01일부터 31일까지의 일을 의미하는 2자리 숫자.
    // ?:는 빼도 되긴 함 왜쓰는지 모르겠음

    if(regExp.test(this.value)){

        in2.innerText = "전화번호가 유효한 형식입니다.";

        in2.classList.add("true");
        in2.classList.remove("false");

        checkInputs.memberPhone = true;

        this.style.borderBottom = "2px solid lightcoral";

    }else{

        in2.innerText = "유효한 형식의 전화번호가 아닙니다.";

        in2.classList.add("false");
        in2.classList.remove("true");

        this.style.borderBottom = "2px solid lightgray";

        checkInputs.memberPhone = false;

    }

})

// -------------------------------------------------------------------------------------- //
// 남/녀 , 내/외국인
//체크된 라디오 값 가져오는 법?

manDiv.addEventListener("click",function(){ // 라벨로 클릭하면 2번 이벤트가 발생함.. 왜?

    manLabel.style.backgroundColor = "lightcoral";
    manLabel.style.color = "white";
    manLabel.style.border = "1px solid lightcoral";

    womanLabel.style.backgroundColor = "white";
    womanLabel.style.color = "black";
    womanLabel.style.border = "1px solid lightgray";
})

womanDiv.addEventListener("click",function(){ 

    womanLabel.style.backgroundColor = "lightcoral";
    womanLabel.style.color = "white";
    womanLabel.style.border = "1px solid lightcoral";

    manLabel.style.backgroundColor = "white";
    manLabel.style.color = "black";
    manLabel.style.border = "1px solid lightgray";
})

korDiv.addEventListener("click",function(){ // 라벨로 클릭하면 2번 이벤트가 발생함.. 왜?
   
    korLabel.style.backgroundColor = "lightcoral";
    korLabel.style.color = "white";
    korLabel.style.border = "1px solid lightcoral";

    forLabel.style.backgroundColor = "white";
    forLabel.style.color = "black";
    forLabel.style.border = "1px solid lightgray";

})

forDiv.addEventListener("click",function(){ 

    forLabel.style.backgroundColor = "lightcoral";
    forLabel.style.color = "white";
    forLabel.style.border = "1px solid lightcoral";

    korLabel.style.backgroundColor = "white";
    korLabel.style.color = "black";
    korLabel.style.border = "1px solid lightgray";
})



// ----------------------------------------------------------------------------- //

// 약관동의 클릭하면 박스 나오게 하기



// ----------------------------------------------------------------------------- //

// 조건 안맞으면 회원가입 못하게 하기

