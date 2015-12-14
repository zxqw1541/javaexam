<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생-상세정보</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>
<jsp:include page="/Header.jsp"/>
<c:if test="${not empty student}">
<h1>학생 상세정보</h1>
<form id="form1" action="update.do" method="post" enctype="multipart/form-data">
<table border="1">
  <tr>
    <th>이메일</th>
    <td><input type="text" name="email" value="${student.email}" readonly></td>
  </tr>
  <tr>
    <th>이름</th>
    <td><input type="text" name="name" value="${student.name}" ></td>
  </tr>
  <tr>
    <th>전화번호</th>
    <td><input type="text" name="tel" value="${student.tel}" ></td>
  </tr>
  <tr>
    <th>클래스명</th>
    <td><input type="text" name="cid" value="${student.cid}" ></td>
  </tr>
  <tr>
    <th>사진</th>
    <td><img width="200" height="300"
      src='../file/${(empty student.image) ? "defaultimage.jpg":student.image}'><br>
    <input type="file" name="oimage">
    <input type="hidden" name="image" value="${student.image}">
    </td>
  </tr>
</table>
<button type="submit" name="update" class='button1'>수정</button>
<a href="delete.do?email=${student.email}" class='button2'">삭제1</a>
</form>
</c:if>
<c:if test="${empty student}">
해당하는 학생정보가 없습니다.
</c:if>

<jsp:include page="/Copyright.jsp"/> 

</body>
</html>