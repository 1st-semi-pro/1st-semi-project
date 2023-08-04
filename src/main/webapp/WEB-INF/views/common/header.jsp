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
                            <input type="search" id="h-search" name="search" size="35" placeholder=" 여행지를 찾아보세요." autocomplete="off">
                            <button type="submit" id="h-search-btn" class="fa-solid fa-magnifying-glass-plus"></button>
                        </fieldset>
                    </form>
                </article>
                <article class="search-area">
                    
                    <form action="${contextPath}/board/search" name="key" value="tc" id="search-key"  onsubmit="return searchValidate()">
                        <select type="hidden" name="key" id="key" >
                            <option value="tc">제목+내용</option>
                        </select>
                        <fieldset>
                            <!-- <input type="search" id="h-search" name="search" size="35" placeholder=" 여행지를 찾아보세요." autocomplete="off"> -->
                            <input type="text"  name="query" id="h-search" placeholder="검색어를 입력해주세요." autocomplete="off">
                            <button type="submit" id="h-search-btn" class="fa-solid fa-magnifying-glass"></button>
                        </fieldset>
                    </form>
                </article>
            </section>
            <section>
            
            <c:choose>
           
              <c:when test="${empty sessionScope.loginMember }">
           
					<div class="h-login">
						<div><a href="${contextPath}/member/login"><i class="fa-solid fa-user-large"></i></a></div>

                        <c:if test="${icon != Id}">
                        <div><a href="${contextPath}/member/findId"><i class="fa-solid fa-id-card"></i><i class="fa-solid fa-magnifying-glass" id="search"></i></a></div>
                        </c:if>
                        
                        <c:if test="${icon != Pw}">
                        <div><a href="${contextPath}/member/findPw"><i class="fa-solid fa-unlock-keyhole"></i><i class="fa-solid fa-magnifying-glass"></i></a></div>
                        </c:if>
                        <div><a href="${contextPath}/member/agree"><div class="background"></div></a></div>
					</div>

              </c:when>
              
              <c:otherwise>
                <article class="h-login-area">
                    
                        <!-- 회원 프로필 이미지 -->
                    <div class="profile-box">
                    <c:if test="${empty loginMember.memberProfileImage}"> <!-- 프로필 이미지 없는 경우-->
                        <img src="${contextPath}/resources/images/id.png" id="member-profile">
                    </c:if>
                    <c:if test="${!empty loginMember.memberProfileImage}">  <!-- 프로필 이미지 있는 경우-->
                        <img src="${contextPath}${loginMember.memberProfileImage}" id="profile-images">
                    </c:if>
                    </div>
                        <!-- 회원 정보 + 로그아웃 버튼 -->
                    <div class="h-my-info">
                        <a href="${contextPath}/member/logout" id="logout-btn">로그아웃</a><span>/</span><a href="${contextPath}/member/myPage?memberNo=${loginMember.memberNo}">마이페이지</a>
                        <c:if test="${loginMember.memberNo == 2}">
                            <span>/</span><a href="${contextPath}/board/memberList">회원관리</a>
                        </c:if>
                    </div>
                        
                </article>
                     
              </c:otherwise>
           
           </c:choose>
            
            </section>
        </section>

        <nav>
            <ul>
                <li><a href="${contextPath}/board/festivalInfo?type=1&pop=0">축제정보</a></li>
                <li><a href="${contextPath}/board/list?type=2">공지게시판</a></li>
                <li><a href="${contextPath}/board/list?type=3">자유게시판</a></li>
                <li><a href="${contextPath}/board/list?type=4">축제후기</a></li>
                <li><a href="${contextPath}/board/companion?type=5">동행자구하기</a></li>
            </ul>
        </nav>
    </header>
    
    