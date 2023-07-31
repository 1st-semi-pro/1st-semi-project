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

    <link rel="stylesheet" href="${contextPath}/resources/css/reply.css">

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

            <div id="boardCd">${detail.boardCd}</div>

            <!-- 제목 -->
            <div class="board-title">${detail.boardTitle}</div>

            <!-- 상세내용 헤더 -->
            <div class="boardHeader">
                 
                <div id="imgNick">
                    <!-- 프로필 이미지인데 우리 db에는 member에 프로필이미지가 있어서 sql로 갖고옴-->
                    <!-- 우린 마이페이지에서 이미지 설정할 수 있음 -->
                    <div>
                    <c:if test="${empty detail.profileImage}">
                        <img src="${contextPath}/resources/images/id.png"> <!-- 기본값 -->
                    </c:if>

                    <c:if test="${!empty detail.profileImage}">
                        <img src="${contextPath}${detail.profileImage}">
                    </c:if>
                    </div>

                    <div id="nick">${detail.memberNickname}</div>

                </div>

                <div class="boardInfo">
                    <div> 작성일 : ${detail.createDate}</div>
                
                    <!-- 수정일이 존재하는 경우 (수정한 경우) -->
                    <c:if test="${!empty detail.updateDate}">
                        <div>수정일 : ${detail.updateDate}</div>
                    </c:if>
    
                    <div>조회수 : ${detail.readCount}</div>
    
                </div>

            </div>


   

        <!-- 이미지가 있다면 -->

        <div id="imageContext">

        <c:if test="${!empty detail.imageList}">    
                <!-- 썸네일이 있을 경우 변수 생성 -->
                <c:if test="${detail.imageList[0].imageLevel == 0}">
                    <c:set var="thumbnail" value="${detail.imageList[0]}"/>
                    <!-- 기본값 : page scope (if문 안에 있지만 페이지 어디서든 변수 사용 가능함) -->

                </c:if>
                
        </c:if>

        <c:if test="${empty detail.imageList}">
        </c:if>


            <!-- 썸네일 영역 (썸네일이 있을 경우)-->

            <c:if test="${!empty thumbnail}">

                <div class="img-box">
                    <div class="boardImg thumnail">
                        <img src="${contextPath}${thumbnail.imageReName}">
                       <!--  <a href="${contextPath}${thumbnail.imageReName}" download="${thumbnail.imageOriginal}">다운로드</a> -->
                    </div>
                </div>

            </c:if>

            
        
        <!-- 내용 -->
        <div class="board-Content">${detail.boardContent}</div>

        <c:if test="${empty thumbnail}"> <!-- 썸네일 X -->
                <c:set var="start" value="0"/>
            </c:if>

            <c:if test="${!empty thumbnail}"> <!-- 썸네일 O -->
                <c:set var="start" value="1"/>
            </c:if>

            <!-- 업로드 이미지가 있는 경우 -->
            <!-- !empty thumbnail && fn:length(detail.imageList) == 1을 고려 -->
            <c:if test="${fn:length(detail.imageList) > start}">
                
                <!-- 업로드 이미지 영역 -->
                <h5></h5>
                
                <div class="img-box">
                    
                    <c:forEach var = "i" begin="${start}" end="${fn:length(detail.imageList) - 1}"> 
 
                        <div class="boardImg">
                            <img src="${contextPath}${detail.imageList[i].imageReName}">
                           <!--  <a href="${contextPath}${detail.imageList[i].imageReName}" 
                            download="${detail.imageList[i].imageOriginal}"></a>  -->
                        </div>
        
                    </c:forEach>
    
                </div>

            </c:if>

        </div>    
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

        <!-- reply.js에서의 사용을 위함 -->
        <script>
            const contextPath = "${contextPath}";
   
            const boardNo = "${detail.boardNo}"; 

            const loginMemberNo = "${loginMember.memberNo}";
        </script>

    <script src="${contextPath}/resources/js/reply.js"></script>

</body>

</html>