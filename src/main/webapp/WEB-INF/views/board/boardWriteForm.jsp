<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>

    
    
    <link rel="stylesheet" href="${contextPath}/resources/css/boardWriteForm.css">

    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">


    <script src="https://kit.fontawesome.com/16679b9adf.js" crossorigin="anonymous"></script>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">

</head>

<body>

    <main>
        
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <form action="write" enctype="multipart/form-data" method="POST" class="board-write"
            onsubmit="return writeValidate()">
        <div id="formInDivs">
            <!-- 제목 -->

            <div id="update">
                <div>게시글 수정</div>
            </div>

            <h1 class="board-title">
                <input type="text" name="boardTitle" placeholder="제목을 입력해주세요." value="${detail.boardTitle}"
                        autocomplete="off">
            </h1>

            
            <!-- 내용 -->
            <div class="board-content">

                <div id="imageArea">
                    
                    <c:forEach items="${detail.imageList}" var="boardImage">
        
                        <c:choose>
        
                            <c:when test="${boardImage.imageLevel == 0}">
                                <c:set var="img0" value="${contextPath}${boardImage.imageReName}"/>
                            </c:when>
      
                            <c:when test="${boardImage.imageLevel == 1}">
                                <c:set var="img1" value="${contextPath}${boardImage.imageReName}"/>
                            </c:when>
        
                            <c:when test="${boardImage.imageLevel == 2}">
                                <c:set var="img2" value="${contextPath}${boardImage.imageReName}"/>
                            </c:when>
        
                            <c:when test="${boardImage.imageLevel == 3}">
                                <c:set var="img3" value="${contextPath}${boardImage.imageReName}"/>
                            </c:when>
        
                            <c:when test="${boardImage.imageLevel == 4}">
                                <c:set var="img4" value="${contextPath}${boardImage.imageReName}"/>
                            </c:when>
        
                        </c:choose>
        
                    </c:forEach>

                    <!-- 썸네일 -->

                    <div class="boardImg" id="thumbnailDiv" 
                    style="width:60% !important; height:400px !important;">
                        
                        <label for="img0" class="labels" style="height:400px !important;">
                            <img class="preview" src="${img0}"> <!-- 위에 c:set 만약 없다면 안나온다. -->
                            <span></span>
                        </label>
                        <input type="file" class="inputImage" id="img0" name="0" accept="image/*">
                        <span class="imageInfo">썸네일</span>
                        <span class="delete-image">&times;</span>
                        
                    </div>


                <textarea name="boardContent">${detail.boardContent}</textarea>

                <!-- imageList에 존재하는 이미지 레벨을 이용하여 변수 생성 -->

                <!-- 업로드 이미지 -->
                <div class="img-box">
                    <div class="boardImg">
                        <label for="img1" class="labels">
                            <img class="preview" src="${img1}">
                        </label>
                        <input type="file" class="inputImage" id="img1" name="1" accept="image/*">
                        <span class="imageInfo">추가이미지1</span>
                        <span class="delete-image">&times;</span>
                    </div>
    
                    <div class="boardImg">
                        <label for="img2" class="labels">
                            <img class="preview" src="${img2}">
                        </label>
                        <input type="file" class="inputImage" id="img2" name="2" accept="image/*">
                        <span class="imageInfo">추가이미지2</span>
                        <span class="delete-image">&times;</span>
                    </div>
    
                    <div class="boardImg">
                        
                        <label for="img3" class="labels">
                            <img class="preview" src="${img3}">
                        </label>
                        <input type="file" class="inputImage" id="img3" name="3" accept="image/*">
                        <span class="imageInfo">추가이미지3</span>
                        <span class="delete-image">&times;</span>
                    </div>
    
                    <div class="boardImg">
                        
                        <label for="img4" class="labels">
                            <img class="preview" src="${img4}">
                        </label>
                        <input type="file" class="inputImage" id="img4" name="4" accept="image/*">
                        <span class="imageInfo">추가이미지3</span>
                        <span class="delete-image">&times;</span>
                    </div>
    
                    </div>

                </div>
            </div>

            <!-- 버튼 영역 -->
            <div class="board-btn-area">
                <button type="submit" id="writeBtn" class="buttons">등록</button>
                
                <!-- insert 모드 -->
                <c:if test="${param.mode == 'insert'}">

                    <button type="button" id="goToListBtn" class="buttons">목록으로</button>
                
                </c:if>
                
                 <!-- update 모드 -->
                <c:if test="${param.mode == 'update'}">
                   
                    <button type="button" id="goToPreviousPage" class="buttons">수정취소</button>

                </c:if>
            
            </div>

            <!-- 숨겨진 값(hidden) -->
            <!-- 동작 구분 -->
            <input type="hidden" name="mode" value="${param.mode}">

            <!-- 게시판 구분 -->
            <input type="hidden" name="type" value="${param.type}"> <!-- boardNo -->

            <!-- 게시글 번호 -->
            <input type="hidden" name="no" value="${param.no}">

            <!-- 현재 페이지 -->
            <input type="hidden" name="cp" value="${param.cp}">

            <!-- 존재하던 이미지가 제거되었음을 기록하여 전달하는 input -->
            <!-- value에 제거된 이미지의 레벨을 기록 -->
            <!-- DELETE FROM BOARD_IMG
                WHERE BOARD_NO = 1000
                AND IMG_LEVEL = 1
            -->

            <input type="hidden" name="deleteList" id="deleteList" value="">

        </div>

        </form>
    
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

        <script src="${contextPath}/resources/js/board.js"></script>
        <script src="${contextPath}/resources/js/boardWriteForm.js"></script>
</body>

</html>