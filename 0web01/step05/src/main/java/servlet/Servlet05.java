/* HttpServlet을 클래스를 이용하여
 * HttpServletRequest와 HttpServletResponse를 자동 형변환하기 
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet05 extends HttpServlet {

  private static final long serialVersionUID = 1L;
  

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    if (request.getMethod().equals("POST")) {
      out.println("POST 요청입니다.");
    } else {
      out.println("GET 요청입니다.");
    }

    
  }

}
