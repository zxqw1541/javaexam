/* HttpSession에 타임아웃 설정하기
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet05Login extends javax.servlet.http.HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    String name = request.getParameter("name");
    String pwd = request.getParameter("pwd");

    // HttpSession 보관소 준비하기
    HttpSession session = request.getSession();

    if (name.equals("admin") && pwd.equals("1111")) {
      session.setAttribute("name", name);
      out.println("관리자로 로그인 하셨습니다.");
    } else {
      session.invalidate(); // 로그인에 실패하면 기존 세션을 무효화시킨다. 
      out.println("관리자 아이디/암호가 일치하지 않습니다.");
    }
  }
}
