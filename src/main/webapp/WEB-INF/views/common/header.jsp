<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <header>
        <section class="header">

            <section>
                <a href="${contextPath}"><img src="${contextPath}/resources/images/logo.png" id="home-logo"></a>
            </section>

            <section>
                <article class="search-area">
                    <form action="#" name="search-form">
                        <fieldset>
                            <input type="search" id="search" name="search" size="35" placeholder=" 여행지를 찾아보세요." autocomplete="off">
                            <button type="submit" id="search-btn" class="fa-solid fa-magnifying-glass"></button>
                        </fieldset>
                    </form>
                </article>
            </section>
            <section>로그인</section>
        </section>

        <nav>
            <ul>
                <li><a href="#">축제정보</a></li>
                <li><a href="#">공지게시판</a></li>
                <li><a href="#">자유게시판</a></li>
                <li><a href="#">축제후기</a></li>
                <li><a href="#">동행자구하기</a></li>
            </ul>
        </nav>
    </header>