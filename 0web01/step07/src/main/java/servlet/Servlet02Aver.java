/* Refresh
 * 
 */
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02Aver extends javax.servlet.http.HttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException{

    int sum = (int)request.getAttribute("sum");
    float aver = sum / 3f;
    
    //계산 결과를 ServletRequest 보관소에 저장한다.
    request.setAttribute("aver", aver);
    
  }
}