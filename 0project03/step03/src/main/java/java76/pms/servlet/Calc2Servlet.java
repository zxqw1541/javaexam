package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calc2Servlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String op = request.getParameter("op");
    int v1 = Integer.parseInt(request.getParameter("v1"));
    int v2 = Integer.parseInt(request.getParameter("v2"));
    String result = null;
    response.setContentType("text/plane;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    System.out.println("op = " + op);
    System.out.println("v1 = " + v1);
    System.out.println("v2 = " + v2);
    
    switch (op) {
    case "+":
      result = String.valueOf(v1 + v2);
      break;
    case "-":
      result = String.valueOf(v1 - v2);
      break;
    case "*":
      result = String.valueOf(v1 * v2);
      break;
    case "/":
      if(v2 == 0) {
        out.println("Can not divide by zero!");
        return;
      }
      result = String.valueOf((float)v1 / v2);
      break;
    case "%":
      result = String.valueOf(v1 % v2);
      break;
    default:
      out.println("This operator is not supported!");
      return;
    }

    out.println(v1 + op + v2 + "=" + result);

  }

}
