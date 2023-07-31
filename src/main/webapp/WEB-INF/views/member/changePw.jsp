<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 찾기</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/index.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/changePw.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">

    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div class="container1">
        
        <div class="divide1">
            <h1>비밀번호 변경</h1>  
        </div>
        <div class="sub">
            <h5>※ 작성해주신 이메일로 인증번호를 전송했습니다.</h5>
        </div>
        <div class="sub">
            <h5>※ 인증번호 입력 후 비밀번호를 재설정 해주십시오.</h5>
        </div>
    
        <form id="findPw-form" action="findPw/changePw">
            <div class="divide2">
                <div class="divide4"><input type="text" placeholder="인증번호 입력" size="35"></div>
                <div class="divide4"><input type="text" placeholder="비밀번호 입력"></div>
                <div class="divide4"><input type="text" placeholder="비밀번호 확인" size="35"></div>
                
                <div class="divide3">
                    <button id="authentication-check-btn">비밀번호 변경</button>
                </div>
            </div>        
        </form>

    </div>

    <footer>
        <section class="find1">
            <a> 이용약관 | 개인정보 처리 방침 | 책임의 한계와 법적고지 | 회원정보 고객센터 </a>
        </section>

        <section class="find1">
            <section>
                <a>Copyright &copy; 2023 OTSUMO CO., LTD. ALL rights reserved<span>|</span></a>
            </section>
        </section>
    </footer>
    <script src="${contextPath}/resources/js/changePw.js"></script>
</body>
</html>