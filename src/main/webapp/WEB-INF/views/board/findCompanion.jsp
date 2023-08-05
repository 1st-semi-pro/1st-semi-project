<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="companionList" value="${map.companionList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>동행자구하기</title>
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
    
    
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/findCompanion.css">
   
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <c:choose>

            <c:when test="${empty sessionScope.loginMember}">
                <article id="empty-login">
                    <h1>로그인회원전용 페이지입니다. 로그인후 이용해주세요!</h1>
                </article>
             </c:when>

            <c:otherwise>

                <section class="main-title"> 동행자구하기</section>
                <section id="content-box">
                    <section id="main-content">
                        <c:forEach var="companionList" items="${companionList}">
                            <article id="main-content-box">
                                <div id="ft-content">
                                    <div class="ft-img">
                                        <img src="../resources/images/festival_infomation/79.png" alt="">
                                    </div>
                                    <div class="ft-text">
                                        <h1>${companionList.boardTitle}</h1><span>서울특별시</span><span class="margin">|</span><span>2023.03.07 ~ 2023.04.08</span>
                                    </div>
                                    <div class="my-img">
                                        <img src="../resources/images/festival_infomation/181.gif">
                                        <div class="my-text"><span>안녕하세요 저는 ESFJ이고 혈액형은 B형 거주지역은 서울입니다. <br>좋은추억만들어봐요 ^~^</span>
                                        <button type="button">채팅하기</button><button type="button">게시글수정</button></div>
                                    </div>
                                </div>
                            </article>
                          </c:forEach>
                          <section id="page-area">

                            <c:set var="url" value="festivalInfo?type=${param.type}&pop=${param.pop}&cp="/>
                            <ul class="pagination">
                                <li><a href="${url}1${sURL}">&lt;&lt;</a></li>
                                <li><a href="${url}${pagination.prevPage}${sURL}">&lt;</a></li>
                                
                                <!-- 범위가 정해진 일반 for문 사용 -->
                                <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                                    <c:choose>
                                        <c:when test="${i == pagination.currentPage}">
                                            <li><a class="current">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="${url}${i}${sURL}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                    
                                <li><a href="${url}${pagination.nextPage}${sURL}">&gt;</a></li>
                                <li><a href="${url}${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
                                
                            </ul>
                        </section>
                    </section>
                </section>
            </c:otherwise>
        </c:choose>

       
                
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </main>

    
    

</body>
</html>