/* forward 테스트용 서블릿
 * 
 */
package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends javax.servlet.http.HttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException{

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("******************************");
    out.println("* 오류가 발생했습니다.              *");
    out.println("******************************");
  }
  
  @Override
  public void doPost(
      HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException{

    doGet(request, response);
  }
  
}
