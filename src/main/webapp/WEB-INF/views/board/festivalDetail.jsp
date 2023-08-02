<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- map에 저장된 값을 각각 변수에 저장 -->
<c:set var="festival" value="${map.festival}"/>
<c:set var="festivalDetail" value="${map.festivalDetail}"/>
<c:set var="imgList" value="${map.imgList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>축제 상세페이지</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/festivalDetail.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>

    <!-- 지도 -->
    <!-- <script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=vo8pyrmnk8"></script> -->
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=vo8pyrmnk8"></script>

    <!-- geocoding -->
    <script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=vo8pyrmnk8&submodules=geocoder"></script>

</head>

<body>

    <main>

    <div id="allDiv">
        <!-- 이미지 변수설정으로 쉽게 사용 메인 썸네일 1, 추가이미지 -->
        <c:forEach items="${imgList}" var="imgList">
        
            <c:choose>

                <c:when test="${imgList.imageLevel == 0}">
                    <c:set var="img0" value="${contextPath}${imgList.imageReName}"/>
                </c:when>

                <c:when test="${imgList.imageLevel == 1}">
                    <c:set var="img1" value="${contextPath}${imgList.imageReName}"/>
                </c:when>

                <c:when test="${imgList.imageLevel == 2}">
                    <c:set var="img2" value="${contextPath}${imgList.imageReName}"/>
                </c:when>

                <c:when test="${imgList.imageLevel == 3}">
                    <c:set var="img3" value="${contextPath}${imgList.imageReName}"/>
                </c:when>

                <c:when test="${imgList.imageLevel == 4}">
                    <c:set var="img4" value="${contextPath}${imgList.imageReName}"/>
                </c:when>

                <c:when test="${imgList.imageLevel == 5}">
                    <c:set var="img5" value="${contextPath}${imgList.imageReName}"/>
                </c:when>

                <c:when test="${imgList.imageLevel == 6}">
                    <c:set var="img6" value="${contextPath}${imgList.imageReName}"/>
                </c:when>

            </c:choose>

        </c:forEach>

        <div id="thumbNailDiv">
            <img src="${img0}">
            <a href="${contextPath}" id="Nav1">메인페이지로</a>
            <a href="${header.referer}" id="Nav2">축제 검색 페이지로</a>
        </div>

        <div id="info">

            <div id="contentAndBtns">
                ${festivalDetail.festivalContent}
                <button id="btn1" class="btns">관심축제 등록</button>
                <button id="btn2" class="btns">좋아요</button>
            </div>

        </div>


        <div class="swiper mySwiper">
            <div class="swiper-wrapper">
                <div class="swiper-slide"><img src="${img0}"></div>
                <div class="swiper-slide"><img src="${img0}"></div>
                <div class="swiper-slide"><img src="${img0}"></div>
                <div class="swiper-slide"><img src="${img0}"></div>
                <div class="swiper-slide"><img src="${img0}"></div>
                <div class="swiper-slide"><img src="${img0}"></div>
            </div>
            <div class="swiper-pagination"></div>
        </div>


        <div id="contents">
            <div>

            </div>
        </div>

        <div id="imageAndContent">
            <div id="halfImage">
                <img src="${img0}">
            </div>



            <div id="halfContent">
                <div>${festivalDetail.festivalDetailInfo}</div>

                <div>개별 축제 홈페이지 링크 달 수 있다면 달기</div>
            </div>
        </div>

        <div id="findWayApi">
            
            <div id="map" style="width:80%;height:400px;"></div>
          
            <div id="searchAddress">
            <input id="address" type="text" placeholder="검색할 주소" id="address">
            <input id="submit" type="button" value="주소 검색" id="sear">
            </div>    

        </div>

        <div id="youtube">
            해당축제 유튜브 있으면 띄우기
        </div>

        <div id="similar">
            비슷 축제 4개 뽑기
        </div>

        
        
        
    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
    </main>


    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script src="${contextPath}/resources/js/festivalDetail.js"></script>
</body>
</html>