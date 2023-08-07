<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        
            <div class="title">마이페이지</div>
            <section>
                <article class="sub-title">프로필</article>
            </section>
            <section>
                
                <form action="myPage" method="post" name="myPage-form"
                    enctype="multipart/form-data" onsubmit="return profileValidate()">
                    <section id="info-box">

                        <div class = profile-image-area>
                            <span>프로필 이미지</span>
                            <c:if test="${empty loginMember.memberProfileImage}"> <!-- 프로필 이미지 없는 경우-->
                                <img src="${contextPath}/resources/images/default_profile.png" id="profile-image">
                            </c:if>
                            <c:if test="${!empty loginMember.memberProfileImage}">  <!-- 프로필 이미지 있는 경우-->
                                <img src="${contextPath}${loginMember.memberProfileImage}" id="profile-image">
                            </c:if>
    
                            <div class="profile-btn-area">
                                <label for="input-image">이미지 선택</label>
                                <input type="file" name="memberProfileImage" id="input-image" accept="image/*">
                                <!-- accept="image/* : 이미지 파일 확장자만 섵택 허용" -->
                                <!-- accept="video/* : 동영상 파일 확장자만 섵택 허용" -->
                                <!-- accept=".pdf/* :  파일 확장자만 섵택 허용" -->
                                <span id="delete-image-btn">이미지 삭제</span>
                                <!-- 프로필 이미지 삭제 버튼 -->
                            </div>
                        </div>
                        
                        <section>
                            <article id="intro">
                                <span>프로필 메세지</span>
                                <textarea name="profileMessage" id="profile-message" spellcheck="false" cols="80" rows="5">${loginMember.memberMessage}</textarea>
                            </article>
                            <article>
                                <span>축제 히스토리</span>
                                <div id="history" name="memberHistory">
                                    <span>2023.07.26 서울거리공연 [버스커페스티벌]</span>
                                    <span>2023.06.23 세종파크뮤직페스티벌</span>
                                </div>
    
                                <div id="info-btn-area">
                                    <div>
                                        <img src="${contextPath}/resources/images/good.png" alt="칭찬 횟수" class="mypage-icon">
                                        <span class="mypage-span" id="good-span">${goodNum}</span>
                                    </div>
                                    <div>
                                        <img src="${contextPath}/resources/images/report.png" alt="신고 횟수" class="mypage-icon">
                                        <span class="mypage-span" id="bad-span">${badNum}</span>
                                    </div>
                                    <a href="${contextPath}/member/pwConfirm"><button type="button" class="mypage-btn" id="update-btn">내 정보 수정</button></a>
                                    <button type="submit" class="mypage-btn" id="save-btn">변경사항 저장</button>
                                </div>
                            </article>
                        </section>
                    </section>
                    
                    <!-- 삭제버튼(x)이 눌러짐을 기록하는 숨겨진 input 태그 -->
                    <!-- 0 : 안눌러짐, 1: 눌러짐 -->
                    <input type="hidden" name="deleteImage" id="delete-image" value="0">
                    <input type="hidden" name="changeImage" id="change-image" value="0">
                    <input type="hidden" name="changeMessage" id="change-message" value="0">
                </form>
                
                <section>
                    <article class="sub-title">관심목록</article>
                </section>
                <div id="festival-box">
                    <c:choose>
                        <c:when test="${empty dipList}">
                            <div class="empty">
                                <h1>관심목록이 없습니다, 축제를 둘러보고 찜하기를 눌러보세요~!</h1>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="festival" items="${dipList}" varStatus="status">
                                <article>
                                    <h1>${festival.festivalTitle}</h1>
                                    <h5>${festival.festivalArea} ${festival.festivalDate}</h5>
                                    <a href="${contextPath}/board/festivalDetail?festivalNo=${festival.festivalNo}"><img src="${contextPath}${festival.festivalImage}" alt="축제사진"></a>
                                </article>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
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
