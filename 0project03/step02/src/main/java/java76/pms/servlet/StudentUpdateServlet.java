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

public class StudentUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      Student student = new Student();
      student.setName(request.getParameter("name"));
      student.setEmail(request.getParameter("email"));
      student.setTel(request.getParameter("tel"));
      student.setCid(request.getParameter("cid"));

      ApplicationContext iocContainer = 
          (ApplicationContext) this.getServletContext()
                                   .getAttribute("iocContainer");
      StudentDao studentDao = iocContainer.getBean(StudentDao.class);

      response.setContentType("text/plane;charset=UTF-8");
      PrintWriter out = response.getWriter();

      if (studentDao.update(student) > 0)
        out.println("저장되었습니다.");
      else
        out.println("일치하는 이메일이 없습니다.");
      
      RequestDispatcher rd = request.getRequestDispatcher("/copyright");
      rd.include(request, response);

      response.setHeader("Refresh", "list");
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }
  }
}
