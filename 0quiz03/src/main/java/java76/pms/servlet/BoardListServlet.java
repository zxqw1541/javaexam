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

public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
      ApplicationContext iocContainer = (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
      BoardDao boardDao = iocContainer.getBean(BoardDao.class);
  
      int pageNo = 1;
      int pageSize = 10;
      String keyword = "no";
      String align = "desc";
  
      if (request.getParameter("pageNo") != null)
        pageNo = Integer.parseInt(request.getParameter("pageNo"));
      if (request.getParameter("pageSize") != null)
        pageSize = Integer.parseInt(request.getParameter("pageSize"));
      if (request.getParameter("keyword") != null)
        keyword = request.getParameter("keyword");
      if (request.getParameter("align") != null)
        align = request.getParameter("align");
  
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>Insert title here</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>게시판</h1>");
      out.println("<h2>게시판-정보</h2>");
      out.println("<p><a href='form.html'>추가</a></p>");
      out.println("<table border=1>");
      out.println("<tr>");
      out.println("  <th>번호</th>");
      out.println("  <th>제목</th>");
      out.println("  <th>조회수</th>");
      out.println("  <th>생성일</th>");
      out.println("</tr>");
      for (Board b : boardDao.selectList(pageNo, pageSize, keyword, align)) {
        out.println("<tr>");
        out.printf("  <td>%d</td>\n", b.getNo());
        out.printf("  <td><a href='update?no=%d'>%s</a></td>\n", b.getNo(), b.getTitle());
        out.printf("  <td>%d</td>\n", b.getViews());
        out.printf("  <td>%s</td>\n", b.getCreatedDate());
        out.println("</tr>");
      }
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }


  }

}

