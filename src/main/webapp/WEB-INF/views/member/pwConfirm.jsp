<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보확인</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/pwConfirm.css">
</head>
<body>

    <div class="container">
        <div>
            <h1>회원 정보 확인</h1>
        </div>
        <div>
            @@@님의 정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인합니다.
        </div>
        <div>
            <input type="password" size="40" placeholder="비밀번호를 입력하시오.">
        </div>
        <div>
            <button>확인</button>
            <button>취소</button>
        </div>

    </div>
    
</body>
</html>