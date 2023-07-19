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



</head>

<body>



	<section id="imgSection">

		<a href="${contextPath}"> <img
			src="${contextPath}/resources/images/foreign.jpg" id="img1">
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
						id="inputId" name="inputId">
				</section>


				<section class="content1" id="sec2">
					<img src="${contextPath}/resources/images/password.jpg" id="img3">
					<input type="password" size="40" maxlength="10" placeholder="비밀번호"
						id="inputPw" name="inputPw">
				</section>
				
				<section class="content1" id="sec2">
					<img src="${contextPath}/resources/images/password.jpg" id="img3">
					<input type="file" size="40" maxlength="10" placeholder="파일테스트"
						id="inputFile" name="inputFile">
				</section>

				<section class="content1" id="sel1">

					<div id="widthdiv">
						<input type="radio" id="idSave">
					</div>

					<input type="text" size="50" placeholder="로그인 상태 유지">
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



	<script src="${contextPath}/resources/js/login.js"> </script>


	<c:if test="${ !empty sessionScope.message }">

		<script>
			alert("${message}");
		</script>

		<c:remove var="message" scope="session" />

	</c:if>



</body>
</html>