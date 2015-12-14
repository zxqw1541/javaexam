/* ServletContext
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet06Step1 extends javax.servlet.http.HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    
    //ServletContext 받기
    ServletContext context = request.getServletContext();
    
    //ServletContext에 데이터 보관하기
    context.setAttribute("name", name);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("이름을 보관하였습니다.");

    
  }

}
