<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- map에 저장된 값을 각각 변수에 저장 -->
<c:set var="festivalName" value="${map.festivalName}"/>
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="festivalList" value="${map.festivalList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>축제정보</title>
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
    
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/festivalInformation.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
   
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
        <div class="swiper mySwiper">
            <div class="swiper-wrapper">
              <div class="swiper-slide"><img src="${contextPath}/resources/images/con2.jpg"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/con3.jpg"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/con1.jpg"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/con2.jpg"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/con3.jpg"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/con1.jpg"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/con3.jpg"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/con2.jpg"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/con1.jpg"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/con2.jpg"></div>
            </div>
            <div class="swiper-pagination"></div>
          </div>

    <!-- 검색게시판 타이틀 -->
    <section class="title-box"> ${festivalName} 게시판</section>

    <!-- 컨텐츠 -->
    <section class="content">
        <form action="">
        <div class="selectBoxList">
            <!-- selectBox1 -->
            <div class="box">
                <div class="selectBox ">
                    <div class="label">
                        <i class="fa-regular fa-calendar-check"></i>
                        <span> 시기별 :</span>
                        <span id="sp1"></span>
                    </div>
                    <ul class="optionList">
                        <li class="optionItem">2023년</li>
                        <li class="optionItem">2022년</li>
                        <li class="optionItem">2021년</li>
                        <li class="optionItem">2020년</li>
                        <li class="optionItem">2023년</li>
                        <li class="optionItem">2022년</li>
                        <li class="optionItem">2021년</li>
                        <li class="optionItem">2020년</li>
                    </ul>
                </div>
            </div>
            <!-- selectBox2 -->
            <div class="box">
                <div class="selectBox">
                    <div class="label">
                        <i class="fa-solid fa-map-location-dot"></i>
                        <span> 지역별 :</span>
                        <span id="sp2"></span>
                    </div>
                    <ul class="optionList">
                        <li class="optionItem">서울</li>
                        <li class="optionItem">경기도</li>
                        <li class="optionItem">부산</li>
                        <li class="optionItem">시발</li>
                    </ul>
                </div>
            </div>
            <!-- selectBox3 -->
            <div class="box">
                <div class="selectBox">
                    <div class="label">
                        <i class="fa-solid fa-tag"></i>
                        <span> 카테고리 :</span>
                        <span id="sp3"></span>
                    </div>
                    <ul class="optionList">
                        <li class="optionItem">카</li>
                        <li class="optionItem">테</li>
                        <li class="optionItem">고</li>
                        <li class="optionItem">리</li>
                    </ul>
                </div>
            </div>
            <button type="reset" id="reset"><i class="fa-solid fa-repeat"></i></button>
            <button type="submit" id="info-search">검색</button>
            </div>
        </form>
    </section>

    <section class="content2">
        <div id="span-box">
        <span class="festival-date">축제일순</span><span class="popularity">인기순</span>
        </div>
        <c:choose>
            <c:when test="${empty festivalList}">
                <div class="empty">
                    <h1>축제정보가 없습니다.</h1>
                </div>
            </c:when>
            <c:otherwise>
                <div id="grid-container">
                <c:forEach var="festival" items="${festivalList}">
                    
                        <div class="item">
                            <div class="item-image"><a href="#"><img src="${contextPath}/resources/images/con1.jpg" alt=""></a></div>
                            <div class="item-text">
                                <a href="#">
                                <div class="item-title"><h1>${festival.festivalTitle}</h1><span>${festival.festivalDate}</span></div>
                                <div class="item-content"><span>${festival.festivalContent}</span></div>
                                </a>
                            </div>
                        </div>
                </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
    </section>
    <section id="page-area">

        <c:set var="url" value="festivalInfo?type=${param.type}&cp="/>
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

        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </main>

    <script>
        const contextPath = "${contextPath}";
        const festivalNo = "${festivalList.festivalNo}"
    </script>
    

    <script src="${contextPath}/resources/js/festivalInformation.js"></script>
    
</body>
</html>