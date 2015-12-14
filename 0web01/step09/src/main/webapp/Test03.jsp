<%-- 특별한 출력문 : Expression Element 
. <%= 출력문의 파라미터 값 %>
. 자바 코드 : out.print(출력문의 파라미터 값); <- 여기로 들어간다고 생각하면 된다.
. 계산된 값을 출력할 때 사용
. 스크립트릿에 작성한 코드는 _jspService()에 작성한 순서대로 복사된다.
. 오직 자바 코드만 가능하다.

--%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" %>
2 * 2 <%=4%>    <%-- 자바 코드 - out.print(4); --%>
2 * 2 <%=2 * 2%>    <%-- 자바 코드 - out.print(2 * 2); --%> 
2 * 2 <%=(2*-2) > 4 ? "4보다 크다" : "4보다 작그거나 같다"%>
<%-- 자바 코드: out.print((2 * 2) > 4 ? "4보드 크다" : 4보다 같거나 작다"); --%>

<%=for(){}%> 
<%-- 문법 오류! out.print(for(){}); --%>
<%=2;%> 
<%-- 문법 오류!  print(2;); --%>
<%=out.println("okok")%> 
<%-- 문법 오류!  out.print(out.println("okok")); --%>