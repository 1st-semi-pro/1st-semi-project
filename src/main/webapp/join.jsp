<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ohsjoin</title>

    <link rel="stylesheet" href="resources/css/join.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">



</head>

<body>

    <main>

        <header>
            <selection>
                <img src="resources/images/humanmadelogo.svg" id="img1"> <a> <- 로고 바꾸기</a>
                
            </selection>
        </header>

    <selection class="content">

        <selectionmargin></selectionmargin>

        <selection class="content1" id = "sel1">
            
            <img src="resources/images/id.png" id="img2">
             <input type="text" size ="50" maxlength="14" placeholder="아이디" id = "idInput">
        
        </selection>
        
        <selection class="content1" id = "sel2dot1">
        
            <img src="resources/images/password2.png" id="img3">
            <input type="password" size = "50" maxlength="10" placeholder="비밀번호" id = "pwInput1" >
        
        </selection>

        <selection class="content1" id = "sel2dot2">
        
            <img src="resources/images/password.jpg" id="img4" >
            <input type="password" size = "50" maxlength="10" placeholder="비밀번호 확인" id = "pwInput2">
        
        </selection>
        

        <selectionmargin>
            <span style="margin-left:22px;" id="firstSpan"></span>
        </selectionmargin>

        <selection class="content1" id="sel4">
            
            <div>
                <img src="resources/images/name.png" style="width:30px; height:30px;">
            </div>
           
            <input type="text" size ="50" maxlength="10" 
            placeholder="이름" id="nameInput">
            
        </selection>

        <selection class="content1" id="sel5">

            <div>
            <img src="resources/images/birth.png" style="width:28px; height:28px;">
            </div>

            <input type="text" size ="50" maxlength="10" 
            placeholder="생년월일 8자리 (-포함)" id="birthInput">

        </selection>

        <selection class="content1" id="sel3">

            <div>
            <img src="resources/images/birth.png" style="width:32px; height:35px;">
            </div>
            
            <input type = "email" size = "50" 
            placeholder="이메일" id="emailInput" width="50px;">  
       
        </selection>
        
        <selection class="content1" id="sel6" >
            
            <div>
                <img src="resources/images/gender.jpg" style="width:35px; height:35px;">
            </div>

            <div1 >
            <label for="man"><button class="btn" id="btn1">
                <div style="width:10px; margin-top:4px;">남</div>
                <input type="radio" name="gender" id="man"></button>
            </label>
            </div1>

            <div1 id="input2">
            <label for="woman"><button class="btn" id="btn2">
                <div style="width:10px; margin-top:7px;">여</div>
                <input type="radio" name="gender" id="woman"></button>
            </label>
            </div1>

        </selection>
            
        <selection class="content1" id="sel7">
            
                <div>
                <img src="resources/images/foreign.jpg" style="width:40px; height:40px;">
                </div>

                <label for="korean">
                   
                    <button class="btn" id="btn3">
                        <div style="width:38px; margin-top:4px;">내국인</div>
                        <input type="radio" name="nationality" id="korean"></button>
                
                </label>
               
 
                <label for="foreigner">
                    
                    <button class="btn" id="btn4" >
                        <div style="width:38px; margin-top:4px;">외국인</div>
                        <input type="radio" name="nationality" id="foreigner"></button>
                
                </label>
        
            </selection>
        
        <selection class="content1" id="sel8">
            
            <div>
            <img src="resources/images/phone.png" style="width:30px; height:30px;">
            </div>
            
            <input type="text" size="50" placeholder="전화번호 (-포함)" id="phoneInput">

        </selection>

        <selectionmargin>
            <span style="margin-left:22px;" id="secondSpan"></span>
        </selectionmargin> 

      
    </selection>

    <selection class="content2" id="sel9" style="border-radius:30px;">

        <article style="border-radius: 20px;">
         <input type="radio" id="agree">    
         <a style="font-size:17px; font-weight:bold; font-family: 'Hi Melody', cursive;
                    margin-top:5px; margin-left:5px;">
            [필수] 인증 약관 전체동의</a>
         <img src="resources/images/v.jfif"> <a> <- 클릭시 콤보박스 넣기</a>
        </article>

    </selection>
    <footer>
        <article>
            <button id="btn">
            <a href="login.jsp"
            style="font-family: 'Hi Melody', cursive;">
            회원가입</a>
            </button>
        </article>
    </footer>

<button>인증하기</button>
통신사, 활동지역, 닉네임 div 넣기
    </main>


    <script src="resources/js/join.js"></script>
</body>
</html>