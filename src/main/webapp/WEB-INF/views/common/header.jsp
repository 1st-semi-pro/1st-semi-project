<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <header>
        <section class="header">

            <section>
                <a href="${contextPath}"><img src="${contextPath}/resources/images/logo.png" id="home-logo"></a>
            </section>

            <section>
                <article class="search-area">
                    <form action="#" name="search-form">
                        <fieldset>
                            <input type="search" id="search" name="search" size="35" placeholder=" 여행지를 찾아보세요." autocomplete="off">
                            <button type="submit" id="search-btn" class="fa-solid fa-magnifying-glass"></button>
                        </fieldset>
                    </form>
                </article>
            </section>
            <section>
            
            <c:choose>
           
              <c:when test="${empty sessionScope.loginMember }">

					<div class="h-login">
						<a href="${contextPath}/member/login">로그인 </a><span>/</span><a href="${contextPath}/member/findId">아이디 찾기 </a><span>/</span><a href="${contextPath}/member/agree"> 회원가입</a>
					</div>

              </c:when>
              
              <c:otherwise>
                 <article class="h-login-area">
                     
                        <!-- 회원 프로필 이미지 -->
                        <a href="#">
                            <img src="${contextPath}/resources/images/id.png" id="member-profile">
                        </a>
                        
                        <!-- 회원 정보 + 로그아웃 버튼 -->
                        <div class="h-my-info">
                           <div>
                              <a href="${contextPath}/member/myPage/info" id="nickname"><!-- ${loginMember.memberNickname } --></a>
                              <div>
                              <a href="${contextPath}/member/logout" id="logout-btn">로그아웃</a><a href="#">마이페이지</a>
                              </div>
                           </div>
                        </div>
                        
                     </article>
                     
              </c:otherwise>
           
           </c:choose>
            
            </section>
        </section>

        <nav>
            <ul>
                <li><a href="#">축제정보</a></li>
                <li><a href="#">공지게시판</a></li>
                <li><a href="#">자유게시판</a></li>
                <li><a href="#">축제후기</a></li>
                <li><a href="#">동행자구하기</a></li>
            </ul>
        </nav>
    </header>