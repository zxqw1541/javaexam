<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>학생 목록</h1>
<p><a href="form.html">새 학생</a></p>
<table border="1">
  <tr>
    <th>이메일</th>
    <th>이름</th>
    <th>전화번호</th>
    <th>cid</th>
  </tr>
  
  <c:forEach var="student" items="${students}">
    <tr>
      <td><img src="../file/s-${(empty student.image) ? "defaultimage.jpg": student.image}">${student.email}</td>
      <td><a href="update.do?email=${student.email}">${student.name}</a></td>
      <td>${student.tel}</td>
      <td>${student.cid}</td>
    </tr>
  </c:forEach>
  
</table>
<jsp:include page="/Copyright.jsp"/> 
</body>
</html>
