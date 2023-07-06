
            /* ---------------------------------------- 아이디 ---------------------------------------- */

            const idInput = document.getElementById("idInput");

            idInput.addEventListener("keyup", function(){
              
                const regExp = /^([a-z]|[0-9]){6,14}$/;
                const firstSpan = document.getElementById("firstSpan");
                const sel1 = document.getElementById("sel1");

                if(regExp.test(idInput.value)){
                    firstSpan.style.color = "green";
                    firstSpan.innerText = " * 아이디가 형식에 맞습니다.";
                    sel1.style.border = "3px solid lightcoral";
                }else{
                    firstSpan.style.color = "red";
                    firstSpan.innerText = " * 영어(소문자) , 숫자로만 이루어진 6~14 글자로 입력해주세요."
                    sel1.style.border = "3px solid rgb(227 31 25)";
                }
                
                idInput.addEventListener("blur", function(){
                if(!regExp.test(this.value)){
                    sel1.style.border = "1px solid lightgray";
                    this.value = '';
                }
                });

                idInput.addEventListener("change", function(){
                    firstSpan.innerText = '';
                })
            })

            /* ---------------------------------------- 비번 ---------------------------------------- */

            const pwInput1 = document.getElementById("pwInput1");
            const pwInput2 = document.getElementById("pwInput2");
            
            pwInput2.addEventListener("keyup", function(){
                
                if(pwInput1.value == ''){
                    this.value = "";
                    alert("비밀번호를 입력해주세요");
                    pwInput1.focus();
                }
            });

            pwInput1.addEventListener("keyup", function(){
                
                const regExp = /^([a-zA-Z0-9]){8,16}$/;

                if(regExp.test(pwInput1.value)){
                    firstSpan.style.color = "green";
                    firstSpan.innerText = " * 올바른 비밀번호입니다.";
                    sel2dot1.style.border = "3px solid lightcoral";
                }else{
                    firstSpan.style.color = "red";
                    firstSpan.innerText = " * 영어, 숫자로만 8~16 글자로 입력해주세요.";
                    sel2dot1.style.border = "3px solid rgb(227 31 25)";
                }

                pwInput1.addEventListener("blur", function(){
                if(!regExp.test(this.value)){
                    sel2dot1.style.border = "1px solid lightgray";
                    this.value = '';
                }
                });

                pwInput.addEventListener("change", function(){
                    firstSpan.innerText = '';
                })
            })

            pwInput2.addEventListener("keyup", function(){

            if( (pwInput1.value == pwInput2.value) && pwInput1.value.length != 0  ){
                firstSpan.style.color = "green";
                firstSpan.innerText = "비밀번호 일치합니다.";
                sel2dot2.style.border = "3px solid lightcoral";


            } else{
                firstSpan.style.color = "red";
                firstSpan.innerText = "비밀번호가 불일치합니다.";
                sel2dot2.style.border = "3px solid rgb(227 31 25)";
            }

            pwInput2.addEventListener("blur", function(){
                if(pwInput1.value != pwInput2.value){
                    sel3.style.border = "1px solid lightgray";
                    this.value = '';
                }
                });

            if( pwInput1.value.length == 0 && pwInput2.value.length == 0 ){
                firstSpan.innerText = '';
            }

            });

            pwInput2.addEventListener("change", function(){
                    firstSpan.innerText = '';
                })
            
            /* ---------------------------------------- 이름 ---------------------------------------- */

            const nameInput = document.getElementById("nameInput");
            
            nameInput.addEventListener("keyup", function(){
                const regExp = /^[가-힣]{2,5}$/;

                if(regExp.test(nameInput.value)){
                    secondSpan.style.color = "green";
                    secondSpan.innerText = " * 이름이 형식에 맞습니다.";
                    sel4.style.border = "3px solid lightcoral";

                } else {
                    secondSpan.style.color = "red";
                    secondSpan.innerText = " * 형식(한글)에 맞게 입력해주세요.";
                    sel4.style.border = "3px solid rgb(227 31 25)";
                }

                nameInput.addEventListener("blur", function(){
                if(!regExp.test(this.value)){
                    sel4.style.border = "1px solid lightgray";
                    this.value = '';
                }
                })

                nameInput.addEventListener("change", function(){
                    secondSpan.innerText = '';
                })
            
            })

            /* ---------------------------------------- 생년월일 ---------------------------------------- */
          
            const birthInput = document.getElementById("birthInput");
            
            birthInput.addEventListener("keyup", function(){
                const regExp = /^[0-9]{4}\-[0-9]{2}\-[0-9]{2}$/;

                if(regExp.test(birthInput.value)){
                    secondSpan.style.color = "green";
                    secondSpan.innerText = " * 생년월일이 형식에 맞습니다.";
                    sel5.style.border = "3px solid lightcoral";

                } else {
                    secondSpan.style.color = "red";
                    secondSpan.innerText = " * 형식에 맞게 입력해주세요.";
                    sel5.style.border = "3px solid rgb(227 31 25)";
                }

                birthInput.addEventListener("blur", function(){
                if(!regExp.test(this.value)){
                    sel5.style.border = "1px solid lightgray";
                    this.value = '';
                }
                })

                birthInput.addEventListener("change", function(){
                    secondSpan.innerText = '';
                })
            
            })

            
            /* ---------------------------------------- 이메일 ---------------------------------------- */
            
            const emailInput = document.getElementById("emailInput");

            emailInput.addEventListener("keyup",function(){

            const regExp = /^[a-zA-Z0-9]+@[a-z0-9]+\.[a-z]{2,}$/;
               
                if(regExp.test(emailInput.value)){
                secondSpan.style.color = "green";
                secondSpan.innerText = " * 이메일이 형식에 맞습니다."
                sel3.style.border = "3px solid lightcoral";
                }else{
                    secondSpan.style.color = "red";
                    secondSpan.innerText = " * 형식에 맞게 입력해주세요 (@사용, 도메인 입력)."
                    sel3.style.border = "3px solid rgb(227 31 25)";
                }

                emailInput.addEventListener("blur", function(){
                if(!regExp.test(this.value)){
                    sel3.style.border = "1px solid lightgray";
                    this.value = '';
                }
                })

                emailInput.addEventListener("change", function(){
                    secondSpan.innerText = '';
                })

            })

             /* ---------------------------------------- 성별 ---------------------------------------- */

            const gender = document.getElementsByName("gender");
            const man = document.getElementById("man");
            const woman = document.getElementById("woman");
            const btn1 = document.getElementById("btn1");
            const btn2 = document.getElementById("btn2");


            man.addEventListener("click", function(){
                btn2.style.border = "1px solid lightgray";
                btn1.style.border = "3px solid lightcoral";
                 sel6.style.border = "3px solid lightcoral"; 
            })

            woman.addEventListener("click", function(){
                btn1.style.border = "1px solid lightgray";
                btn2.style.border = "3px solid lightcoral";
                 sel6.style.border = "3px solid lightcoral"; 
            })

            /* ---------------------------------------- 국적 ---------------------------------------- */

            const nationality = document.getElementsByName("nationality");
            const korean = document.getElementById("korean");
            const foreigner = document.getElementById("foreigner");
            const btn3 = document.getElementById("btn3");
            const btn4 = document.getElementById("btn4");


            korean.addEventListener("click", function(){
                btn4.style.border = "1px solid lightgray";
                btn3.style.border = "3px solid lightcoral";
                sel7.style.border = "3px solid lightcoral"; 
            })

            
            foreigner.addEventListener("click", function(){
                btn3.style.border = "1px solid lightgray";
                btn4.style.border = "3px solid lightcoral";
                 sel7.style.border = "3px solid lightcoral";
            })

            /* ---------------------------------------- 전화번호 ---------------------------------------- */

            const phoneInput = document.getElementById("phoneInput");

            phoneInput.addEventListener("keyup", function(){
                const regExp = /^[0-9]{2,3}\-[0-9]{3,4}\-[0-9]{3,4}$/;

                if(regExp.test(phoneInput.value)){
                    secondSpan.style.color = "green";
                    secondSpan.innerText = " * 전화번호가 형식에 맞습니다.";
                    sel8.style.border = "3px solid lightcoral";

                } else {
                    secondSpan.style.color = "red";
                    secondSpan.innerText = " * 형식에 맞게 입력해주세요.";
                    sel8.style.border = "3px solid rgb(227 31 25)";
                }

                phoneInput.addEventListener("blur", function(){
                if(!regExp.test(this.value)){
                    sel8.style.border = "1px solid lightgray";
                    this.value = '';
                }
                })

                phoneInput.addEventListener("change", function(){
                    secondSpan.innerText = '';
                })
            
            })

            /* ---------------------------------------- 약관 동의 버튼 ---------------------------------------- */

            const agree = document.getElementById("agree");

            agree.addEventListener("click", function(){
                
                 sel9.style.border = "3px solid lightcoral";
               
            })

            /* ---------------------------------------- 회원가입버튼 ---------------------------------------- */

            const btn = document.getElementById("btn");

            btn.addEventListener("click", function(e){
                
                if(!gender[0].checked && !gender[1].checked){
                    alert("성별을 선택해주세요.");
                    e.preventDefault(); 
                }else if(!nationality[0].checked && !nationality[1].checked){
                    alert("국적을 선택해주세요.");
                    e.preventDefault();
                }else if(!agree.checked){
                    alert("필수 약관에 동의해주세요.");
                    e.preventDefault();
                }else {
                    alert("회원 가입 완료");
                }
            })
