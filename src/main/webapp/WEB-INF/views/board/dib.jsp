<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 로그인 안했으면 버튼 자체를 못보게 하기 -->
<c:if test="${!empty loginMember.memberNo}">
<button id="btn1" class="btns"></button>
</c:if>