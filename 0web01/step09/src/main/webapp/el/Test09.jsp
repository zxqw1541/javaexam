<%-- EL 사용법(Expression Language)
--%>
w<%@page import="java.sql.Date"%>
<%@page import="vo.Board"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
    
<%-- 배열에서 값 꺼내기 --%>
<% 
pageContext.setAttribute("scores", new int[]{100, 90, 80, 70});
%>
${scores[2]},
${scores["2"]}
<%-- ${scores.4} --%> <%-- 문법 오류! --%>


<%-- List에서 값 꺼내기 --%>
<% 
List<String> list = new ArrayList<>();
list.add("홍길동");
list.add("유관순");
list.add("임꺽정");
//EL을 사용하여 로컬 변수에 접근할 수 없다. 그래서 보관소에 저장해야 한다.
pageContext.setAttribute("list", list);
%>
-------------------------------------------------
${list[0]},
${list["1"]},
${list['2']},
-------------------------------------------------

<%-- 맵 객체에서 값 꺼내기 --%>

<%
HashMap<String,Object> map = new HashMap<>();
map.put("name", "홍길동");
map.put("kor", 100); //auto-boxing: new Integer();
map.put("math", 90); //auto-boxing: new Integer();
map.put("hist", 80); //auto-boxing: new Integer();
map.put("sum", (100 + 90 + 80)); //auto-boxing: new Integer();
map.put("aver", (100 + 90 + 80) / 3f); //auto-boxing: new Float();
pageContext.setAttribute("score", map);
%>
-------------------------------------------------

${score.name},
${score["name"]},


<%-- 일반 객체에서 프로퍼티 값 꺼내기 --%>

<%
Board board = new Board(); 
board.setNo(100);
board.setTitle("제목이래유");
board.setContent("내용이라유?");
board.setViews(1000000);
board.setCreatedDate(Date.valueOf("2015-11-27"));

request.setAttribute("boardVo", board);
%>
${boardVo.title},
${boardVo["title"]},
-------------------------------------------------



