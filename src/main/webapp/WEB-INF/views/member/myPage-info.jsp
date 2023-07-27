<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 문자열 관련 함수(메소드) 제공 JSTL (EL형식으로 작성) --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보수정</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/changeInformation.css">
</head>
<body>
  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div class="container">
      <h1>회원정보 수정</h1>
      <form id="info" method="post" onsubmit="return infoValidate()" name="myPage-form">
        <table>
          <tr>
            <td class="center-align">아이디</td>
            <td id="id"><div>${loginMember.memberId}</div></td>
          </tr>
          <tr>
            <td class="center-align">이름</td>
            <td id="name"><div>${loginMember.memberName}</div></td>
          </tr>
          <tr>
            <td class="center-align">성별</td>
            <td id="gender"><div>${loginMember.memberGender}</div></td>
          </tr>
          <tr>
            <td class="center-align">국가</td>
            <td id="country"><div>${loginMember.memberNationality}</div></td>
          </tr>
          <tr>
            <td class="center-align">사는 지역 변경</td>
            <td>
              <select name="memberRegion" id="memberRegion">
                <option value="서울">서울</option>
                <option value="경기">경기</option>
                <option value="인천">인천</option>
                <option value="강원도">강원도</option>
                <option value="충청도">충청도</option>
                <option value="전라도">전라도</option>
                <option value="경상도">경상도</option>
              </select>
            </td>
          </tr>
          <tr>
            <td class="center-align">이메일 변경</td>
            <td>
              <input type="email" id="memberEmail" name="memberEmail" value="${loginMember.memberEmail }" >
              <button type="button" onclick="sendEmailVerification()">이메일 인증</button>
            </td>
          </tr>
          <tr>
            <td class="center-align">휴대폰 번호 변경</td>
            <td>
              <input type="tel" name="memberPhone" id="memberPhone" value="${loginMember.memberPhone }">
              <button type="button">휴대폰 번호 변경</button>
            </td>
          </tr>
          <tr>
            <td class="center-align">비밀번호 변경</td>
            <td>
              <input type="password" name="currentPw" id="currentPw" value="${loginMember.memberPw }" > <br>
              <input type="password" name="newPw" id="newPw1" placeholder="새 비밀번호" > <br>
              <input type="password" name="newPwConfirm" id="newPw2" placeholder="새 비밀번호 확인" ><br>
              <button type="button">비밀번호 변경</button>
            </td>
          </tr>
          <tr>
            <td class="center-align">닉네임 변경</td>
            <td>
              <input type="text" name="memberNickname" id="memberNickname" value="${loginMember.memberNickname }" >
              <button type="button">중복확인</button>
              <div id="memberNickname">과연ㅋ</div>
            </td> 
          </tr>
        </table>
        <div class="button-container">
          <tr><td>
          <button id="outBtn">나가기</button>
          <button type="submit" id="info-update-btn">저장하기</button></td>
        </tr>
        </div>
      </form>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
      
      <script src="${contextPath}/resources/js/Change-information.js"></script>
  </body>
</html>


