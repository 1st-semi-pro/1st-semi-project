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

</head>

<body>

    <main>

        <div id = "logoDiv">
            로고 자리
        </div>


        
        <form>

            <div id="height"></div>

            <div id="firstbox">
                <article class = "firstArticles">
                    <img src="${contextPath}/resources/images/id.png" id="img1">
                    <input type="text" class="inputs" id="inputId" placeholder="아이디를 입력해주세요.">
                </article>

                <article>
                    <img src="${contextPath}/resources/images/password.jpg" id="img2">
                    <input type="password" class="inputs" id="inputPw" placeholder="비밀번호를 입력해주세요.">
                </article>

                <article>
                    <img src="${contextPath}/resources/images/password2.png" id="img3">
                    <input type="password" class="inputs" id="inputPwCheck" placeholder="비밀번호 확인을 입력해주세요.">
                </article>


                <span id="innerTextSpan1"></span>

            </div>

            <div id="height"></div>

            <div id="secondBox">

                <article id="giveMargin">
                    <img src="${contextPath}/resources/images/id.png" id="img5">
                    <input type="text" class="inputs" id="memberNickname" placeholder="닉네임을 입력해주세요.">
                
                </article>

                <article>
                    <img src="${contextPath}/resources/images/id.png" id="img6">
                    <input type="text" class="inputs" id="memberName" placeholder="이름을 입력해주세요.">

                </article>

                <article>
                    <img src="${contextPath}/resources/images/id.png" id="img7">
                    <input type="text" class="inputs" id="memberBirth" placeholder="생년월일을 입력해주세요.(- 제외)">
                
                </article>

                <article>
                    <img src="${contextPath}/resources/images/id.png" id="img8">
                 
                    <div id="selectDiv">
                        <select>
                            <option selected>주 활동지역을 선택해주세요.</option> <!-- 이거 선택안되게 하는법? -->
                            <option value="1">서울</option>
                            <option value="2">경기</option>
                            <option value="3">강원</option>
                            <option value="4">제주</option>
                        </select>
                    </div>    

                </article>

                <article> 
                    <img src="${contextPath}/resources/images/id.png" id="img10">
                    <input type="text" class="inputs" id="memberBirth" placeholder="전화번호를 입력해주세요.(- 제외)">

                </article>
                <article>
                    <img src="${contextPath}/resources/images/id.png" id="img11"> 
                    <div id="genderNationality">

                        <div id="gender">
                            <label for="man" class="leftLabel">
                                <div>
                                    <input type="radio" name="gender" id="man" class="radios">
                                    <span>남</span>
                                </div>
                            </label>

                            <label for="woman" class="rightLabel">
                                <div>
                                    <input type="radio" name="gender" id="woman" class="radios" >
                                    <span>여</span>
                                </div>
                            </label>
                        </div>

                        <div id="nationality">
                            <label for="kor" class="leftLabel">
                                <div>
                                    <input type="radio" name="nation" id="kor" class="radios">
                                    <span>내국인</span>
                                </div>
                            </label>

                            <label for="foreign" class="rightLabel">
                                <div>
                                    <input type="radio" name="nation" id="foreign" class="radios">
                                    <span>외국인</span>
                                </div>
                            </label>
                        </div>

                    </div>

                </article>
                
                <article>
                    <img src="${contextPath}/resources/images/id.png" id="img4">
                    <input type="email" class="inputs" id="inputEmail" placeholder="이메일을 입력해주세요.">
                    <button id="emailBtn">인증하기</button>
                </article>


                <span id="innerTextSpan2"></span>

            </div>

            <div id="thirdBox">
                <input type="radio">
                <span><p>[필수]</p>인증 약관 전체 동의</span>
                <img src="v.jfif" id="agreeImg">
            </div>

            <div id="agreeClickBox">
                약관동의 클릭하면 나올 박스
            </div>


            <div id="forthBox">
                <button id="btn">회원가입</button>
            </div>    

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


    <script src="/js/join.js"></script>
   
</body>
</html>