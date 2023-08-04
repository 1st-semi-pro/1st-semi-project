<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="boardName" value="${map2.festivalName}"/>
<c:set var="boardName2" value="${map1.boardName2}"/>
<c:set var="boardName3" value="${map1.boardName3}"/>
<c:set var="boardName4" value="${map1.boardName4}"/>
<c:set var="festivalList" value="${map2.festivalList}"/>
<c:set var="boardList2" value="${map1.boardList2}"/>
<c:set var="boardList3" value="${map1.boardList3}"/>
<c:set var="boardList4" value="${map1.boardList4}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>검색결과</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/searchResult.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
</head>

<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    
    <c:if test="${!empty param.key}">
        <c:set var="sURL" value="&key=${param.key}&query=${param.query}"/>
    </c:if>

    <c:if test="${!empty param.key}">
                <h3>검색어 : ${param.query}</h3>
    </c:if>

    <div>

            <div class="list-wrapper">
                <section class="board-list">
                    <h3 class="board-name">축제 메인</h3>
                    <tbody class="list-table">
                            
                            <c:choose>
                                <c:when test="${empty festivalList}">
                                    <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                    <tr>
                                        <th colspan="5">게시글이 존재하지않습니다.</th>
                                    </tr>
                                </c:when>

                                <c:otherwise>
                                    <!-- 게시글 목록 조회 결과가 비어있지 않다면 -->

                                    <!-- 향상된 for문 처럼사용 -->
                                    <c:forEach var="festival" items="${festivalList}">
                                        <tr>
                                            <td>
                                                <a href="festivalDetail?festivalNo=${festival.festivalNo}&type=${param.type}${sURL}">${festival.festivalTitle}</a>
                                            </td>
                                      
                                            <td>${festival.festivalContent}</td>
                                        </tr>
                                    </c:forEach>
                                    <div class="btn-area">
                                        <button id="moreBtn" onclick="location.href='${contextPath}/board/festivalInfo?type=1&pop=0&festivalDate=${param.festivalDate}&festivalArea=${param.festivalArea}&festivalCat=${param.festivalCat}&query=${param.query}'">더보기</button>
                                    </div>                     
                                    
                                </c:otherwise>

                            </c:choose>
                    </tbody>
                </section>
                <section class="board-list">
                    <h3 class="board-name">공지사항 게시판</h3>
                    <tbody class="list-table">
                            
                            <c:choose>
                                <c:when test="${empty boardList2}">
                                    <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                    <tr>
                                        <th colspan="5">게시글이 존재하지않습니다.</th>
                                    </tr>
                                </c:when>

                                <c:otherwise>
                                    <!-- 게시글 목록 조회 결과가 비어있지 않다면 -->

                                    <!-- 향상된 for문 처럼사용 -->
                                    <c:forEach var="board" items="${boardList2}">
                                        <tr>
                                            <td>
                                                <a href="detail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}">${board.boardTitle}</a>
                                            </td>
                                            <td>${board.boardContent}</td>
                                        </tr>
                                    </c:forEach>
                                    <div class="btn-area">
                                        <button id="moreBtn" onclick="location.href='${contextPath}/board/list?type=2&key=${param.key}&query=${param.query}'">더보기</button>
                                    </div>
                                    
                                </c:otherwise>

                            </c:choose>
                    </tbody>
                </section>
                <section class="board-list">
                    <h3 class="board-name">자유 게시판</h3>
                    <tbody class="list-table">
                            
                            <c:choose>
                                <c:when test="${empty boardList3}">
                                    <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                    <tr>
                                        <th colspan="5">게시글이 존재하지않습니다.</th>
                                    </tr>
                                </c:when>

                                <c:otherwise>
                                    <!-- 게시글 목록 조회 결과가 비어있지 않다면 -->

                                    <!-- 향상된 for문 처럼사용 -->
                                    <c:forEach var="board" items="${boardList3}">
                                        <tr>
                                            <td>
                                                <a href="detail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}">${board.boardTitle}</a>
                                            </td>
                                            <td>${board.boardContent}</td>
                                        </tr>

                                    </c:forEach>
                                    
                                </c:otherwise>

                            </c:choose>
                    </tbody>
                </section>
                <section class="board-list">
                    <h3 class="board-name">축제후기 게시판</h3>
                    <tbody class="list-table">
                            
                            <c:choose>
                                <c:when test="${empty boardList4}">
                                    <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                    <tr>
                                        <th colspan="5">게시글이 존재하지않습니다.</th>
                                    </tr>
                                </c:when>

                                <c:otherwise>
                                    <!-- 게시글 목록 조회 결과가 비어있지 않다면 -->

                                    <!-- 향상된 for문 처럼사용 -->
                                    <c:forEach var="board" items="${boardList4}">
                                        <tr>
                                            <td>
                                                <a href="detail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}">${board.boardTitle}</a>
                                            </td>
                                            <td>${board.boardContent}</td>
                                        </tr>

                                    </c:forEach>
                                    
                                </c:otherwise>

                            </c:choose>
                    </tbody>
                </section>
            </div>

        </table>




    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="${contextPath}/resources/js/board.js"></script>
    
</body>
</html>