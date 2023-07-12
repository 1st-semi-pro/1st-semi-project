<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL은 사용되는 JSP 파일마다 작성되어야 한다 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>프로젝트 푸터</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
</head>

<body>

		<footer class="footer">
			<ul class="quick_menu_list">
				<li>
					<a href="#"><img src="${contextPath}/resources/images/footer/footer_menu01.png" alt="우리가최고조">
						<p>우리가 최고조</p>
					</a>
				</li>
				<li>
					<a href="#"><img src="${contextPath}/resources/images/footer/footer_menu02.png" alt="우리가최고조">
						<p>우리가 최고조</p>
					</a>
				</li>
				<li>
					<a href="#"><img src="${contextPath}/resources/images/footer/footer_menu03.png" alt="우리가최고조">
						<p>우리가 최고조</p>
					</a>
				</li>
				<li>
					<a href="#"><img src="${contextPath}/resources/images/footer/footer_menu04.png" alt="우리가최고조">
						<p>우리가 최고조</p>
					</a>
				</li>
			</ul>
			<div class="footer_wrap">
				<div class="container">
					<ul class="footer_sns_icon">
						<li><a href="#"><img src="${contextPath}/resources/images/footer/footer_sns_icon_01.png" alt=""></a></li>
						<li><a href="#"><img src="${contextPath}/resources/images/footer/footer_sns_icon_03.png" alt=""></a></li>
						<li><a href="#"><img src="${contextPath}/resources/images/footer/footer_sns_icon_05.png" alt=""></a></li>
						<li><a href="#"><img src="${contextPath}/resources/images/footer/footer_sns_icon_07.png" alt=""></a></li>
						<li><a href="#"><img src="${contextPath}/resources/images/footer/footer_sns_icon_09.png" alt=""></a></li>
						<li><a href="#"><img src="${contextPath}/resources/images/footer/footer_sns_icon_11.png" alt=""></a></li>
						<li><a href="#"><img src="${contextPath}/resources/images/footer/footer_sns_icon_13.png" alt=""></a></li>
					</ul>

					<ul class="footer_bottom_list">
						<li><a href="#">회사소개</a></li>
						<li><a href="#">이용약관</a></li>
						<li><a href="#">개인정보처리방침</a></li>
						<li><a href="#">축제정보 제공사실 열람</a></li>
						<li><a href="#">ALL Festival</a></li>
						<li><a href="#">찾아오는길</a></li>
					</ul>

					<div class="copyright">
						<h4>&#40;주&#41;축제축제</h4>
						<h5>대표이사 문광민. 사업자등록번호 220-81-18745<br>
							저작권신고 제2023-서울강남-00481호 사업자정보확인</h5>
						<p>Copyright &copy; D-Festival Corp. All Rights Reserved.</p>
					</div>
				</div>
			</div>
			
		</footer>
		<c:if test="${ !empty sessionScope.message }">

		<script>
			alert("${message}");
		</script>

		<c:remove var="message" scope="session" />

	</c:if>
	

</body>

</html>
