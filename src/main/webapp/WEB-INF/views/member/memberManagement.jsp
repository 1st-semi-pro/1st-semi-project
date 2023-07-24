<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
	<div class="container">
		

		<div class="content">
			<div>일반회원관리</div>
			<div>사용자수</div>
			
			<div class="member-list">
				<table border="1" class="table1">
					<tr class="s1">
						<th class="no">NO.</th>
						<td class="ck"><input type="checkbox" id="all"></td>
						<th class="id">아이디</th>
						<th class="nm">이름</th>
						<th class="em">이메일</th>
						<th class="pn">전화번호</th>
						<th class="dt">회원가입일</th>
						<th>탈퇴여부</th>
					</tr>
					<tr class="s2">
						<td>1</td>
						<td><input type="checkbox" name="check"></td>
						<td><a href="#">user01</a></td>
						<td>유저일</td>
						<td>user01@gmail.com</td>
						<td>010-3270-2918</td>
						<td>2023.07.06</td>
						<td>N</td>
					</tr>
					<tr class="s2">
						<td>1</td>
						<td><input type="checkbox" name="check"></td>
						<td><a href="#">user01</a></td>
						<td>유저일</td>
						<td>user01@gmail.com</td>
						<td>010-3270-2918</td>
						<td>2023.07.06</td>
						<td>N</td>
					</tr>
					<tr class="s2">
						<td>1</td>
						<td><input type="checkbox" name="check"></td>
						<td><a href="#">user01</a></td>
						<td>유저일</td>
						<td>user01@gmail.com</td>
						<td>010-3270-2918</td>
						<td>2023.07.06</td>
						<td>N</td>
					</tr>
					<tr class="s2">
						<td>1</td>
						<td><input type="checkbox" name="check"></td>
						<td><a href="#">user01</a></td>
						<td>유저일</td>
						<td>user01@gmail.com</td>
						<td>010-3270-2918</td>
						<td>2023.07.06</td>
						<td>N</td>
					</tr>
					<tr class="s2">
						<td>1</td>
						<td><input type="checkbox" name="check"></td>
						<td><a href="#">user01</a></td>
						<td>유저일</td>
						<td>user01@gmail.com</td>
						<td>010-3270-2918</td>
						<td>2023.07.06</td>
						<td>N</td>
					</tr>
					<tr class="s2">
						<td>1</td>
						<td><input type="checkbox" name="check"></td>
						<td><a href="#">user01</a></td>
						<td>유저일</td>
						<td>user01@gmail.com</td>
						<td>010-3270-2918</td>
						<td>2023.07.06</td>
						<td>N</td>
					</tr>
					<tr class="s2">
						<td>1</td>
						<td><input type="checkbox" name="check"></td>
						<td><a href="#">user01</a></td>
						<td>유저일</td>
						<td>user01@gmail.com</td>
						<td>010-3270-2918</td>
						<td>2023.07.06</td>
						<td>N</td>
					</tr>
					<tr class="s2">
						<td>1</td>
						<td><input type="checkbox" name="check"></td>
						<td><a href="#">user01</a></td>
						<td>유저일</td>
						<td>user01@gmail.com</td>
						<td>010-3270-2918</td>
						<td>2023.07.06</td>
						<td>N</td>
					</tr>
					<tr class="s2">
						<td>1</td>
						<td><input type="checkbox" name="check"></td>
						<td><a href="#">user01</a></td>
						<td>유저일</td>
						<td>user01@gmail.com</td>
						<td>010-3270-2918</td>
						<td>2023.07.06</td>
						<td>N</td>
					</tr>
					<tr class="s2">
						<td>1</td>
						<td><input type="checkbox" name="check"></td>
						<td><a href="#">user01</a></td>
						<td>유저일</td>
						<td>user01@gmail.com</td>
						<td>010-3270-2918</td>
						<td>2023.07.06</td>
						<td>N</td>
					</tr>
						
							

							


						</table>
						<div class="board-page">
							<a href="#" class="bt first"><<</a> 
							<a href="#" class="bt prev"><</a>
							<a href="#" class="num on">1</a> 
							<a href="#" class="num">2</a> 
							<a href="#" class="num">3</a> 
							<a href="#" class="num">4</a> 
							<a href="#" class="num">5</a>
							<a href="#" class="bt next">></a> 
							<a href="#" class="bt last">>></a>
						</div>
					</div>
				</div>

			</div>

			<div class="footer"></div>

		</div>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

		<script src="${contextPath}/resources/js/memberManagement.js"></script>
</body>
</html>