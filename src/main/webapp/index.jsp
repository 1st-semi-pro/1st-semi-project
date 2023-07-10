<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인페이지</title>

    <link rel="stylesheet" href="resources/css/index.css">
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
            <div > <!-- 배너 + 로그인 칸 -->
                <div class="banner">
                    <div ><</div>
                    <div></div>
                    <div>></div>
                </div>
                <div class="login">
                	<div>
					<button type="button" id="loginBtn">로그인</button>
                	</div>
                	
                	
						<article id="signup-find-area">
                            <a href="#">내 정보찾기</a>
                            <span>/</span> 
                            <a href="#">회원가입</a>
                        </article>
                	
                	
                </div>
            </div>
            <div class="content-1"> <!-- 한반도 + 게시판 -->
				<div class="korea"> <!-- 한반도 -->
					<img src="resources/images/korea.png">
				</div>
				<div> <!-- 게시판 모음1 -->
					<div class="board1">
						<div class="board-name1">공지 게시판</div>
						<div class="board-content1"></div>
					</div>
					<div class="board2">
						<div class="board-name2">축제 후기</div>
						<div class="board-content2"></div>
					</div>
				</div>
				<div> <!-- 게시판 모음2 -->
					<div class="board3">
						<div class="board-name3">자유 게시판</div>
						<div class="board-content3"></div>
					</div>
					<div class="board4">
						<div class="board-name4">동행자 구하기</div>
						<div class="board-content4"></div>
					</div>
				</div>

            </div>
        </div>

        <div class="footer">

        </div>

    </div>
    
</body>
</html>