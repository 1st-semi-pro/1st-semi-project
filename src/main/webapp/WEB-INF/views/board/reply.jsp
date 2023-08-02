<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="reply-area">

    <!-- 댓글 목록 -->

    <div class="replyListArea">

        <ul id="replyList">
        
            <c:forEach var="reply" items="${ReplyList}">
        
            <!--  -->
            <li class="replyRow">

                <!--  -->
                <div class="replyWriter">
                    
                    <c:if test="${empty reply.profileImage}">
                        <!-- 프로필 이미지가 없을 경우 -->
                        <a href="${contextPath}/member/myPage2?memberNo=${reply.memberNo}" class="as">
                            <img src="${contextPath}/resources/images/id.png"> <!-- 임시 -->
                        </a>
                    </c:if>

                    <c:if test="${!empty reply.profileImage}">
                        <!-- 프로필 이미지가 있을 경우 -->
                        <a href="${contextPath}/member/myPage2?memberNo=${reply.memberNo}" class="as">
                            <img src="${contextPath}${reply.profileImage}">
                        </a>
                    </c:if>

                    <div class="nickDate">${reply.memberNickname}</div>
                    
                    <div class="nickDate">(${reply.createDate})</div>

                </div>
                
                <div class="replyContent">${reply.replyContent}</div>
                
                <c:if test="${loginMember.memberNo == reply.memberNo}">
                        
                    <div class="replyBtnDiv">
                        <button onclick="showUpdateReply(${reply.replyNo}, this)">수정</button>
                        <button onclick="deleteReply(${reply.replyNo})">삭제</button> <!-- 오류아님 -->
                    </div>

                </c:if>
                
            </li>
        </c:forEach>

        </ul>

    </div>

    <!-- 댓글 작성 부분 -->

    <div class="replyWriteArea">

  

        <c:if test="${!empty loginMember}">

        <textarea id="replyContent"></textarea>

        <button id="addReply">댓글<br>등록</button>

        </c:if>

    </div>

</div>