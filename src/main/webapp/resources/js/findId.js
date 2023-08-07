const sendEmail = document.getElementById("btn1");
const checkKey = document.getElementById("btn2");

const inputEmail =  document.getElementById("inputEmail");
const inputName = document.getElementById("inputName");
const inputKey = document.getElementById("inputKey");


sendEmail.addEventListener("click", function(){
    if(inputEmail.value.trim().length == 0){
        Swal.fire("이메일을 입력해주세요.");
    }else{
        $.ajax({
            url : "findId/sendEmail",
            data : {"inputEmail" : inputEmail.value,
                    "inputName" : inputName.value},
            type : "GET",

            
            success : function(key1){
                if(key1 == ""){
                    Swal.fire("회원정보를 확인해주세요.");
                } else{
                    Swal.fire("이메일 전송 완료!");
                    
                    checkKey.addEventListener("click", function(){

                        if(key1.substring(1,11)==inputKey.value){
                            Swal.fire("아이디 찾기완료. 아이디는 " + key1.substring(12) + "입니다.");
                            inputKey.value = "";

                        } else{
                            Swal.fire("인증번호가 일치하지 않습니다,");
                            inputKey.value = "";
                        }
                    })

                }
                
                
            },

            error : function(){
                console.log("에러발생");
            }
        })
    }
})