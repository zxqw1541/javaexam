package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int count = (int)request.getAttribute("count");
    
    PrintWriter out = response.getWriter();
    System.out.println(count+"번째 방문자");
    out.println(count+"번째 방문자");
    
  }

}
