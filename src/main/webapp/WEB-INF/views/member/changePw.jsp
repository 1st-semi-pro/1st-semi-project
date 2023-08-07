<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 변경</title>

    <!-- <link rel="stylesheet" href="${contextPath}/resources/css/index.css"> -->
    <link rel="stylesheet" href="${contextPath}/resources/css/changePw.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div class="container1">
        
        <div class="divide1"> 
            <h1>${param.memberName}님의 아이디 '${param.memberId}'</h1>  
        </div>
        <div class="sub">
            <h5>※ 인증번호 확인이 완료되었습니다! 비밀번호를 재설정 해주십시오.</h5>
        </div>
        <form id="changePw-form" action="changePw" method="post" onsubmit="return changePwValidate()">
            <div class="divide2">
                <div class="divide4">비밀번호 변경</div>
                <div class="divide4"><input type="password" name="newPw" placeholder="새 비밀번호 입력" size="35"></div>
                <div class="divide4"><input type="password" name="newPwCheck" placeholder="새 비밀번호 확인" size="35"></div>
                <div class="divide4"><span id="password-span"></span></div>
                
                <div class="divide3">
                    <a href="${contextPath}/member/findPw"><button type="button" id="goToBack-btn">뒤로가기</button></a>
                    <button type="submit" id="authentication-check-btn">변경 확인</button>
                </div>
            </div>
            <input type="hidden" name="memberId" value="${param.memberId}">
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