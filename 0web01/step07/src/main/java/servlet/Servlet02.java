/*
 * 
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02 extends javax.servlet.http.HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("이름=%s\n", request.getParameter("name"));
    out.printf("국어=%s\n", request.getParameter("kor"));
    out.printf("수학=%s\n", request.getParameter("math"));
    out.printf("역사=%s\n", request.getParameter("hist"));

    RequestDispatcher rd = null; 
    rd = request.getRequestDispatcher("/step07/servlet02sum");
    rd.include(request, response);
    
    int sum = (int)request.getAttribute("sum");
    out.printf("합계=%d\n", sum);
    
    rd = request.getRequestDispatcher("/step07/servlet02aver");
    rd.include(request, response);
    
    float aver = (float)request.getAttribute("aver");
    out.printf("평균=%f\n", aver);
  }

}
