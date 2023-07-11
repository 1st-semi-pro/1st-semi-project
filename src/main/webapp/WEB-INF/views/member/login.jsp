<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">



</head>

<body>

    <main>

        <header>
            <selection>
            
            <a href="${contextPath}">
                <img src="${contextPath}/resources/images/humanmadelogo.svg" id="img1"> <a> 로고 바꾸기</a>
            </a>    
                
            </selection>
        </header>

        <div style="height:50px;" id ="heightdiv"></div>
    <selection class="content">

        <selectionmargin></selectionmargin>

        <selection class="content1">
             
            <img src="${contextPath}/resources/images/id.png" id="img2">
             <input type="text" size ="50" maxlength="10" placeholder="아이디" id="idInput" name="inputId">
        
        </selection>


        <selection class="content1">
            
            <img src="${contextPath}/resources/images/password.jpg" id="img3">
            <input type="password" size = "50" maxlength="10" placeholder="비밀번호" id="inputPw">
            
        </selection>
        
        <selection class="content1" id="sel1">
           
            <div id="widthdiv">
                <input type="radio">
            </div>

            <input type = "email" size = "50" placeholder="로그인 상태 유지"> 
       
        </selection>

        
        <selection class="content1">
            
            <button id="btn1">
                <a href="#" id="a1">로그인</a>
            </button>    
        
        </selection>

        <selection class="content1"  id="sel2">
           
            <div class="find">
                <a href="#">아이디 찾기</a>
            </div>
            
            <span>|</span>
            
            <div class="find">
                <a href="#">비밀번호 찾기</a>
            </div>
            
            <span>|</span>
            

            <div class="find">
                <a href="${contextPath}/member/agree">회원가입</a>
            </div>

					<!-- 
                      <form action="member/join" method="post">
                         <div>
                     <button id="loginBtn">회원가입</button>
                         </div>
                      </form> -->

        </selection>


    </selection>


    <div id="heightdiv2"></div>

    <footer>
        
        <selection class="find1">
            
            <a> 이용약관 | 개인정보 처리 방침 | 책임의 한계와 법적고지 | 회원정보 고객센터 </a>
            
        </selection>

        <selection class="find1">
            
            <selection>

                <a>Copyright &copy; 2023 OTSUMO CO., LTD. ALL rights reserved<span>|</span></a>
           
            </selection>
         
        </selection>
    </footer>

    </main>

    <script src= "${contextPath}/resources/js/login.js"> </script>
</body>
</html>