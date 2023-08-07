<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>join</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/join.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


</head>

<body style="height:1000px !important;">

    <main style="height:100% !important;">

        <div id = "logoDiv">

            <a href="${contextPath}">
                <img src="${contextPath}/resources/images/logo.png" id="img0"
                            style="width: 200px !important;
                                height: 100px !important;">
            </a>                   

        </div>


        
        <form action="join" method="post" onsubmit="return joinValidate()">

            <div class="height"></div>

            <div id="firstbox">
                <article class = "Articles">
                    <img src="${contextPath}/resources/images/id.png" id="img1">
                    <input type="text" class="inputs" id="inputId" name="inputId" placeholder="아이디를 입력해주세요." autocomplete="off">
                </article>

                <article class = "Articles">
                    <img src="${contextPath}/resources/images/pw1.png" id="img2">
                    <input type="password" class="inputs" id="inputPw" name="inputPw" placeholder="비밀번호를 입력해주세요.">
                </article>

                <article class = "Articles">
                    <img src="${contextPath}/resources/images/pw2.png" id="img3">
                    <input type="password" class="inputs" id="inputPwCheck" name="inputPwCheck" placeholder="비밀번호 확인을 입력해주세요.">
                </article>

                <div id="innerTextSpan1"></div>

            </div>

            <div class="height"></div>

            <div id="secondBox">

                <article id="giveMargin" class = "Articles">
                    <img src="${contextPath}/resources/images/nickname.png" id="img5">
                    <input type="text" class="inputs" id="memberNickname" name="memberNickname" placeholder="닉네임을 입력해주세요." autocomplete="off">
                
                </article>

                <article class = "Articles">
                    <img src="${contextPath}/resources/images/name.png" id="img6">
                    <input type="text" class="inputs" id="memberName" name="memberName" placeholder="이름을 입력해주세요." autocomplete="off">

                </article >

                <article class = "Articles">
                    <img src="${contextPath}/resources/images/birth.png" id="img7">
                    <input type="text" class="inputs" id="memberBirth" name="memberBirth" placeholder="생년월일을 8자리로 입력해주세요.(- 제외)" autocomplete="off">
                
                </article>

                <article class = "Articles">
                    <img src="${contextPath}/resources/images/region.png" id="img8">
                 
                    <div id="selectDiv">
                        <select id="regionSelect" name="regionSelect">
                            <option selected value="default">주 활동지역을 선택해주세요.</option> <!-- 이거 선택안되게 하는법? -->
                            <option value="서울">서울</option>
                            <option value="경기도">경기도</option>
                            <option value="강원도">강원도</option>
                            <option value="충청도">충청도</option>
                            <option value="전라도">전라도</option>
                            <option value="경상도">경상도</option>
                            <option value="제주도">제주도</option>

                        </select>
                    </div>    

                </article>

                <article class = "Articles"> 
                    <img src="${contextPath}/resources/images/phone.png" id="img9">
                    <input type="text" class="inputs" id="memberPhone" name="memberPhone" placeholder="전화번호를 입력해주세요.(- 제외)" autocomplete="off">

                </article>

                <article class = "Articles">
                    <img src="${contextPath}/resources/images/gender.png" id="img10"> 
                    <div id="genderNationality">

                        <div id="gender">
                            <label for="man" class="leftLabel" id="manLabel">
                                <div id = "manDiv">
                                    <input type="radio" name="gender" id="man" class="radios" value="남">
                                    <span name="남">남</span>
                                </div>
                            </label>

                            <label for="woman" class="rightLabel" id="womanLabel">
                                <div id="womanDiv">
                                    <input type="radio" name="gender" id="woman" class="radios" value="여">
                                    <span name="여">여</span>
                                </div>
                            </label>
                        </div>

                        <div id="nationality">
                            <label for="kor" class="leftLabel" id="korLabel">
                                <div id="korDiv">
                                    <input type="radio" name="nation" id="kor" class="radios" value="내국인">
                                    <span>내국인</span>
                                </div>
                            </label>

                            <label for="foreign" class="rightLabel" id="forLabel">
                                <div id="forDiv"> 
                                    <input type="radio" name="nation" id="foreign" class="radios" value="외국인">
                                    <span>외국인</span>
                                </div>
                            </label>
                        </div>

                    </div>

                </article>
                
                <article class = "Articles">
                    <img src="${contextPath}/resources/images/email.png" id="img11">
                    <input type="email" class="inputs" id="inputEmail" name="inputEmail" placeholder="이메일을 입력해주세요." autocomplete="off">
                    <button id="emailBtn" type="button">인증하기</button>
                </article>

                <article class = "Articles" id="">
                    <input type="hidden" class="inputs" id="authenticationInput" placeholder="인증번호를 입력해주세요." class="inputs">
                    <input type="hidden" id="authenticationButton">
                </article>

                <div id="innerTextSpan2" ></div>

            </div>

            <div class="height2"></div>

            <div id="thirdBox">
                <button id="btn">회원가입</button>
            </div>    

            <div class="height2"></div>

        </form>

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

<!--     <script>
        const contextPath = "${contextPath}";
    </script>     -->


	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script src="${contextPath}/resources/js/join.js"></script>
   
</body>
</html>