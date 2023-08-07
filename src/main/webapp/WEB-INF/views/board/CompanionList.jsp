<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="companionList" value="${map.companionList}"/>
       
<section id="main-content">
    <c:forEach var="companionList" items="${companionList}">
        <article id="main-content-box" class="main-content-box">
            <div id="ft-content" class="ft-content">
                <div class="ft-img">
                    <img src="${contextPath}/resources/images/festival_infomation/${companionList.festivalNo}.png" alt="">
                </div>
                <div class="ft-text">
                    <h1>${companionList.festivalTitle}</h1><span class="s1">${companionList.festivalArea}</span><span class="margin s2">|</span><span class="s3">${companionList.festivalDate}</span>
                </div>
                <div class="my-img">
                    <img src="${contextPath}/resources/images/festival_infomation/181.gif">
                    <div class="my-text"><span>안녕하세요 저는 ESFJ이고 혈액형은 B형 거주지역은 서울입니다. <br>좋은추억만들어봐요 ^~^</span>
                    <button type="button">채팅하기</button>
                    </div>
                </div>

                <c:if test="${sessionScope.loginMember.memberNo == companionList.memberNo}">
                    <div id="update-box">
                        <button type="insertbutton" class="update">게시글수정</button>
                        <button id="deleteBtn" class="update" onclick="deleteReply(${companionList.boardNo},'${companionList.festivalTitle}')" >게시글삭제</button>
                        
                        
                    </div>
                 </c:if>
            </div>
        </article>
    </c:forEach>
</section>