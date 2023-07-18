<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인페이지</title>

    <link rel="stylesheet" href="resources/css/index.css">
    <script src="https://kit.fontawesome.com/16679b9adf.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">


</head>
<body>
    
    	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
        <div class="content">
        
        	                  <div > <!-- 배너 + 로그인 칸 -->
                      <div class="banner">
                          <div >
                           <div><a href="#" id="prevft">&lt;</a></div>
                           <a href="${contextPath}/member/manage">임시버튼</a>
                        </div>
                          <div></div>
                          <div><a href="#" id="nextft">&gt;</a></div>
                      </div>
        	
        
           <c:choose>
           
              <c:when test="${empty sessionScope.loginMember }">

                      <div class="login">
                      
                         <div>
                     <a href="${contextPath}/member/login"><button id="loginBtn">로그인</button></a>
                         </div>
                   
                         
                        <article id="signup-find-area">
                                  <a href="#">내 정보찾기</a>
                                  <span>/</span> 
                                  <a href="#">회원가입</a>
                              </article>
                         
                         
                      </div>
                  </div>
              
              </c:when>
              
              <c:otherwise>
                 <article class="login-area">
                     
                        <!-- 회원 프로필 이미지 -->
                        <a href="#">
                           <img src="" id="member-profile">
                        </a>
                        
                        <!-- 회원 정보 + 로그아웃 버튼 -->
                        <div class="my-info">
                           <div>
                              <a href="#" id="nickname">유저 닉네임</a>
                              
                              <a href="#" id="logout-btn">로그아웃</a>
                           </div>
                           
                           <p>
                              유저 이메일
                           </p>
                        </div>
                        
                     </article>
              </c:otherwise>
           
           </c:choose>
           
           
            <div class="content-1"> <!-- 한반도 + 게시판 -->
            <div class="korea"> <!-- 한반도 -->
               <img src="resources/images/korea.png">
            </div>
            <div> <!-- 게시판 모음1 -->
               <div class="board1">
                  <div class="board-name1">공지 게시판</div>
                  <div class="board-content1"></div>
               </div>
               <div class="board2">
                  <div class="board-name2">축제 후기</div>
                  <div class="board-content2"></div>
               </div>
            </div>
            <div> <!-- 게시판 모음2 -->
               <div class="board3">
                  <div class="board-name3">자유 게시판</div>
                  <div class="board-content3"></div>
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