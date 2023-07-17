<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="resources/css/mypage.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    <title>마이페이지</title>
</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <div class="title">마이페이지</div>
        <section id="info-box">
            <section>
                <section id="profile">
                    <img src="resources/images/faadfgasefawcs.jpg" alt="프로필사진">
                    <input type="file">
                </section>
                <section>
                    <article id="intro">
                        <textarea name="" id="" cols="120" rows="10"></textarea>
                    </article>
                    <article id="history">
                        <textarea name="" id="" cols="120" rows="10"></textarea>
                        <table>
                            <tr>
                                <td>칭찬횟수</td>
                                <td>신고횟수</td>
                                <td><button type="button">회원정보 수정</button></td>
                                <td><button type="submit">저장</button></td>
                            </tr>
                        </table>
                    </article>
                </section>
            </section>
            <section>
                <article>관심목록</article>
            </section>
            <section>
                <article>
                    <h1>축제이름</h1>
                    <a href="#"><img src="resources/images/faadfgasefawcs.jpg" alt="축제사진"></a>
                </article>
                <article>
                    <h1>축제이름</h1>
                    <a href="#"><img src="resources/images/faadfgasefawcs.jpg" alt="축제사진"></a>
                </article>
                <article>
                    <h1>축제이름</h1>
                    <a href="#"><img src="resources/images/faadfgasefawcs.jpg" alt="축제사진"></a>
                </article>
                <article>
                    <h1>축제이름</h1>
                    <a href="#"><img src="resources/images/faadfgasefawcs.jpg" alt="축제사진"></a>
                </article>
            </section>
        </section>
    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
