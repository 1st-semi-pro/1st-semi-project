<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="companionList" value="${map.companionList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>동행자구하기</title>
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
    
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/findCompanion.css">
   
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
        <c:choose>

            <c:when test="${empty sessionScope.loginMember}">
                <article id="empty-login">
                    <h1>로그인회원전용 페이지입니다. 로그인후 이용해주세요!</h1>
                </article>
             </c:when>

            <c:otherwise>

                <section class="main-title"> 동행자구하기</section>
                <section id="content-box">
                    <section id="pagebox">
                        <jsp:include page="/WEB-INF/views/board/CompanionList.jsp"/>

                        <section id="page-area">
                            <c:set var="url" value="companion?type=${param.type}&cp="/>
                                <ul class="pagination">
                                    <li><a href="${url}1${sURL}">&lt;&lt;</a></li>
                                    <li><a href="${url}${pagination.prevPage}${sURL}">&lt;</a></li>
                                    
                                    <!-- 범위가 정해진 일반 for문 사용 -->
                                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                                        <c:choose>
                                            <c:when test="${i == pagination.currentPage}">
                                                <li><a class="current">${i}</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li><a href="${url}${i}${sURL}">${i}</a></li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <li><a href="${url}${pagination.nextPage}${sURL}">&gt;</a></li>
                                    <li><a href="${url}${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
                                </ul>
                            </section>
                        </section>
                                    <a class="w-a" href="${contextPath}/board/findCompanionWrite?mode=insert&type=5&cp="><button id="w-button" type="button">글쓰기</button></a>
                    </section>
            </c:otherwise>
        </c:choose>

       
      
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </main>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <script>

     
        const contextPath = "${contextPath}";

        const companionList = "${companionList}"; 

        const loginMemberNo = "${loginMember.memberNo}";

        const type = "${param.type}"

        const cp = "${param.cp}"

    </script>
    
    
    
    <script src="${contextPath}/resources/js/findCompanion.js"></script>
    

</body>
</html>