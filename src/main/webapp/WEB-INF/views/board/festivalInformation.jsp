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
    
    <link rel="stylesheet" href="${contextPath}/resources/css/festivalInformation.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
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
        <c:if test="${!empty param.key}">
            <c:set var="sURL" value="&key=${param.key}&query=${param.query}"/>
        </c:if>

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
        <form action="festivalInfo" method="get" id="festivalSearch" onsubmit="return searchValidate()">
            <input type="hidden" name="type" value="${param.type}">
            <input type="hidden" name="ft" value="${param.ft}">
            <input type="hidden" name="pop" value="${param.pop}">

            <div class="search-box-wrap">
                <div class="select-box select-date">
                    <label for="festivalDate">날짜</label>
                    <select name="festivalDate" id="festivalDate" title="날짜">
                        <option value >★-날짜-★</option>
                        <option value="01">01월</option>
                        <option value="02">02월</option>
                        <option value="03">03월</option>
                        <option value="04">04월</option>
                        <option value="05">05월</option>
                        <option value="06">06월</option>
                        <option value="07">07월</option>
                        <option value="08">08월</option>
                        <option value="09">09월</option>
                        <option value="10">10월</option>
                        <option value="11">11월</option>
                        <option value="12">12월</option>
                    </select>
                </div>
        
                <div class="select-box select-area">
                    <label for="festivalArea">지역</label>
                    <select name="festivalArea" id="festivalArea" title="지역">
                        <option value="">★-지역-★</option>
                        <option value="서울특별시">서울특별시</option>
                        <option value="경기도">경기도</option>
                        <option value="강원도">강원도</option>
                        <option value="인천광역시">인천광역시</option>
                        <option value="충청북도">충청북도</option>
                        <option value="충청남도">충청남도</option>
                        <option value="대전광역시">대전광역시</option>
                        <option value="경상북도">경상북도</option>
                        <option value="전라북도">전라북도</option>
                        <option value="대구광역시">대구광역시</option>
                        <option value="울산광역시">울산광역시</option>
                        <option value="부산광역시">부산광역시</option>
                        <option value="경상남도">경상남도</option>
                        <option value="광주광역시">광주광역시</option>
                        <option value="전라남도">전라남도</option>
                        <option value="제주특별자치도">제주특별자치도</option>
                        <option value="세종특별자치시">세종특별자치시</option>
                    </select>
                </div>
                <div class="select-box select-cat">
                    <label for="festivalCat">카테고리</label>
                    <select name="festivalCat" id="festivalCat" title="카테고리">
                        <option value="">★-카테고리-★</option>
                        <option value="연인">연인</option>
                        <option value="술">술</option>
                        <option value="꽃">꽃</option>
                        <option value="불꽃">불꽃</option>
                        <option value="여름">여름</option>
                        <option value="바다">바다</option>
                        <option value="도심">도심</option>
                    </select>
                </div>
                <button type="reset" id="reset"></button>
                <button type="submit" id="info-search">검색</button>
            </div>

        </form>
        
    </section>

    <section class="content2">
        <div id="span-box">

            <c:if test="${param.pop == 0 && param.ft == 0}">
                <a href="${contextPath}/board/festivalInfo?cp=1&type=4&ft=1&pop=0" ><span id="festival-date" name="festival-date" value="dt">축제일순</span></a>
                <a href="${contextPath}/board/festivalInfo?cp=1&type=4&pop=1&ft=0" ><span id="popularity" name="popularity" value="dt">인기순</span></a>
            </c:if>

            <c:if test="${param.ft == 1}">
                <a><span id="festival-date" class="color" name="festival-date" value="dt">축제일순</span></a>
            </c:if>
            
            <c:if test="${param.ft == 0 && param.pop == 1}">
                <a href="${contextPath}/board/festivalInfo?cp=1&type=4&ft=1&pop=0" ><span id="festival-date" name="festival-date" value="dt">축제일순</span></a>
            </c:if>

            <c:if test="${param.pop == 1}">
                <a><span id="popularity" class="color" name="popularity" vaule="pop">인기순</span></a>
            </c:if>
            <c:if test="${param.pop == 0 && param.ft == 1}">
                <a href="${contextPath}/board/festivalInfo?cp=1&type=4&pop=1&ft=0" ><span id="popularity" name="popularity" value="dt">인기순</span></a>
            </c:if>
            
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

        <c:set var="url" value="festivalInfo?type=${param.type}&ft=${param.ft}&pop=${param.pop}&cp="/>
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
    </script>
    

    <script src="${contextPath}/resources/js/festivalInformation.js"></script>
    
</body>
</html>