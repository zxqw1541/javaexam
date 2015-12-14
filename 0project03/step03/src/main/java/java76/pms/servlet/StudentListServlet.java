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
import java76.pms.dao.StudentDao;
import java76.pms.domain.Board;
import java76.pms.domain.Student;

public class StudentListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      int pageNo = 1;
      int pageSize = 200;

      if (request.getParameter("pageNo") != null) {
        pageNo = Integer.parseInt(request.getParameter("pageNo"));
      }

      if (request.getParameter("pageSize") != null) {
        pageSize = Integer.parseInt(request.getParameter("pageSize"));
      }
      // 정렬처리
      String keyword = "no";
      if (request.getParameter("keyword") != null) {
        keyword = request.getParameter("keyword");
      }

      String align = "desc";
      if (request.getParameter("align") != null) {
        align = request.getParameter("align");
      }
      
      ApplicationContext iocContainer = 
          (ApplicationContext) this.getServletContext()
          .getAttribute("iocContainer");
      StudentDao studentDao = iocContainer.getBean(StudentDao.class);

      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("   <meta charset='UTF-8'>");
      out.println("   <title>학생-목록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>학생</h1>");
      
      out.println("<a href='form.html'>새 학생</a><br>");
      
      out.println("<table border='1'>");
      out.println("   <tr>");
      out.println("     <th>번호</th>");
      out.println("     <th>이름</th>");
      out.println("     <th>이메일</th>");
      out.println("     <th>전화번호</th>");
      out.println("     <th>cid</th>");
      out.println("   </tr>");
      
      for (Student student : studentDao.selectList(pageNo, pageSize, keyword, align)) {
        out.println("   <tr>");
        out.printf("     <td>%s</td>\n", student.getNo());
        out.printf("     <td><a href='update?no=%d'>%s</a></td>\n", student.getNo(), student.getName());
        out.printf("     <td>%s</td>\n", student.getEmail());
        out.printf("     <td>%s</td>\n", student.getTel());
        out.printf("     <td>%s</td>\n", student.getCid());
        out.println("   </tr>");
      }
      
      out.println("</table>");
      
      RequestDispatcher rd = request.getRequestDispatcher("/copyright");
      rd.include(request, response);
      
      out.println("</body>");
      out.println("</html>");
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}
