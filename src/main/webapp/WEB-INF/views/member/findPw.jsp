<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 찾기</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/index.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/findPw.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">

    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div class="container1">
        
        <div class="divide1">
            <h1>비밀번호 찾기</h1>  
        </div>
        <div class="sub">
            <h5>※ 비밀번호의 경우 암호화 저장되어 분실 시  찾아드릴 수 없는 정보입니다.</h5>
        </div>
        <div class="sub">
            <h5>※ 본인 확인을 통해 비밀번호를 재설정 하실 수 있습니다.</h5>
        </div>
    
        <form id="findPw-form" action="changePw">
            <div class="divide2">
                <div class="divide4">비밀번호 찾기</div>
                <div class="divide4"><input type="text" name="memberName" placeholder="이름입력"></div>
                <div class="divide4"><input type="text" name="memberId" placeholder="아이디 입력" size="35"></div>
                <div class="divide4"><input type="text" name="memberEmail" placeholder="이메일 입력" size="35"><button type="submit" id="email-authentication-btn">인증번호 전송</button></div>
                <div class="divide3">
                    <button type="button" id="goToBack-btn">뒤로가기</button>
                    <button type="button" id="findPw-btn">아이디 찾기</button>
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
    <script src="${contextPath}/resources/js/findPw.js"></script>
</body>
</html>