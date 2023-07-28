<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="boardName" value="${map.boardName}"/>
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="boardList" value="${map.boardList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${boardName}</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/boardList.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

       <!--  <nav>
            <ul>
                <li><a href="${contextPath}/board/list?type=1">공지사항</a></li>
                <li><a href="${contextPath}/board/list?type=2">자유 게시판</a></li>
                <li><a href="${contextPath}/board/list?type=3">축제후기 게시판</a></li>
                <li><a href="${contextPath}/board/list?type=4">동행자 구하기</a></li>
                <li><a href="#">1:1문의</a></li>
            </ul>
        </nav> -->
        <section class="board-list">
            <h1 class="board-name">${boardName}</h1>

            <div class="list-wrapper">
                <table class="list-table">
                    <thead>
                        <tr>
                            <th>글번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                    </thead>

                    <tbody>
                            
                            <c:choose>
                                <c:when test="${empty boardList}">
                                    <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                    <tr>
                                        <th colspan="5">게시글이 존재하지않습니다.</th>
                                    </tr>
                                </c:when>

                                <c:otherwise>
                                    <!-- 게시글 목록 조회 결과가 비어있지 않다면 -->
                                    
                                    <!-- 향상된 for문 처럼사용 -->
                                    <c:forEach var="board" items="${boardList}">
                                        <tr>
                                            <td>${board.boardNo}</td>
                                            <td>
                                                <a href="detail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}">${board.boardTitle}</a>
                                            </td>
                                            <td>${board.memberNickname}</td>
                                            <td>${board.createDate}</td>
                                            <td>${board.readCount}</td>
                                        </tr>

                                    </c:forEach>
                                </c:otherwise>

                            </c:choose>
                    </tbody>
                </table>
            </div>

            <div class="btn-area">
                <button id="insertBtn">글쓰기</button>
            </div>
            
            <div class="pagination-area">

                <!-- 페이지네이션 a태그에 사용될 공통 주소를 저장한 변수 선언 -->
                <c:set var="url" value="list?type=${param.type}&cp="/>

                <ul class="pagination">
                    <li><a href="${url}1">&lt;&lt;</a></li>
                    <li><a href="${url}${pagination.prevPage}">&lt;</a></li>
            
                    <!-- 범위가 정해진 일반 for문 사용 -->
                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">

                        <c:choose>
                            <c:when test="${i == pagination.currentPage}">
                                <li><a class="current">${i}</a></li>
                            </c:when>

                            <c:otherwise>
                                <li><a href="${url}${i}">${i}</a></li>
                            </c:otherwise>

                        </c:choose>

                    </c:forEach>

                    <!-- 다음 목록 시작 번호로 이동 -->
                    <li><a href="${url}${pagination.nextPage}">&gt;</a></li>

                    <!-- 끝 페이지로 이동  -->
                    <li><a href="${url}${pagination.maxPage}">&gt;&gt;</a></li>
                </ul>
            </div>

           <!--  <form action="#" method="get" id="boardSearch">

                <select name="key">
                    <option value="t">제목</option>
                    <option value="c">내용</option>
                    <option value="tc">제목+내용</option>
                    <option value="w">작성자</option>
                </select>

                <input type="text" name="query" placeholder="검색어를 입력해주세요.">

                <button>검색</button>
            </form> -->


        </section>

    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html> 