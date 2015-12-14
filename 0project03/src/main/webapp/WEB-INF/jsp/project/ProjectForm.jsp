<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시판-새글</title>
</head>
<body>
  <h1>새 글</h1>
  <form action='add.do' method='post'>
    <table border='1'>
      <tr>
        <th>제목</th>
        <td><input type='text' name='title' placeholder="프로젝트명을 넣으세요."></td>
      </tr>
      <tr>
        <th>시작일</th>
        <td><input type="date" name='startDate' placeholder="프로젝트명 시작일을 넣으세요."></td>
      </tr>
      <tr>
        <th>종료일</th>
        <td><input type='date' name='endDate' placeholder="프로젝트명 종료일을 넣으세요."></td>
      </tr>
      <tr>
        <th>맴버</th>
        <td><input type='text' name='member' placeholder="맴버를 입력하세요."></td>
      </tr>
    </table>
    <p>
      <button type='submit'>등록</button>
    </p>
    
  </form>
  <jsp:include page="/Copyright.jsp"/>
  
</body>
</html>
    