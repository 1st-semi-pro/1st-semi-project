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
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=vo8pyrmnk8"></script>

    <!-- geocoding -->
    <script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=vo8pyrmnk8&submodules=geocoder"></script>

    <script>
        
        /* ajax에서 쓰기 위함 */
        const festivalNo = "${festival.festivalNo}";
        const memberNo = "${loginMember.memberNo}";
        const contextPath = "${contextPath}";
        const festivalTitle = "${festival.festivalTitle}";

    </script>

</head>

<body>

    <main>

    <div id="allDiv">




        <!-- 이미지 변수설정으로 쉽게 사용 -->
        <!-- 0 = 썸네일 1~6 = 상세 이미지들 7 = half이미지 -->
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

                <c:when test="${imgList.imageLevel == 7}">
                    <c:set var="img7" value="${contextPath}${imgList.imageReName}"/>
                </c:when>

            </c:choose>

        </c:forEach>

        <!-- 썸네일 -->
        <div id="thumbNailDiv">
            <img src="${img0}">
            <a href="${contextPath}" id="Nav1" class="navs">메인페이지로</a>
            <a href="${header.referer}" id="Nav2" class="navs">축제 검색 페이지로</a>
        </div>

        <!-- 기본 정보, 찜하기 -->
        <div id="info">
            
            <div id="contentAndBtn">

                <div id="slogan">${festivalDetail.festivalSlogan}</div>
                <div id="festivalTitle">${festival.festivalTitle}</div>
                <div id="festivalDt">${festival.festivalDate}</div>
                        <!-- img 1~6 스위퍼 -->
                
                <!-- 이미지 없으면 스위퍼 안열기 1개라도 넣으면 6개 다 넣을거임 --> 
                <c:if test="${!empty img1}">

                    <div class="swiper mySwiper">
                        <div class="swiper-wrapper">
                            <div class="swiper-slide"><img src="${img1}"></div>
                            <div class="swiper-slide"><img src="${img2}"></div>
                            <div class="swiper-slide"><img src="${img3}"></div>
                            <div class="swiper-slide"><img src="${img4}"></div>
                            <div class="swiper-slide"><img src="${img5}"></div>
                            <div class="swiper-slide"><img src="${img6}"></div>
                        </div>
                        <div class="swiper-pagination"></div>
                    </div>

                </c:if>

                <div id="festivalContent">${festival.festivalContent}</div>
                
                <div id="readCount">조회수 : ${festival.readCount}</div>

                <!-- 관심축제 등록 button -->
                <jsp:include page="/WEB-INF/views/board/dib.jsp"/>
                <!-- ajax로 계속 바뀌어야 해서 구분하려고 include 형식으로 jsp 하나 만듬 -->
            
            </div>
        
        </div>
        
        <!-- height만 준 div -->
        <div class="brDiv"></div>

        <!-- 상세정보 -->

        <div id="imageAndContent">
            
            
            <!-- 이미지7이 있을 때만 -->
            <c:if test="${!empty img7}">

                <div id="halfImage">
                    <img src="${img7}">
                </div>

            </c:if>
       

            <div id="halfContent">

                <div> 
                
                    <article class="halfArticle">
                        <div><img src = "${contextPath}/resources/images/festival_infomation/info1.png"></div>
                        <div class="contents">${festival.festivalDate}</div>
                    </article>

                    <article class="halfArticle">
                        <div><img src = "${contextPath}/resources/images/festival_infomation/info2.png"></div>
                        <div class="contents">${festival.festivalArea}</div>
                    </article>    

                    <article class="halfArticle">
                        <div><img src = "${contextPath}/resources/images/festival_infomation/info3.png"></div>
                        <div class="contents">${festivalDetail.festivalFreeFl}</div>
                    </article>  
                    
                    <article class="halfArticle">
                        <div><img src = "${contextPath}/resources/images/festival_infomation/info4.png"></div>
                        <div class="contents">${festivalDetail.festivalPhone}</div>
                    </article>    

                    <article class="halfArticle">
                        <div><img src = "${contextPath}/resources/images/festival_infomation/info5.png"></div>
                        <div class="contents">${festivalDetail.festivalRelatedAgencies}</div>
                    </article>   

                </div>

            </div>

        </div>

        <!-- height만 준 div -->
        <div class="brDiv"></div>

        <div id="findWayApi">
            
            <!-- 네이버 지도 -->
            <div id="map"></div>
          
            <div id="searchAddress">

                <input id="address" type="text" placeholder="검색할 주소를 입력해주세요." id="address">
                <input id="submit" type="button" value="주소 검색" id="search" 
                        style="width:100px !important; height:40px !important; 
                        border:0 !important; border-radius:10px !important; 
                        background-color: lightcoral !important; 
                        font-size:20px !important; cursor:pointer !important;">
                        <!-- api떄문에 css에서의 style이 안먹는듯 -->

            </div>    

        </div>

        <div class="brDiv"></div>

        <!-- youtube 부분 -->
        <c:if test="${!empty festivalDetail.festivalYoutube}">
            
            <div id="youtubeLogo">
                <img src="${contextPath}/resources/images/festival_infomation/youtubelogo.png" id="youtubeImage">
            </div>

            <div id="youtube">

            <iframe width="1100" height="580" 
                src="${festivalDetail.festivalYoutube}" 
                frameborder="0" 
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
                allowfullscsreen></iframe>
            </div>

        </c:if>

        <div class="brDiv"></div>

        <div id="similar">
           <!-- 랜덤 축제 4개 뽑기 임시 -->
           <div id="similarTell">이런 축제는 어떠세요?</div>

            <!-- <img src="이미지경로/<%= 1 + Math.floor(Math.random() * 15.99) %>.jpg"/> -->
            <div id="randomImage">

            <%
                for(int i = 0; i < 4; i++){
            %>
                
                <a href="#">
                    <img src="${contextPath}/resources/images/festival_infomation/<%= 1 + (int)(Math.random() * 100) %>.png" class="randomImages">
                </a>
            
            <%
                }
            %>

            </div>    
        </div>
        
    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
    </main>


    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script src="${contextPath}/resources/js/festivalDetail.js"></script>

</body>
</html>