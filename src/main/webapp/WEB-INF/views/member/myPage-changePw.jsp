<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 문자열 관련 함수(메소드) 제공 JSTL (EL형식으로 작성) --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지비밀번호변경</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-info.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
</head>
<body>

    <main>
        
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
        <!-- 마이페이지 내 정보 -->
        <section class="myPage-content">

                 <!-- 왼쪽 사이드 메뉴 -->
                 <section class="left-side">
                    사이드 메뉴
    
                    <ul class="list-group">
    
                        <!-- /communty/member/myPage/info -->
                        <li><a href="${contextPath}/member/myPage/info">내 정보 변경</a></li>
                        
                        <!-- /communty/member/myPage/changePw-->
                        <li><a href="${contextPath}/member/myPage/changePw">비밀번호 변경</a></li>
    
                        <!-- /communty/member/myPage/secession-->
                        <li><a href="${contextPath}/member/myPage/secession">회원 탈퇴</a></li>
                    </ul>
                </section>
            
            <!-- 오른쪽 마이페이지 주요 내용 부분 -->
            <section class="myPage-main">

                <h1 class="myPage-title">비밀번호 변경</h1>
                <span class="myPage-explanation">현재 비밀번호가 일치하는 경우 새 비밀번호로 변경할수 있습니다.</span>
                
                <form action="changePw" method="post" onsubmit="return changePwValidate()" name="myPage-form">
                    
                    <div class="myPage-row">
                        <label>현재비밀번호</label>
                        <input type="password" name="currentPw" id="currentPw" value="${loginMember.memberPw}" maxlength="30">
                    </div>
                    
                     <div class="myPage-row">
                        <label>새 비밀번호</label>
                        <input type="password" name="newPw" id="newPw1" maxlength="30">
                    </div>
                    
                     <div class="myPage-row">
                        <label>새 비밀번호 확인</label>
                        <input type="password" name="newPw" id="newPw2" maxlength="30">
                    </div>
                   
                    <button id="info-update-btn">변경하기</button>
                </form>
            </section>
        </section>

    </main>
        
       <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
       <script src="${contextPath}/resources/js/Changee-information.js"></script>

    
</body>
</html>