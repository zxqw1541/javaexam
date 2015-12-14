/* Refresh
 * 
 */
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02Sum extends javax.servlet.http.HttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException{

    int kor = Integer.parseInt(request.getParameter("kor"));
    int math = Integer.parseInt(request.getParameter("math"));
    int hist = Integer.parseInt(request.getParameter("hist"));
    
    int sum = kor + math + hist;
    
    //계산 결과를 ServletRequest 보관소에 저장한다.
    request.setAttribute("sum", sum);
    
  }
}