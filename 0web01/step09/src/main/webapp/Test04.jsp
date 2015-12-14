<%-- 필드나 메서드 선언 : Declaration Element 
. <%! 서블릿 클래스에 넣을 필드나 메서드 선언 %>
. 자바 코드 : 서블릿 클래스에 바로 삽입된다.
. 서블릿에서 사용할 메서드 선언 시에 유용하다.
. 태그 위치에 상관없이 태그 안에 작성한 코드는
 .서블릿 클래스의 상단에 삽입된다.(톰캣 JSP 엔진의 경우)
--%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" %>
템플릿 데이터1
<%!
public void m() {
  System.out.println("오호라...i = " + i);
}
%>
템플릿 데이터2
<%!
private int i = 100;
//설마 클래스 등록 안에 반복문이나 조건문을 넣을 수 없는 것은 알고 있겟죠?
if (i < 100) {
  System.out.println("조건의 결과에 상관없이 문법 오류이다.!");
}

%>