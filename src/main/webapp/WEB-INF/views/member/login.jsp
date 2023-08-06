<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login</title>

<link rel="stylesheet" href="${contextPath}/resources/css/login.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap"
	rel="stylesheet">

	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<body>



	<section id="imgSection">

		<a href="${contextPath}"> 
			<img src="${contextPath}/resources/images/logo.png" id="img1">
		</a>

	</section>




	<main>

		<section class="content">

			<sectionmargin></sectionmargin>

			<form action="${contextPath}/member/login" method="post"
				onsubmit="return loginValidate()">

				<section class="content1" id="sec1">
					<img src="${contextPath}/resources/images/id.png" id="img2">
					<input type="text" size="40" maxlength="10" placeholder="아이디"
						id="inputId" name="inputId" value="${ cookie.idSave.value }">
				</section>


				<section class="content1" id="sec2">
					<img src="${contextPath}/resources/images/password.jpg" id="img3">
					<input type="password" size="40" maxlength="10" placeholder="비밀번호"
						id="inputPw" name="inputPw">
				</section>

				<section class="content1" id="sel1">

					<c:if test="${!empty cookie.idSave.value}">
						<c:set var="chk" value="checked"></c:set>
					</c:if>

					<div id="widthdiv">
						<input type="checkbox" id="idSave" ${chk} name="idSave">
					</div>

					<input type="text" size="50" placeholder="아이디 저장">
				</section>


				<section class="content1">

					<button id="btn1">로그인</button>

				</section>

			</form>

			<section class="content1" id="sel2">

				<div class="find">
					<a href="${contextPath}/member/findId">아이디 찾기</a>
				</div>

				<span>|</span>

				<div class="find">
					<a href="${contextPath}/member/findPw">비밀번호 찾기</a>
				</div>

				<span>|</span>


				<div class="find">
					<a href="${contextPath}/member/agree">회원가입</a>
				</div>

			</section>


		</section>


		<div id="heightdiv"></div>

		<footer>

			<section class="find1">

				<a> 이용약관 | 개인정보 처리 방침 | 책임의 한계와 법적고지 | 회원정보 고객센터 </a>

			</section>

			<section class="find1">

				<section>

					<a>Copyright &copy; 2023 OTSUMO CO., LTD. ALL rights reserved<span>|</span></a>

				</section>

			</section>
		</footer>

	</main>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

	<script src="${contextPath}/resources/js/login.js"> </script>


	<c:if test="${ !empty sessionScope.message }">

		<script>

				alert("${message}");

		</script>

		<c:remove var="message" scope="session" />

	</c:if>



</body>
</html>