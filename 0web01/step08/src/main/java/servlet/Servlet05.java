/*  서블릿 컨텍스트에 값 넣기 테스트
 * 
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet05 extends javax.servlet.http.HttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException{
    
    // 컨텍스트 파라미터 값 꺼내기
    ServletContext context = this.getServletContext();
    
    
    // 서블릿 초기화 파라미터 값 꺼내기
    ServletConfig config = this.getServletConfig();
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("param1=%s\n", config.getInitParameter("param1"));
    out.printf("context-param1=%s\n", context.getInitParameter("context-param1"));
    out.printf("context-param2=%s\n", context.getInitParameter("context-param2"));
    
    
  }
  
}
