<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보확인</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/pwConfirm.css">
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <form action="${contextPath}/member/confirm/check" method="post" onsubmit="return confirmValidate()">
        <div class="container">
            <div class="divide1">
                <h1>회원 정보 확인</h1>
            </div>
            <div class="divide2">
                <span>${loginMember.memberName}</span> 님의 정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인합니다.
            </div>
            <div class="divide3">
                <input type="password" size="40" placeholder="비밀번호를 입력하시오." id="inputPw">
            </div>
            <div class="divide4">
                <button id="pwConfirm">확인</button>
                <button type="button" onclick="location.href='${header.referer}'">취소</button>
            </div>

            <input type="hidden" value="${loginMember.memberPw}" id="realPw">
        </div>
    </form>
        
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

    
    
    <script src="${contextPath}/resources/js/pwConfirm.js"></script>

</body>
</html>