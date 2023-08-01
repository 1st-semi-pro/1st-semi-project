<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pagination" value="${map.pagination}" />
<c:set var="mList" value="${map.mList}" />


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 관리 페이지</title>
	
	<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/index.css">
	<link rel="stylesheet" href="${contextPath}/resources/css/memberManagement.css">
	<script src="https://kit.fontawesome.com/16679b9adf.js"
		crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link
		href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap"
		rel="stylesheet">


</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<c:if test="${!empty param.ctg}">
            <c:set var="sURL" value="&ctg=${param.ctg}&search=${param.search}"/>
    </c:if>
	
	<div class="container">

		<div class="content">
			<div class="title"><h2><a href="memberList">일반회원관리</a></h2></div>
			<div class="memberCount">검색된 사용자수 : ${map.memberCount}</div>
			<div class="divide1">
				<div class="divide2">

					<form action="memberList" method="get" id="memberSearch" onsubmit="return searchValidate()">
						<select name="ctg" id="ctg" style="font-size: 15px;">
							<option value="id" selected>아이디</option>
							<option value="ni">닉네임</option>
							<option value="em">이메일</option>
						</select>
						<input type="search" id="mem-search" name="search" size="30" placeholder="검색" autocomplete="off">
						<button type="submit" id="mem-search-btn" class="fa-solid fa-magnifying-glass"></button>
					</form>

				</div>
				<div class="btn-area">
					<button id="selectMemberDelete" name="secession" onclick="return goToDeleteMember()">탈퇴</button>

				</div>
			</div>
			
			<div class="member-list">

				<form name="memberform" action="memberList">
					<table border="1" class="table1">
						<tr class="s1">
							<th class="no">NO.</th>
							<td class="ck"><input type="checkbox" id="all"></td>
							<th class="id">아이디</th>
							<th class="nm">닉네임</th>
							<th class="em">이메일</th>
							<th class="pn">전화번호</th>
							<th class="dt">회원가입일</th>
							<th>신고 횟수</th>
						</tr>

						<c:choose>
							<c:when test="${empty mList}">
								<tr>
									<th colspan="8">회원이 존재하지 않습니다.</th>
								</tr>
							</c:when>

							<c:otherwise>
								<c:forEach var="member" items="${mList}">
									<tr class="s2">
										<td>${member.memberNo}</td>
										<td><input type="checkbox" class="check" name="checkRow" value="${member.memberId}"></td>
										<td><a href="#">${member.memberId}</a></td>
										<td>${member.memberNickname}</td>
										<td>${member.memberEmail}</td>
										<td>${member.memberPhone}</td>
										<td>${member.enrollDate}</td>
										<td>${member.secessionFl}</td>
									</tr>
									
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
					<!-- <input type="hidden" name="deleteList" id="deleteList" value=""> -->
				</form>
			</div>
			
			<div class="pagination-area">

				<!-- 페이지네이션 a태그에 사용될 공통 주소를 저장한 변수 선언 -->
				<c:set var="url" value="memberList?cp="/>


				<ul class="pagination">
					<li><a href="${url}1${sURL}">&lt;&lt;</a></li> <!-- 리스트 넘기기, <<로 처음화면 가게하기? -->

					<!-- 이전 목록 마지막 번호로 이동 -->
					<li><a href="${url}${pagination.prevPage}${sURL}">&lt;</a></li> 

					<!-- li*10>a{$} -->

					

					<!-- 범위가 정해진 일반 for문 사용 -->
					<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
						<c:choose>
							<c:when test="${ i == pagination.currentPage}">
								<li><a class="current">${i}</a></li> 
							</c:when>

							<c:otherwise>
								<li><a href="${url}${i}${sURL}">${i}</a></li>
							</c:otherwise>
						</c:choose>

					</c:forEach>


					<li><a href="${url}${pagination.nextPage}${sURL}">&gt;</a></li> 
					<li><a href="${url}${pagination.maxPage}${sURL}">&gt;&gt;</a></li> 
				</ul>
			</div>
		</div>
		
		<div class="footer"></div>
	</div>

		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

		<script src="${contextPath}/resources/js/memberManagement.js"></script>
</body>
</html>