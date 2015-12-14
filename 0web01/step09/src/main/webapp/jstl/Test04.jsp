 <%-- JSTL(JSP Standard Tag Library) 사용법 --%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- c:set을 이용하여 객체의 프로퍼티 값 설정하기
 --%>

<jsp:useBean id="board" class="vo.Board" scope="page"/>
no: ${board.no},
title: ${board.title},
view: ${board.views},
---------------------------------
<c:set target="${board}" property="no">100</c:set>
<c:set target="${board}" property="title">오호라... 제목이네..</c:set>
<c:set target="${board}" property="views">16</c:set>
no: ${board.no},
title: ${board.title},
view: ${board.views},
---------------------------------