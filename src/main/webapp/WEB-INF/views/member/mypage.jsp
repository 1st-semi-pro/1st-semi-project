<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${contextPath}/resources/css/mypage.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    <title>마이페이지</title>
</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section id="content">
        
            <div class="title">마이페이지</div>
            <section>
                <section id="info-box">
                    <section id="profile-img-box">
                        <article id="profile-img"></article>
                        <input type="file" id="img-file" name="img-file" accept="images/*">
                    </section>
                    <section>
                        <article id="intro">
                            <textarea name="" id="" cols="80" rows="10"></textarea>
                        </article>
                        <article id="history">
                            <textarea name="" id="" cols="80" rows="10"></textarea>
                            <table>
                                <tr>
                                    <td>
                                        <img src="${contextPath}/resources/images/good.png" alt="칭찬 횟수" class="mypage-icon">
                                        <span class="mypage-span" id="good-span"></span>
                                    </td>
                                    <td>
                                        <img src="${contextPath}/resources/images/report.png" alt="신고 횟수" class="mypage-icon">
                                        <span class="mypage-span" id="report-span"></span>
                                    </td>
                                    <td></td>
                                    <td><button type="button" class="mypage-btn" id="update-btn">내 정보 수정</button></td>
                                    <td><button type="submit" class="mypage-btn" id="save-btn">저장</button></td>
                                </tr>-.
                            </table>
                        </article>
                    </section>
                </section>
                <section>
                    <article class="sub-title">관심목록</article>
                </section>
                <section id="festival-box">
                    <article>
                        <h1>축제이름</h1>
                        <a href="#"><img src="${contextPath}/resources/images/con1.jpg" alt="축제사진"></a>
                    </article>
                    <article>
                        <h1>축제이름</h1>
                        <a href="#"><img src="${contextPath}/resources/images/con2.jpg" alt="축제사진"></a>
                    </article>
                    <article>
                        <h1>축제이름</h1>
                        <a href="#"><img src="${contextPath}/resources/images/con3.jpg" alt="축제사진"></a>
                    </article>
                    <article>
                        <h1>축제이름</h1>
                        <a href="#"><img src="${contextPath}/resources/images/con4.jpg" alt="축제사진"></a>
                    </article>
                </section>
            </section>
        </section>
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
</body>
</html>
