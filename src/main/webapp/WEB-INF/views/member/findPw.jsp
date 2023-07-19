<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 찾기</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/findPw.css">
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
    
        <div class="divide2">
            <div class="divide4">비밀번호 찾기</div>
            <div class="divide4"><input type="text" placeholder="이름입력"></div>
            <div class="divide4"><input type="text" value="회원 아이디" size="35"></div>
            <div class="divide4"><input type="text" placeholder="이메일 입력" size="35"><button id="btn1">이메일인증</button></div>
            <div class="divide4"><input type="text" placeholder="인증번호 입력" size="35"><button id="btn2">인증확인</button></div>

        </div>

        <div class="divide3">
            <button type="button" id="btn3">뒤로가기</button>
        </div>

    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>