<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 찾기</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/findId.css">
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div class="container1">

        <div class="divide1">
            <h1>아이디 찾기</h1>
        </div>
        
        <div class="divide2">
            <div class="divide4">아이디 찾기</div>
            <div class="divide4"><input type="text" id="inputName" placeholder="이름입력"></div>
            <div class="divide4"><input type="text" id="inputEmail" placeholder="이메일 입력" size="35"><button id="btn1">이메일인증</button></div>
            <div class="divide4"><input type="text" id="inputNum" placeholder="인증번호 입력" size="35"><button id="btn2">인증확인</button></div>
        </div>

       
        
    

        <div class="divide3">
            <button type="button" id="btn3">뒤로가기</button>
        </div>


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





</body>
</html>