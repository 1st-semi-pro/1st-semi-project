<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- map에 저장된 값을 각각 변수에 저장 -->
<c:set var="festivalName" value="${map.festivalName}"/>
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="festivalList" value="${map.festivalList}"/>
<c:set var="imgList" value="${map.imgList}"/>

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
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <c:if test="${!empty param.festivalDate || !empty param.festivalArea || !empty param.festivalCat}">
            <c:set var="sURL" value="&festivalDate=${param.festivalDate}&festivalArea=${param.festivalArea}&festivalCat=${param.festivalCat}"/>
        </c:if>

        <div class="swiper mySwiper">
            <div class="swiper-wrapper">
              <div class="swiper-slide"><img src="${contextPath}/resources/images/festival_infomation/22.png"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/festival_infomation/42.png"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/festival_infomation/69.png"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/festival_infomation/72.png"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/festival_infomation/73.png"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/festival_infomation/77.png"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/festival_infomation/79.png"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/festival_infomation/86.png"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/festival_infomation/93.png"></div>
              <div class="swiper-slide"><img src="${contextPath}/resources/images/festival_infomation/58.png"></div>
            </div>
            <div class="swiper-pagination"></div>
          </div>

    <!-- 검색게시판 타이틀 -->
    <section class="title-box"> ${festivalName} 게시판</section>
   
    <!-- 컨텐츠 -->
    <section class="content">
        <form action="festivalInfo" method="get" id="festivalSearch" onsubmit="return searchValidate()">
            <input type="hidden" name="type" value="${param.type}">
            <input type="hidden" name="pop" value="${param.pop}">

            <div class="search-box-wrap">
                <div class="select-box select-date">
                    <label for="festivalDate">날짜</label>
                    <select name="festivalDate" id="festivalDate" title="날짜">
                        <option value="">날짜</option>
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
                        <option value="">지역</option>
                        <option value="서울특별시">서울특별시</option>
                        <option value="경기도">경기도</option>
                        <option value="강원도">강원도</option>
                        <option value="인천">인천</option>
                        <option value="충청북도">충청북도</option>
                        <option value="충청남도">충청남도</option>
                        <option value="대전">대전</option>
                        <option value="경상북도">경상북도</option>
                        <option value="전라북도">전라북도</option>
                        <option value="대구">대구</option>
                        <option value="울산">울산</option>
                        <option value="부산">부산</option>
                        <option value="경상남도">경상남도</option>
                        <option value="광주">광주</option>
                        <option value="전라남도">전라남도</option>
                        <option value="제주도">제주도</option>
                        <option value="세종특별자치시">세종특별자치시</option>
                    </select>
                </div>
                <div class="select-box select-cat">
                    <label for="festivalCat">카테고리</label>
                    <select name="festivalCat" id="festivalCat" title="카테고리">
                        <option value="">카테고리</option>
                        <option value="가족">가족</option>
                        <option value="연인">연인</option>
                        <option value="꽃">꽃</option>
                        <option value="힐링">힐링</option>
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

            <c:if test="${param.pop == 0 && param.festivalDate == null }">
                <a href="${contextPath}/board/festivalInfo?type=1&pop=1&festivalDate=${param.festivalDate}&festivalArea=${param.festivalArea}&festivalCat=${param.festivalCat}"><i class="fa-solid fa-star" style="color: #fff047;"></i><span id="popularity">인기순</span></a>
                <a href="${contextPath}/board/festivalInfo?type=1&pop=0" ><span id="festival-date" class="color">전체</span></a>
            </c:if>

            <c:if test="${param.pop == 0 && param.festivalDate !=null }">
                <a href="${contextPath}/board/festivalInfo?type=1&pop=1&festivalDate=${param.festivalDate}&festivalArea=${param.festivalArea}&festivalCat=${param.festivalCat}"><i class="fa-solid fa-star" style="color: #fff047;"></i><span id="popularity">인기순</span></a>
                <a href="${contextPath}/board/festivalInfo?type=1&pop=0" ><span id="festival-date">전체</span></a>
            </c:if>

            <c:if test="${param.pop == 1 && param.festivalDate ==null }">
                <a href="${contextPath}/board/festivalInfo?type=1&pop=1&festivalDate=${param.festivalDate}&festivalArea=${param.festivalArea}&festivalCat=${param.festivalCat}"><i class="fa-solid fa-star" style="color: #fff047;"></i><span id="popularity">인기순</span></a>
                <a href="${contextPath}/board/festivalInfo?type=1&pop=0" ><span id="festival-date">전체</span></a>
            </c:if>
            
            <c:if test="${param.pop == 1 && param.festivalDate != null}">
                <a href="${contextPath}/board/festivalInfo?type=1&pop=1&festivalDate=${param.festivalDate}&festivalArea=${param.festivalArea}&festivalCat=${param.festivalCat}"><i class="fa-solid fa-star" style="color: #fff047;"></i><span id="popularity" class="color">인기순</span></a>
                <a href="${contextPath}/board/festivalInfo?type=1&pop=0" ><span id="festival-date">전체</span></a>
            </c:if>
        </div><!-- ${imgList[status.index].imageReName} -->
        <c:choose>
            <c:when test="${empty festivalList}">
                <div class="empty">
                    <h1>축제정보가 없습니다!!</h1>
                </div>
            </c:when>
            <c:otherwise>
                <div id="grid-container">
                <c:forEach var="festival" items="${festivalList}" varStatus="status">
                        <div class="item">
                            <div class="item-image"><a href="festivalDetail?festivalNo=${festival.festivalNo}">
                                <img src="${contextPath}/resources/images/festival_infomation/${festival.festivalNo}.png">
                                </a>
                            </div>

                           	<div class="item-text">
                                <a href="#">
                                <div class="item-title"><h1>${festival.festivalTitle}</h1></div>
                                <c:if test="${festival.festivalDate != null}">
                                <div class="item-content"><span>${festival.festivalArea}</span><span>${festival.festivalDate}</span></div>
                                </c:if>
                                </a>
                                <c:if test="${festival.readCount > 0 }">
                                    <div class="pop"><i class="fa-solid fa-star" style="color: #fff047;"></i><span>${festival.readCount}</span></div>
                                </c:if>
                            </div>
                        </div>
                </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
    </section>
    
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

        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </main>

    <script>
        const contextPath = "${contextPath}";
    </script>
    
    <script src="${contextPath}/resources/js/festivalInformation.js"></script>
    
</body>
</html>