<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>동행자 구하기</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/findCompanionWriteForm.css">

    <script src="https://kit.fontawesome.com/16679b9adf.js" crossorigin="anonymous"></script>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    
    <c:set var="currentDate" value="<%=new java.util.Date()%>" />

</head>

<body>

    <main>
        
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <form action="write" enctype="multipart/form-data" method="POST" class="board-write"
            onsubmit="return writeValidate()">
        <div id="formInDivs">
            <!-- 제목 -->

            <div id="update">
                <c:if test="${empty detail.boardTitle}">
                    <div>동행자구하기 게시글 작성</div>
                </c:if>

                <c:if test="${!empty detail.boardTitle}">
                    <div>동행자구하기 게시글 수정</div>
                </c:if>
                
            </div>

            <h1 class="board-title">
                <input type="text" name="festivalTitle" placeholder="[ 축제 이름 ]" autocomplete="off" readonly>
                <input type="text" name="boardTitle" placeholder="제목을 입력해주세요." value="${detail.boardTitle}" autocomplete="off">
            </h1>
            <h1><!--시기, 지역, 테마 선택시 select option 최신화되고 그 목록에서 축제선택 -->
                <div class="select-box-wrap">
                    <div class="select-box select-date">
                        <label for="festivalDate" class="labels">날짜</label>
                        <select name="festivalDate" id="festivalDate" title="날짜">
                            <option value="">날짜</option>
                            <option value="01">01월</option>
                            <option value="02">02월</option>
                            <option value="03">03월</option>
                            <option value="04">04월</option>
                            <option value="05">05월</option>
                            <option value="06">06월</option>
                            <option value="07">07월</option>
                            <option value="08">08월</option>
                            <option value="09">09월</option>
                            <option value="10">10월</option>
                            <option value="11">11월</option>
                            <option value="12">12월</option>
                        </select>
                    </div>
            
                    <div class="select-box select-area">
                        <label for="festivalArea" class="labels">지역</label>
                        <select name="festivalArea" id="festivalArea" title="지역">
                            <option value="">지역</option>
                            <option value="서울특별시">서울특별시</option>
                            <option value="경기도">경기도</option>
                            <option value="강원도">강원도</option>
                            <option value="인천">인천</option>
                            <option value="충청북도">충청북도</option>
                            <option value="충청남도">충청남도</option>
                            <option value="대전">대전</option>
                            <option value="경상북도">경상북도</option>
                            <option value="전라북도">전라북도</option>
                            <option value="대구">대구</option>
                            <option value="울산">울산</option>
                            <option value="부산">부산</option>
                            <option value="경상남도">경상남도</option>
                            <option value="광주">광주</option>
                            <option value="전라남도">전라남도</option>
                            <option value="제주도">제주도</option>
                            <option value="세종특별자치시">세종특별자치시</option>
                        </select>
                    </div>
                    <div class="select-box select-cat">
                        <label for="festivalCat" class="labels">카테고리</label>
                        <select name="festivalCat" id="festivalCat" title="카테고리">
                            <option value="">카테고리</option>
                            <option value="가족">가족</option>
                            <option value="연인">연인</option>
                            <option value="꽃">꽃</option>
                            <option value="힐링">힐링</option>
                            <option value="도심">도심</option>
                        </select>
                    </div>
                    <div class="select-box select-fest">
                        <label for="festivalList" id="labels">축제선택</label>
                        <select name="festivalList" id="festivalList" title="축제선택">
                            <option value="">축제선택</option>
                        </select>
                    </div>
                    <div class="flex date-area">
                        <label for="inputDate" id="inputDateLabel">동행일자 :</label>
                        <input type="date" name="inputDate" id="inputDate" min="<fmt:formatDate value="${currentDate}" pattern="yyyy-MM-dd" />">
                    </div>
                    <div class="flex recruit-area">
                        <label for="numberOfPeople" id="peopleLabel">모집인원 :</label>
                        <input type="number" min="1" max="10" value="1" name="numberOfPeople" id="numberOfPeople">
                    </div>
                    <div class="select-box select-rec">
                        <label for="recruit" id="labels">구인상태 :</label>
                        <select name="recruit" id="recruit" title="구인상태">
                            <option value="">구인상태</option>
                            <option value="모집중">모집 중</option>
                            <option value="모집마감">모집 마감</option>
                        </select>
                    </div>
                </div>
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
        <script src="${contextPath}/resources/js/findCompanionWriteForm.js"></script>
</body>

</html>