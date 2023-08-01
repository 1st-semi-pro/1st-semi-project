<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인페이지</title>

    <link rel="stylesheet" href="resources/css/header.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <script src="https://kit.fontawesome.com/16679b9adf.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>


</head>
<body>
    
    	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
      <div class="content">
        
        	
            
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
        
                 
         <div class="content-1"> <!-- 한반도 + 게시판 -->
            <div class="korea"> <!-- 한반도 -->
               <img src="resources/images/korea/seoul.png" id="seoul">
               <img src="resources/images/korea/Gyeonggi.png" id="gyeonggi">
               <img src="resources/images/korea/incheon.png" id="incheon">
               <img src="resources/images/korea/gangwon.png" id="gangwon">
               <img src="resources/images/korea/chungnam.png" id="chungnam">
               <img src="resources/images/korea/daejeon.png" id="daejeon">
               <img src="resources/images/korea/chungbuk.png" id="chungbuk">
               <img src="resources/images/korea/gyeongsang.png" id="gyeongsang">
               <img src="resources/images/korea/daegu.png" id="daegu">
               <img src="resources/images/korea/jeonbuk.png" id="jeonbuk">
               <img src="resources/images/korea/jeonnam.png" id="jeonnam">
               <img src="resources/images/korea/gwangju.png" id="gwangju">
               <img src="resources/images/korea/gyeongnam.png" id="gyeongnam">
               <img src="resources/images/korea/jeju.png" id="jeju">
               <img src="resources/images/korea/busan.png" id="busan">
               <img src="resources/images/korea/ulsan.png" id="ulsan">
            </div>


            <div> <!-- 게시판 모음1 -->
               <div class="board1">
                  <div class="board-name1">공지 게시판</div>
                     <div class="board-content1">
                        <table>
                           <tbody id="bList1">
                             
                              
                           </tbody>
                        </table>
                     </div>
                  </div>

               <div class="board2">
                  <div class="board-name2">축제 후기</div>
                     <div class="board-content2">
                        <table>
                           <tbody id="bList2">
                              
                           </tbody>
                        </table>

                     </div>
                  </div>
               </div>

            <div> <!-- 게시판 모음2 -->
               <div class="board3">
                  <div class="board-name3">자유 게시판</div>
                     <div class="board-content3">
                        <table>
                          
                        </table>
                     </div>
                  </div>

               <div class="board4">
                  <div class="board-name4">동행자 구하기</div>
                  <div class="board-content4">
                     <table>
                        
                     </table>
                  </div>
               </div>
            </div>
         </div>
      </div>

      <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

      <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

      <script src="${contextPath}/resources/js/main.js"></script>
    
</body>
</html>