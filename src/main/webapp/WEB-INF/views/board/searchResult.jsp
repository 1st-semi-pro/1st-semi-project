<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="festivalName" value="${map2.festivalName}"/>
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
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>

    <style>
.sch_result_list{margin:0 0 3px }
.sch_result_list li:first-child{padding-top:11px}
.sch_result_list .tit_txt{font-weight:normal;text-decoration:underline;line-height:25px;}
.sch_result_list .link_dsc_txt{margin-top:6px;line-height:20px;  color: #999;}
.sch_result_list .link_dsc_txt.dsc_sub{margin-top:4px}
.sch_result_list .link_dsc_txt.dsc_sub:after{clear:both;display:block;visibility:hidden;content:""}
.sch_result_list .sub_txt{text-decoration:underline; color: #ccc;   }
.date_time{ display: inline; float:none;margin-left:10px;margin-top:0}
.sch_result_list .date_time:first-child{margin-left:0}
/* .sch_result_list .date_time::before{display:none} */

.integrate_cont.sch_result.result_all{border-bottom:none}



.sch_result_list.img{  display: grid;
  grid-template-columns: 1fr 1fr;}
.integrate_cont.news_result.news_all{border-bottom:none}
.sch_result_list.img li{display: flex; overflow:hidden;padding-top:15px;padding-left: 10px; align-items: center; justify-content: space-around;}
.sch_result_imgbox{float:left;width:152px;height:102px;}
.sch_result_imgbox > a{display:flex;width:150px;height:100px;border:1px #ccc solid;overflow:hidden}
.sch_result_imgbox img{width:150px;min-height:100px}
.sch_result_txtbox{float:left;width:300px; margin-left: 20px;}
.sch_result_txtbox:first-child{width:100%;}
.sch_result_list.img .tit_txt{display:block;font-size: 1.5rem;}
.sch_result_list.img .link_dsc_txt{height:40px;overflow:hidden}
.sch_result_list.img .link_dsc_txt.dsc_sub{height:20px; display: flex;}
.gall_result_more{position:relative;margin-right:12px;color:#999; float: right; border-bottom: 1px solid;}
.gall_result_more:after{content:'';display:inline-block;width:5px;height:9px;margin-left:3px;
background-image:url(https://nstatic.dcinside.com/dc/w/images/sp/sp_img.png);background-position:-110px -58px
}

.fr {
    float: right;
}



    </style>


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
                                                    <a href="festivalDetail?festivalNo=${festival.festivalNo}&type=${param.type}${sURL}" target="_blank" class="tit_txt">${festival.festivalTitle}</a>
                                                    <p class="link_dsc_txt">${festival.festivalContent}</p>
                                                    <p class="link_dsc_txt dsc_sub" ><a href="#" target="_blank" class="sub_txt">${festival.festivalArea}</a><span class="date_time">${festival.festivalDate}</span></p>
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

                <section class="board-list">
                    <table class="list-table">

                            <div class="integrate_cont_head">
                                <h2 style="color: orange; margin-top: 10px; margin-left: 10px;">공지 게시판</h2>
                            </div>

                            <tbody>
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
                                        <tr>
                                            <th>글번호</th>
                                            <th>제목</th>
                                            <th>내용</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                        </tr>
                                        <c:forEach var="board" items="${boardList2}">

                                            <tr>
                                                <td>${board.boardNo}</td>
                                                <td><a href="detail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}">${board.boardTitle}</a></td>
                                                <td><a href="detail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}">${board.boardContent}</a></td>
                                                <td><a href="${contextPath}/member/myPage2?memberNo=${detail.memberNo}">${board.memberNickname}</a></td>
                                                <td>${board.createDate}</td>
                                            </tr>
                                        </c:forEach>
                                        <a href="${contextPath}/board/list?type=2&key=${param.key}&query=${param.query}" class="gall_result_more fr">더보기</a>
                                    </c:otherwise>
                                </c:choose>
                        </tbody>
                    </table>
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
                                    <ul class="sch_result_list">
                                        <c:forEach var="board" items="${boardList3}">
                                            <li>
                                                <a href="detail?no=${board.boardNo}&cp=${pagination.currentPage}&type=${param.type}${sURL}" class="tit_txt">${board.boardTitle}</a>
                                                <p class="link_dsc_txt">${board.boardContent}</p>
                                                <p class="link_dsc_txt dsc_sub"><a href="${contextPath}/member/myPage2?memberNo=${detail.memberNo}" class="sub_txt">${board.memberNickname}</a><span class="date_time">${board.createDate}</span></p>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <a href="${contextPath}/board/list?type=3&key=${param.key}&query=${param.query}" class="gall_result_more fr">더보기</a>
                                </c:otherwise>

                            </c:choose>
                    </tbody>
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
                                                    <p class="link_dsc_txt dsc_sub"><a href="${contextPath}/member/myPage2?memberNo=${detail.memberNo}"class="sub_txt">${board.memberNickname}</a><span class="date_time">${board.createDate}</span></p>
                                                </div>
                                            </li>
                                            
                                        </c:forEach>
                                    </ul>
                                    <!-- 더보기 -->
                                    <a href="${contextPath}/board/list?type=4&key=${param.key}&query=${param.query}" class="gall_result_more fr">더보기</a>
                                   
                                    
                                </c:otherwise>

                            </c:choose>
                    </tbody>
                </section>
            </div>

        </table>

</body>
</html>