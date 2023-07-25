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


</head>
<body>
    
    	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
      <div class="content">
        
        	<div class="banner"> <!-- 배너 칸 -->
            <div>
               1
               <a href="${contextPath}/board/memberList?type=0">회원관리</a>
            </div>
            <div><img src="#"></div>
            <div>3</div>
         </div>
           
         <div class="content-1"> <!-- 한반도 + 게시판 -->
            <div class="korea"> <!-- 한반도 -->
               <img src="resources/images/korea.png">
            </div>
            <div> <!-- 게시판 모음1 -->
               <div class="board1">
                  <div class="board-name1">공지 게시판</div>
                     <div class="board-content1">
                        <table>
                           <tr>
                              <th><a href="#">1번 공지 게시글입니다.</a></th>
                           </tr>
                           <tr>
                              <th><a href="#">2번 공지 게시글입니다.</a></th>
                           </tr>
                           <tr>
                              <th><a href="#">3번 공지 게시글입니다.</a></th>
                           </tr>
                           <tr>
                              <th><a href="#">4번 공지 게시글입니다.</a></th>
                           </tr>
                           <tr>
                              <th><a href="#">5번 공지 게시글입니다.</a></th>
                           </tr>
                           <tr>
                              <th><a href="#">6번 공지 게시글입니다.</a></th>
                           </tr>
                           <tr>
                              <th><a href="#">7번 공지 게시글입니다.</a></th>
                           </tr>
                           <tr>
                              <th><a href="#">8번 공지 게시글입니다.</a></th>
                           </tr>
                           <tr>
                              <th><a href="#">9번 공지 게시글입니다.</a></th>
                           </tr>
                           <tr>
                              <th><a href="#">10번 공지 게시글입니다.</a></th>
                           </tr>
                        </table>
                     </div>
                  </div>

               <div class="board2">
                  <div class="board-name2">축제 후기</div>
                     <div class="board-content2">

                     </div>
                  </div>
               </div>

            <div> <!-- 게시판 모음2 -->
               <div class="board3">
                  <div class="board-name3">자유 게시판</div>
                     <div class="board-content3">

                     </div>
                  </div>

               <div class="board4">
                  <div class="board-name4">동행자 구하기</div>
                  <div class="board-content4"></div>
               </div>
            </div>
         </div>
      </div>

      <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
</body>
</html>