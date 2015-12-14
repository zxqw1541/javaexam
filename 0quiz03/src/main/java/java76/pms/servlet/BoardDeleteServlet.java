package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.BoardDao;

public class BoardDeleteServlet extends HttpServlet {  
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    try{
      ApplicationContext iocContainer = (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
      BoardDao boardDao = iocContainer.getBean(BoardDao.class);
      
      
      if (boardDao.delete(Integer.parseInt(request.getParameter("no"))
          , request.getParameter("password")) > 0) {
        response.sendRedirect("list");
        return;
      }
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>게시판 삭제-실패</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<p1>삭제 실패</p1>");
      out.println("</body>");
      out.println("</html>");
      
      response.setHeader("refresh", "2;url=list");
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}