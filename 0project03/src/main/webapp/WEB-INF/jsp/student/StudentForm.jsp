<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생-새글</title>
</head>
<body>
  <h1>새 학생</h1>
  <form action='add.do' method='post' enctype="multipart/form-data">
    <input type="file" name="image1" value="사진등록"><br>
    <table border='1'>
      <tr>
        <th>이름</th>
        <td><input type='text' name='name' placeholder="이름을 넣으세요."></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input type="email" name='email' placeholder="이메일을 입력하세요"></td>
      </tr>
      <tr>
        <th>전화번호</th>
        <td><input type='text' name='tel' placeholder="전화번호를 넣으세요."></td>
      </tr>
      <tr>
        <th>cid</th>
        <td><input type='text' name='cid' placeholder="cid를 넣으세요."></td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td><input type="password" name='pwd' placeholder="비밀번호를 입력하세요"></td>
      </tr>
    </table>
    <p>
      <button type='submit'>등록</button>
    </p>
    
    <jsp:include page="/Copyright.jsp"/>
  
</body>
</html>
