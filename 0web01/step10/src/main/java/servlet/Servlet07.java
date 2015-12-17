package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/* 쿠키의 유효기간 설정하기 */
@WebServlet("/step10/servlet07")
public class Servlet07 extends HttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    Cookie cookie1 = new Cookie("value1", "hahahaha");
    // 유효기간 설정 => 내부 메모리(렘)가 아니라 HDD에 저장한다.
    // 유효기간이 지난 쿠키는 자동 삭제한다. => 쿠키를 보내려는 시점에서 유효기간 검사한다.
    cookie1.setMaxAge(30); // 30초 ,초단위 
    
    Cookie cookie2 = new Cookie("value2", "oh~ no!");
    // 유효기간을 설정하지 않으면 웹 브라우저가 실행되는 동안만 유효하다.
    // 즉, 웹 브라우저는 내부 메모리(렘)에 쿠키를 보관하기 때문에,
    // 브라우저를 모두 닫으면 내부 메모리도 해제 되기 때문에, 쿠키 정보도 제거된다.

    response.addCookie(cookie1);
    response.addCookie(cookie2);
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("쿠키를 보냈습니다.");

    //로그인 아이디 저장하는 것을 쿠키로 이용함.
    //비밀번호를 쿠키로 저장하는 것은 NO! (브라우저에서 암호화를 하지만 프로그램으로 알아낼 수 있다.)
  }
}

