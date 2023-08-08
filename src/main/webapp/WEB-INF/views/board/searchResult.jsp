<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="festivalName" value="${map2.festivalName}"/>
<c:set var="boardName2" value="${map1.boardName2}"/>
<c:set var="boardName3" value="${map1.boardName3}"/>
<c:set var="boardName4" value="${map1.boardName4}"/>
<c:set var="boardName5" value="${map3.boardName5}"/>
<c:set var="festivalList" value="${map2.festivalList}"/>
<c:set var="boardList2" value="${map1.boardList2}"/>
<c:set var="boardList3" value="${map1.boardList3}"/>
<c:set var="boardList4" value="${map1.boardList4}"/>
<c:set var="companionList" value="${map3.companionList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>검색결과</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/searchResult.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>


</head>

<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    
    <c:if test="${!empty param.key}">
        <c:set var="sURL" value="&key=${param.key}&query=${param.query}"/>
    </c:if>

 <!--    <c:if test="${!empty param.key}">
                <h3>검색어 : ${param.query}</h3>
    </c:if> -->

    <div>

  
            <div class="list-wrapper">
                <section class="board-list1">
                    <table class="list-table1">

                            <div class="integrate_cont_head">
                                <h2 style="color: orange; margin-top: 10px; margin-left: 10px;">축제 정보</h2>
                            </div>

                            <tbody>
                                <c:choose>
                                    <c:when test="${empty festivalList}">
                                        <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                        <tr>
                                            <th colspan="5">게시글이 존재하지않습니다.</th>
                                        </tr>
                                        <tr><th><br></th></tr>
                                    </c:when>

                                    <c:otherwise>
                                    <!-- 게시글 목록 조회 결과가 비어있지 않다면 -->
                                    <!-- 향상된 for문 처럼사용 -->
                                    <ul class="sch_result_list img">
                                        <c:forEach var="festival" items="${festivalList}">
                                            <li> <!-- 이미지 -->
                                                <div class="sch_result_imgbox"><a href="festivalDetail?festivalNo=${festival.festivalNo}&type=${param.type}${sURL}" >
                                                    <img src="${contextPath}/resources/images/festival_infomation/${festival.festivalNo}.png" alt=""></a>
                                                </div>			
                                                <div class="sch_result_txtbox"> <!-- 축제글 -->
                                                    <a href="festivalDetail?festivalNo=${festival.festivalNo}&type=${param.type}${sURL}" class="tit_txt">${festival.festivalTitle}</a>
                                                    <p class="link_dsc_txt">${festival.festivalContent}</p>
                                                    <p class="link_dsc_txt dsc_sub" ><a class="sub_txt">${festival.festivalArea}</a><span class="date_time">${festival.festivalDate}</span></p>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <!-- 더보기 -->
                                    <a href="${contextPath}/board/festivalInfo?type=1&pop=0&festivalDate=${param.festivalDate}&festivalArea=${param.festivalArea}&festivalCat=${param.festivalCat}&query=${param.query}" class="gall_result_more fr">더보기</a>
                                            
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                    </table>
                </section>

             
                <section class="board-list1">
                    <table class="list-table1">

                            <div class="integrate_cont_head">
                                <h2 style="color: orange; margin-top: 10px; margin-left: 10px;">축제 후기 게시판</h2>
                            </div>
                    <tbody>
                            <c:choose>
                                <c:when test="${empty boardList2}">
                                    <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                    <tr>
                                        <th colspan="5">게시글이 존재하지않습니다.</th>
                                    </tr>
                                    <tr><th><br></th></tr>
                                </c:when>

                                <c:otherwise>
                                    <!-- 게시글 목록 조회 결과가 비어있지 않다면 -->

                                    <!-- 향상된 for문 처럼사용 -->
                                    <ul class="sch_result_list img">
                                        <c:forEach var="board" items="${boardList2}">
                                            <li>
                                                <div class="sch_result_txtbox"> <!-- 게시글 -->
                                                    <a href="detail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}" class="tit_txt">${board.boardTitle}</a>
                                                    <p class="link_dsc_txt">${board.boardContent}</p>
                                                    <p class="link_dsc_txt dsc_sub"><a href="${contextPath}/member/myPage2?memberNo=${board.memberNo}"class="sub_txt">${board.memberNickname}</a><span class="date_time">${board.createDate}</span></p>
                                                </div>
                                            </li>
                                            
                                        </c:forEach>
                                    </ul>
                                    <!-- 더보기 -->
                                    <a href="${contextPath}/board/list?type=2&key=${param.key}&query=${param.query}" class="gall_result_more fr">더보기</a>
                                   
                                    
                                </c:otherwise>

                            </c:choose>
                    </tbody>
                </table>    
                </section>
               
                <section class="board-list1">
                    <table class="list-table1">

                            <div class="integrate_cont_head">
                                <h2 style="color: orange; margin-top: 10px; margin-left: 10px;">자유 게시판</h2>
                            </div>
                    <tbody>
                            <c:choose>
                                <c:when test="${empty boardList3}">
                                    <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                    <tr>
                                        <th colspan="5">게시글이 존재하지않습니다.</th>
                                    </tr>
                                    <tr><th><br></th></tr>
                                </c:when>

                                <c:otherwise>
                                    <!-- 게시글 목록 조회 결과가 비어있지 않다면 -->

                                    <!-- 향상된 for문 처럼사용 -->
                                    <ul class="sch_result_list img">
                                        <c:forEach var="board" items="${boardList3}">
                                            <li>
                                                <div class="sch_result_txtbox"> <!-- 게시글 -->
                                                    <a href="detail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}" class="tit_txt">${board.boardTitle}</a>
                                                    <p class="link_dsc_txt">${board.boardContent}</p>
                                                    <p class="link_dsc_txt dsc_sub"><a href="${contextPath}/member/myPage2?memberNo=${board.memberNo}"class="sub_txt">${board.memberNickname}</a><span class="date_time">${board.createDate}</span></p>
                                                </div>
                                            </li>
                                            
                                        </c:forEach>
                                    </ul>
                                    <!-- 더보기 -->
                                    <a href="${contextPath}/board/list?type=3&key=${param.key}&query=${param.query}" class="gall_result_more fr">더보기</a>
                                   
                                    
                                </c:otherwise>

                            </c:choose>
                    </tbody>
                </table>    
                </section>

                <section class="board-list1">
                    <table class="list-table1">

                            <div class="integrate_cont_head">
                                <h2 style="color: orange; margin-top: 10px; margin-left: 10px;">축제 후기 게시판</h2>
                            </div>
                    <tbody>
                            <c:choose>
                                <c:when test="${empty boardList4}">
                                    <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                    <tr>
                                        <th colspan="5">게시글이 존재하지않습니다.</th>
                                    </tr>
                                    <tr><th><br></th></tr>
                                </c:when>

                                <c:otherwise>
                                    <!-- 게시글 목록 조회 결과가 비어있지 않다면 -->

                                    <!-- 향상된 for문 처럼사용 -->
                                    <ul class="sch_result_list img">
                                        <c:forEach var="board" items="${boardList4}">
                                            <li>
                                                <div class="sch_result_txtbox"> <!-- 게시글 -->
                                                    <a href="detail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}" class="tit_txt">${board.boardTitle}</a>
                                                    <p class="link_dsc_txt">${board.boardContent}</p>
                                                    <p class="link_dsc_txt dsc_sub"><a href="${contextPath}/member/myPage2?memberNo=${board.memberNo}"class="sub_txt">${board.memberNickname}</a><span class="date_time">${board.createDate}</span></p>
                                                </div>
                                            </li>
                                            
                                        </c:forEach>
                                    </ul>
                                    <!-- 더보기 -->
                                    <a href="${contextPath}/board/list?type=4&key=${param.key}&query=${param.query}" class="gall_result_more fr">더보기</a>
                                   
                                    
                                </c:otherwise>

                            </c:choose>
                    </tbody>
                </table>    
                </section>

                <section class="board-list1">
                    <table class="list-table1">

                            <div class="integrate_cont_head">
                                <h2 style="color: orange; margin-top: 10px; margin-left: 10px;">동행자 구하기</h2>
                            </div>

                            <tbody>
                              
                                <c:choose>

                                    <c:when  test="${empty sessionScope.loginMember}">
                                        <tr>
                                            <th colspan="5">회원 전용 페이지 입니다.<br> 로그인 후 이용 가능합니다!</th>
                                        </tr>
                                        <tr><th><br></th></tr>
                                    </c:when>

                                    <c:otherwise>
                                        <c:choose>
                                        <c:when test="${empty companionList}">
                                            <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                            <tr>
                                                <th colspan="5">게시글이 존재하지않습니다.</th>
                                            </tr>
                                            <tr><th><br></th></tr>
                                        </c:when>

                                        <c:otherwise>
                                            <!-- 게시글 목록 조회 결과가 비어있지 않다면 -->
                                            <!-- 향상된 for문 처럼사용 -->
                                            <ul class="sch_result_list img">
                                                <c:forEach var="companion" items="${companionList}">
                                                    <li> <!-- 이미지 -->
                                                        <div class="sch_result_imgbox"><a href="festivalDetail?festivalNo=${companion.festivalNo}&type=${param.type}${sURL}" >
                                                            <img src="${contextPath}/resources/images/festival_infomation/${companion.festivalNo}.png" alt=""></a>
                                                        </div>			
                                                        <div class="sch_result_txtbox"> <!-- 게시글 -->
                                                            <a href="detail?no=${companion.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}" class="tit_txt">${companion.boardTitle}</a>
                                                            <p class="link_dsc_txt">${companion.boardContent}</p>
                                                            <p class="link_dsc_txt dsc_sub"><a href="${contextPath}/member/myPage2?memberNo=${companion.memberNo}"class="sub_txt">${companion.memberNickname}</a><span class="date_time">${companion.createDate}</span></p>
                                                        </div>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                            <!-- 더보기 -->
                                            <a href="${contextPath}/board/companion?type=5&key=${param.key}&query=${param.query}" class="gall_result_more fr">더보기</a>        
                                        </c:otherwise>
                                    </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                    </table>
                </section>
            </div>


</body>
</html>