<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">

    <link rel="stylesheet" href="${contextPath}/resources/css/boardDetail.css">


    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">


    <script src="https://kit.fontawesome.com/16679b9adf.js" crossorigin="anonymous"></script>

</head>

<body>

    <main>
        
        <!-- 헤더 -->
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <!-- 게시글 상세내용 -->
        <div class="boardDetail">

            <!-- 제목 -->
            <div class="board-title">${detail.boardTitle} - ${detail.boardCd}

            </div>

            <!-- 상세내용 헤더 -->
            <div class="boardHeader">
                
                <!-- 프로필 이미지인데 우리 db에는 member에 프로필이미지가 있어서 sql로 갖고옴-->
                <!-- 우린 마이페이지에서 이미지 설정할 수 있음 -->
                <c:if test="${empty detail.profileImage}">
                    <img src="${contextPath}/resources/images/id.png"> <!-- 기본값 -->
                </c:if>

                <c:if test="${!empty detail.profileImage}">
                    <img src="${contextPath}${detail.profileImage}">
                </c:if>

                <span>${detail.memberNickname}</span>

            </div>

            <div class="board-info">
                <div> 작성일 : ${detail.createDate}</div>
            
                <!-- 수정일이 존재하는 경우 (수정한 경우) -->
                <c:if test="${!empty detail.updateDate}">
                    <div>수정일 : ${detail.updateDate}</div>
                </c:if>

                <div>조회수 : ${detail.readCount}</div>

            </div>

   

        <!-- 이미지가 있다면 -->

        
        
        <!-- 내용 -->
        <div class="board-Content">${detail.boardContent}</div>

        <!-- 버튼 -->
        <div class="boardBtn">

            <c:if test="${loginMember.memberNo == detail.memberNo}">  <!-- loginMember는 sessionscope -->

            <!-- 현재 위치 : detail?no=500&cp=15&type=2 -->
            <!-- 글 작성 직후 페이지 : detail?no=500&type=2 -> cp가 주소에 아예 없음 -->

            <!-- cp가 없을 경우 -->
            <c:if test="${empty param.cp}">
                <c:set var="cp" value="1"/> <!-- 그냥 변수 -->
            </c:if>

            <!-- 파라미터에 cp가 있을 경우  -->
            <c:if test="${!empty param.cp}">
                <c:set var="cp" value="${param.cp}"/> 
            </c:if>

            <button id="updateBtn" onclick="location.href='write?mode=update&type=${param.type}&cp=${cp}&no=${param.no}'">수정</button>
                                            <!-- 현재 위치 : detail?no=500&cp=15&type=2 이런식 -->  <!-- ${detail.boardNo} 도 가능 -->
            
            <button id="deleteBtn">삭제</button>

        </c:if>

        <!-- onclick="history.back()"; 뒤로가기
             history.go(숫자) : 양수(앞으로가기), 음수(뒤로가기)
        -->

        <button id="goToListBtn">목록으로</button>

    </div>

 </div>

        <!-- 댓글 -->
        <jsp:include page="/WEB-INF/views/board/reply.jsp"/>


        <!-- 푸터 -->
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

        <!-- 여기부터 jQuery 사용가능 -->
        <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
      
        <script src="${contextPath}/resources/js/board.js"></script>

</body>

</html>