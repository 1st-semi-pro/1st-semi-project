<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="reply-area">

    <!-- 댓글 목록 -->

    <div class="replyListArea">

        <ul id="replyList">
        
            <c:forEach var="reply" items="${rList}">
        
            <!--  -->
            <li class="replyRow">

                <!--  -->
                <div class="replyWriter">
                    
                    <c:if test="${empty reply.profileImage}">
                        <!-- 프로필 이미지가 없을 경우 -->
                        <img src="${contextPath}/resources/images/user.png">
                    </c:if>

                    <c:if test="${!empty reply.profileImage}">
                        <!-- 프로필 이미지가 있을 경우 -->
                        <img src="${contextPath}${reply.profileImage}">
                    </c:if>

                    <div>${reply.memberNickname}</div>
                    
                    <div class="reply-date">(${reply.createDate})</div>

                </div>
                
                <div class="reply-content">${reply.replyContent}</div>
                
                <c:if test="${loginMember.memberNo == reply.memberNo}">
                    
                    <div class="replyBtn">
                        <button onclick="showUpdateReply(${reply.replyNo}, this)">수정</button>
                        <button onclick="deleteReply(${reply.replyNo})">삭제</button> <!-- 오류아님 -->
                    </div>

                </c:if>
                
            </li>
        </c:forEach>

        </ul>

    </div>

    <!-- 댓글 작성 부분 -->

    <div class="reply-write-area">

        <textarea id="replyContent"></textarea>

        <button id="addReply">
            댓글<br>
            등록

        </button>

    </div>

</div>