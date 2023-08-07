<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 문자열 관련 함수(메소드) 제공 JSTL (EL형식으로 작성) --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
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
                <h2>사이드 메뉴</h2>

                <ul class="list-group">

                    <!-- /communty/member/myPage/info -->
                    <li><a href="${contextPath}/member/myPage/info">내 정보 변경</a></li>
                    
                    <!-- /communty/member/myPage/changePw-->
                    <li><a href="${contextPath}/member/myPage/changePw">비밀번호 변경</a></li>

                    <!-- /communty/member/myPage/changeEmail-->
                    <li><a href="${contextPath}/member/myPage/changeEmail">이메일 변경</a></li>

                    <!-- /communty/member/myPage/secession-->
                    <li><a href="${contextPath}/member/myPage/secession">회원 탈퇴</a></li>
                </ul>
            </section>
            
            <!-- 오른쪽 마이페이지 주요 내용 부분 -->
            <section class="myPage-main">

                <h1 class="myPage-title">내정보</h1>
                <span class="myPage-explanation">원하는 회원 정보를 수정할 수 있습니다.</span>
                <form action="info" method="post" onsubmit="return infoValidate()" name="myPage-form">
                    
                    <div class="dis">
                    <div class="myPage-row" id="disabled">
                        <label>아이디</label>
                        <input type="text" name="memberId" value="${loginMember.memberId }" maxlength="30" disabled>
                    </div>
                    <div class="myPage-row" id="disabled">
                        <label>이름</label>
                        <input type="text" name="memberName" value="${loginMember.memberName }" maxlength="30" disabled>
                    </div>
                    <div class="myPage-row" id="disabled">
                        <label>성별</label>
                        <input type="text" name="memberEmail" value="${loginMember.memberGender }" maxlength="30" disabled>
                    </div>
                    <div class="myPage-row" id="disabled">
                        <label>국가</label>
                        <input type="text" name="memberNationality" value="${loginMember.memberNationality }" maxlength="30" disabled>
                    </div>
                </div>
                    <div class="myPage-row">
                        <label>사는 지역</label>
                        <select name="memberRegion" id="memberRegion" value="${loginMember.memberRegion }">
                            <option value="${loginMember.memberRegion }">${loginMember.memberRegion}</option>
                            <option value="서울">서울</option>
                            <option value="경기">경기</option>
                            <option value="인천">인천</option>
                            <option value="강원도">강원도</option>
                            <option value="충청도">충청도</option>
                            <option value="전라도">전라도</option>
                            <option value="경상도">경상도</option>
                          </select>
                    </div>
                    <div class="myPage-row">
                        <label>이메일</label>
                        <input type="email" name="memberEmail" id="memberEmail" value="${loginMember.memberEmail}" maxlength="30">
                        
                        <button id="emailBtn" type="button">인증하기</button>
                    </div>
                        <article class = "myPage-row" id="">
                            <input type="hidden" class="inputs" id="authenticationInput" name="authenticationInput" placeholder="인증번호를 입력해주세요.">
                            <input type="hidden" id="authenticationButton" name="authenticationButton">
                        </article>
                    <div class="myPage-row">
                        <label>닉네임</label>
                        <input type="text" name="memberNickname" id="memberNickname" value="${loginMember.memberNickname}" maxlength="10">
                    </div>
                    
                    <div class="myPage-row">
                        <label>전화번호</label>
                        <input type="text" name="memberPhone" value="${loginMember.memberPhone}" maxlength="11">
                    </div>

                    <span id="innerTextSpan2">아이디, 이름, 성별, 국가  변경 불가능</span>
                    <button id="info-update-btn" >수정하기</button>
                </form>


            </section>


        </section>

    </main>
        <!-- <script>
            const memberEmail = "${loginMember.memberEmail}";
        </script> -->
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
        <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
        <script src="${contextPath}/resources/js/Changee-information.js"></script>
    
</body>
</html>