<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보수정</title>

    <link rel="stylesheet" href="resource/css/changeInformation.css">
</head>
<body>
  <div class="container">
    <h1>회원정보 수정</h1>
    <form id="memberForm">
      <table>
        <tr>
          <td class="center-align">아이디</td>
          <td><input type="text" id="username" disabled></td>
        </tr>
        <tr>
          <td class="center-align">이름</td>
          <td><input type="text" id="name" disabled></td>
        </tr>
        <tr>
          <td class="center-align">성별</td>
          <td><input type="text" id="gender" disabled></td>
        </tr>
        <tr>
          <td class="center-align">국가</td>
          <td><input type="text" id="country" disabled></td>
        </tr>
        <tr>
          <td class="center-align">사는 지역 변경</td>
          <td>
            <select id="region">
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
            <input type="email" id="email" required>
            <button type="button" onclick="sendEmailVerification()">이메일 인증</button>
          </td>
        </tr>
        <tr>
          <td class="center-align">휴대폰 번호 변경</td>
          <td>
            <input type="tel" id="phoneNumber" required>
            <button type="button" onclick="sendPhoneNumberVerification()">휴대폰 번호 변경</button>
          </td>
        </tr>
        <tr>
          <td class="center-align">비밀번호 변경</td>
          <td>
            <input type="password" id="currentPassword" placeholder="현재 비밀번호" required> <br>
            <input type="password" id="newPassword" placeholder="새 비밀번호" required> <br>
            <input type="password" id="confirmNewPassword" placeholder="새 비밀번호 확인" required><br>
            <button type="button" onclick="changePassword()">비밀번호 변경</button>
          </td>
        </tr>
        <tr>
          <td class="center-align">닉네임 변경</td>
          <td>
            <input type="text" id="nickname" required>
            <button type="button" onclick="checkNicknameAvailability()">중복확인</button>
          </td>
        </tr>
      </table>
      <div class="button-container">
        <tr><td>
        <button type="button" onclick="cancel()">나가기</button>
        <button type="button" onclick="save()">저장하기</button></td>
      </tr>
      </div>
    </form>
  </div>
    
    <script src="Change-information.js"></script>
</body>
</html>


