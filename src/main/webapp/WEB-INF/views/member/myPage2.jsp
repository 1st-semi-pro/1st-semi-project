<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    <title>마이페이지</title>
</head>
<body>
    <main id="contain">
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section id="content">
        
            <div class="title">${viewMember.memberNickname}님의 프로필</div>
            <section>
                <article class="sub-title">프로필</article>
            </section>
            <section>
                
                <form action="myPage" method="post" name="myPage-form"
                    enctype="multipart/form-data" onsubmit="return profileValidate()">
                    <section id="info-box">

                        <div class = profile-image-area>
                            <span>프로필 이미지</span>
                            <c:if test="${empty viewMember.memberProfileImage}"> <!-- 프로필 이미지 없는 경우-->
                                <img src="${contextPath}/resources/images/default_profile.png" id="profile-image">
                            </c:if>
                            <c:if test="${!empty viewMember.memberProfileImage}">  <!-- 프로필 이미지 있는 경우-->
                                <img src="${contextPath}${viewMember.memberProfileImage}" id="profile-image">
                            </c:if>
    
                            <div class="profile-btn-area">
                                <!-- accept="image/* : 이미지 파일 확장자만 섵택 허용" -->
                                <!-- accept="video/* : 동영상 파일 확장자만 섵택 허용" -->
                                <!-- accept=".pdf/* :  파일 확장자만 섵택 허용" -->
                                <!-- 프로필 이미지 삭제 버튼 -->
                            </div>
                        </div>
                        
                        <section>
                            <article id="intro">
                                <span>프로필 메세지</span>
                                <textarea name="profileMessage" id="profile-message" cols="80" rows="10">${viewMember.memberMessage}</textarea>
                            </article>
                            <article>
                                <span>축제 히스토리</span>
                                <div id="history" name="memberHistory">${viewMember.enrollDate}</div>
    
                                <div id="info-btn-area">
                                    <div>
                                        <img src="${contextPath}/resources/images/good.png" alt="칭찬 횟수" class="mypage-icon">
                                        <span class="mypage-span" id="good-span">28회</span>
                                    </div>
                                    <div>
                                        <img src="${contextPath}/resources/images/report.png" alt="신고 횟수" class="mypage-icon">
                                        <span class="mypage-span" id="report-span">0회</span>
                                    </div>
                                </div>
    
                            </article>
                        </section>
                    </section>
                    
                    <!-- 삭제버튼(x)이 눌러짐을 기록하는 숨겨진 input 태그 -->
                    <!-- 0 : 안눌러짐, 1: 눌러짐 -->
                    <input type="hidden" name="delete" id="delete" value="0">
                </form>

                

                <section>
                    <article class="sub-title">관심목록</article>
                </section>
                <section id="festival-box">
                    <article>
                        <h1>축제이름</h1>
                        <a href="#"><img src="${contextPath}/resources/images/con1.jpg" alt="축제사진"></a>
                    </article>
                    <article>
                        <h1>축제이름</h1>
                        <a href="#"><img src="${contextPath}/resources/images/con2.jpg" alt="축제사진"></a>
                    </article>
                    <article>
                        <h1>축제이름</h1>
                        <a href="#"><img src="${contextPath}/resources/images/con3.jpg" alt="축제사진"></a>
                    </article>
                    <article>
                        <h1>축제이름</h1>
                        <a href="#"><img src="${contextPath}/resources/images/con4.jpg" alt="축제사진"></a>
                    </article>
                </section>
            </section>
        </section>
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script>
        const contextPath = "${contextPath}"; // 최상위 경로를 JS 전역변수로 선언
    </script>

    <script src="${contextPath}/resources/js/myPage.js"></script>
    
</body>
</html>
