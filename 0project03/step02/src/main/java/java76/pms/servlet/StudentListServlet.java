package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.StudentDao;
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

      response.setContentType("text/plane;charset=UTF-8");
      PrintWriter out = response.getWriter();

      ApplicationContext iocContainer = 
          (ApplicationContext) this.getServletContext()
                                   .getAttribute("iocContainer");
      StudentDao studentDao = iocContainer.getBean(StudentDao.class);

      out.printf("%-3s %-10s %-20s %-20s %-10s\n", "No", "name", "email", "tel", "cid");

      for (Student student : studentDao.selectList(pageNo, pageSize)) {
        out.printf("%-3d %-10s %-20s %-20s %-10s\n", student.getNo(), student.getName(), student.getEmail(),
            student.getTel(), student.getCid());
      }
      
      RequestDispatcher rd = request.getRequestDispatcher("/copyright");
      rd.include(request, response);
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }
  }
}
