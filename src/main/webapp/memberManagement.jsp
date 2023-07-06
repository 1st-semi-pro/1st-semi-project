<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 관리 페이지</title>

    <link rel="stylesheet" href="resources/css/memberManagement.css">
    <script src="https://kit.fontawesome.com/16679b9adf.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">


</head>
<body>
    
    <div class="container">
        <header>
            <section>
                <a href="#"><img src="logo.jpg" id="home-logo"></a>
            </section>
            <nav>
                <ul>
                    <li>축제정보</li>
                    <li>공지게시판</li>
                    <li>자유게시판</li>
                    <li>축제후기</li>
                    <li>동행자구하기</li>
                </ul>
            </nav>
            <section>
                <article>
                <input type="search" size="35" placeholder=" 여행지를 찾아보세요." autocomplete="off">
                <i class="fa-solid fa-magnifying-glass"></i>
                </article>
            </section>
        </header>
        
        <div class="content">
            <div>일반회원관리</div>
            <div>사용자수</div>
            <div>
				<select name="state">
					<option value="1" selected>상태(전체)</option>
					<option value="2">회원</option>
					<option value="3">탈퇴회원</option>
				</select>
				
				<select name="categoty">
					<option value="1" selected>아이디</option>
					<option value="2">이름</option>
					<option value="3">이메일</option>
					<option value="3">전화번호</option>
					<option value="3">회원가입일</option>
					<option value="3">탈퇴여부</option>
				</select>
				
                <input type="search" size="35" placeholder=" 검색어를 입력하세요." autocomplete="off">
                <button>검색</button>
                <button>탈퇴</button>
                
			</div>
            <div class="member_list_wrap">
            <div class="member_list">
                <div class="top">
                    <div class="num">NO.</div>
                    <div class="check"><input type="checkbox"></div>
                    <div class="memberId">아이디</div>
                    <div class="memberName">이름</div>
                    <div class="memberEmail">이메일</div>
                    <div class="phoneNum">전화번호</div>
                    <div class="enrollDt">회원가입일</div>
                    <div class="secession">탈퇴여부</div>
                </div>
                <div>
                    <div class="num">1</div>
                    <div class="check"><input type="checkbox"></div>
                    <div class="memberId">user01</div>
                    <div class="memberName">유저일</div>
                    <div class="memberEmail">user01@gmail.com</div>
                    <div class="phoneNum">010-3270-2918</div>
                    <div class="enrollDt">2023.07.06</div>
                    <div class="secession">N</div>
                </div>
                <div>
                    <div class="num">2</div>
                    <div class="check"><input type="checkbox"></div>
                    <div class="memberId">user01</div>
                    <div class="memberName">유저일</div>
                    <div class="memberEmail">user01@gmail.com</div>
                    <div class="phoneNum">010-3270-2918</div>
                    <div class="enrollDt">2023.07.06</div>
                    <div class="secession">N</div>
                </div>
                <div>
                    <div class="num">3</div>
                    <div class="check"><input type="checkbox"></div>
                    <div class="memberId">user01</div>
                    <div class="memberName">유저일</div>
                    <div class="memberEmail">user01@gmail.com</div>
                    <div class="phoneNum">010-3270-2918</div>
                    <div class="enrollDt">2023.07.06</div>
                    <div class="secession">N</div>
                </div>
                <div>
                    <div class="num">4</div>
                    <div class="check"><input type="checkbox"></div>
                    <div class="memberId">user01</div>
                    <div class="memberName">유저일</div>
                    <div class="memberEmail">user01@gmail.com</div>
                    <div class="phoneNum">010-3270-2918</div>
                    <div class="enrollDt">2023.07.06</div>
                    <div class="secession">N</div>
                </div>
                <div>
                    <div class="num">5</div>
                    <div class="check"><input type="checkbox"></div>
                    <div class="memberId">user01</div>
                    <div class="memberName">유저일</div>
                    <div class="memberEmail">user01@gmail.com</div>
                    <div class="phoneNum">010-3270-2918</div>
                    <div class="enrollDt">2023.07.06</div>
                    <div class="secession">N</div>
                </div>
                <div>
                    <div class="num">6</div>
                    <div class="check"><input type="checkbox"></div>
                    <div class="memberId">user01</div>
                    <div class="memberName">유저일</div>
                    <div class="memberEmail">user01@gmail.com</div>
                    <div class="phoneNum">010-3270-2918</div>
                    <div class="enrollDt">2023.07.06</div>
                    <div class="secession">N</div>
                </div>
                <div>
                    <div class="num">7</div>
                    <div class="check"><input type="checkbox"></div>
                    <div class="memberId">user01</div>
                    <div class="memberName">유저일</div>
                    <div class="memberEmail">user01@gmail.com</div>
                    <div class="phoneNum">010-3270-2918</div>
                    <div class="enrollDt">2023.07.06</div>
                    <div class="secession">N</div>
                </div>
                <div>
                    <div class="num">8</div>
                    <div class="check"><input type="checkbox"></div>
                    <div class="memberId">user01</div>
                    <div class="memberName">유저일</div>
                    <div class="memberEmail">user01@gmail.com</div>
                    <div class="phoneNum">010-3270-2918</div>
                    <div class="enrollDt">2023.07.06</div>
                    <div class="secession">N</div>
                </div>
                <div>
                    <div class="num">9</div>
                    <div class="check"><input type="checkbox"></div>
                    <div class="memberId">user01</div>
                    <div class="memberName">유저일</div>
                    <div class="memberEmail">user01@gmail.com</div>
                    <div class="phoneNum">010-3270-2918</div>
                    <div class="enrollDt">2023.07.06</div>
                    <div class="secession">N</div>
                </div>
                <div>
                    <div class="num">10</div>
                    <div class="check"><input type="checkbox"></div>
                    <div class="memberId">user01</div>
                    <div class="memberName">유저일</div>
                    <div class="memberEmail">user01@gmail.com</div>
                    <div class="phoneNum">010-3270-2918</div>
                    <div class="enrollDt">2023.07.06</div>
                    <div class="secession">N</div>
                </div>
                <div class="board_page">
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

        <div class="footer">

        </div>

    </div>
    
</body>
</html>