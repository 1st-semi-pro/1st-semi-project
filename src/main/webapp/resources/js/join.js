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
const selectRegion = document.getElementById("selectDiv");

const memberPhone = document.getElementById("memberPhone");

/* genderNationality div 안에 감싸져있는 div 각각 radio 2개씩 이씀 */
const gender = document.getElementById("gender");
const nationality = document.getElementById("nationality");

const inputEmail = document.getElementById("inputEmail");
const in2 = document.getElementById("innerTextSpan2");

const firstbox = document.getElementById("firstbox");

// --------------------아이디--------------------- //

inputId.addEventListener("input",function(){

    firstbox.style.border = "5px solid lightcoral";

    if(inputId.value.trim().length == 0){
        in1.innerText = "아이디를 입력해주세요.";
        in1.classList.remove("true", "false");
        this.style.borderBottom = "2px solid lightgray";
    }

    const regExp = /^([a-z]|[0-9]){6,14}$/;

    if(regExp.test(inputId.value)){
/*         in1.innerText = "아이디가 형식에 맞습니다.";
        in1.classList.add("true");
        in1.classList.remove("false");
        this.style.borderBottom = "2px solid lightcoral"; */

        // 형식에 맞을 때 중복검사(비동기)
        $.ajax({
            url : "test",
            data : {"inputId" : inputId.value},
            type : "GET",

            success : function(result){

                if( result == 1){
                    in1.innerText = "이미 사용중인 아이디입니다.";
                    in1.classList.add("false");
                    in1.classList.remove("true");
                }else{
                    in1.innerText = "사용 가능한 아이디입니다.";
                    in1.classList.add("true");
                    in1.classList.remove("false");
                }

            },

            error : function(){
                console.log("에러 발생함");
            }

        })
        
    }else{
        in1.innerText = "영어(소문자) , 숫자로만 이루어진 6~14 글자로 입력해주세요.";
        in1.classList.add("false");
        in1.classList.remove("true");
        this.style.borderBottom = "2px solid lightgray";
    }

})



// ----------------------------------------------------------------------------- //

// 약관동의 클릭하면 박스 나오게 하기



// ----------------------------------------------------------------------------- //

// 조건 안맞으면 회원가입 못하게 하기

