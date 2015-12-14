/* forward
 * 
 */
package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CopyrightServlet extends javax.servlet.http.HttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException{

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<p><address>");
    out.println("이 웹 애플리케이션의 모든 권리는 Java76기에 있습니다. &copy;Java76");
    out.println("</address></p>");
  }
  
  @Override
  public void doPost(
      HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException{

    doGet(request, response);
  }
  
}
