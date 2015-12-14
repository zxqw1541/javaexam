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
import java76.pms.domain.Board;

public class BoardDeleteServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      String password = request.getParameter("password");

      ApplicationContext iocContainer = 
          (ApplicationContext) this.getServletContext()
                                   .getAttribute("iocContainer");
      BoardDao boardDao = iocContainer.getBean(BoardDao.class);

      if (boardDao.delete(no, password) > 0) {
        response.sendRedirect("list");
        return;
      } 
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("   <meta charset='UTF-8'>");
      out.println("   <title>게시판-변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>게시물 정보</h1>");
      out.println("<p>해당 게시물 또는 비밀번호가 일치하지 않습니다.</p>");
      
      RequestDispatcher rd = request.getRequestDispatcher("/copyright");//서블릿 URL
      rd.include(request, response);
      
      out.println("</body>");
      out.println("</html>");

      response.setHeader("Refresh", "2;url=list");
      

      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }
  }
}
