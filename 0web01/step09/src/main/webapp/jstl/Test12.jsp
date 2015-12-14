<%-- JSTL(JSP Standard Tag Library) 사용법 --%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- 다른 페이지의 결과를 가져오는 태그 c:import --%>
<c:import url="http://www.google.com" var ="googleMain" scope="page"/>


<%
String contents = (String)pageContext.getAttribute("googleMain");
out.println(contents.substring(0, 100));
%>
--------------------------------------
${googleMain}
--------------------------------------