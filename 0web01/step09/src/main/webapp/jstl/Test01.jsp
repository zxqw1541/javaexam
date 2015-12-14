<%-- JSTL(JSP Standard Tag Library) 사용법 --%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
    
<%-- JSTL 태그 사용하기 --%>
<%-- 1) JSTL 라이브러리 임포트 
    <%@ taglib uri="라이브러리 네임스페이스" prefix="별명"%>
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%-- 1) JSTL에서 제공하는 라이브러리
=> Core: http://java.sun.com/jsp/jstl/core (c)
   - 변수 다루기, 조건문/반목문, URL 다루기, 기타
=> XML: http://java.sun.com/jsp/jstl/xml (x)
   - XML 다루기
=> Internationalization: http://java.sun.com/jsp/jstl/fmt (fmt)
   - 국제화 지원, 메시지 형식 다루기, 숫자와 날짜 데이터의 형식 다루기
=> SQL: http://java.sun.com/jsp/jstl/sql (sql)
   - SQL 다루기
=> Functions: http://java.sun.com/jsp/jstl/functions (fn)
   - 컬렉션 및 문자열 다루기
--%>

<%
pageContext.setAttribute("names", new String[]{"홍길동", "임꺽정", "유관순"});
%>

<c:forEach var="name" items="${names}">
  => ${name}
</c:forEach>
----------------------------------------------
<c:if test="${empty names}">
  names가 없어요!
</c:if>

<c:if test="${not empty names}">
  names가 있어요!
</c:if>
----------------------------------------------
<c:choose>
  <c:when test="${empty names2}">
    names가 없네요..
  </c:when>
  <c:otherwise>
    names가 있네요..
  </c:otherwise>
</c:choose>







