package java76.pms.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;
import java76.pms.util.MultipartHelper;

public class StudentAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      Map<String,String> paramMap = 
          MultipartHelper.parseMultipartData(
              request, 
              this.getServletContext().getRealPath("/file"));
      
      ApplicationContext iocContainer = 
          (ApplicationContext) this.getServletContext()
                                   .getAttribute("iocContainer");
      StudentDao studentDao = iocContainer.getBean(StudentDao.class);

      response.setContentType("text/html;charset=UTF-8");

      Student student = new Student();
      student.setName(paramMap.get("name"));
      student.setEmail(paramMap.get("email"));
      student.setTel(paramMap.get("tel"));
      student.setCid(paramMap.get("cid"));
      student.setPwd(paramMap.get("pwd"));
      student.setImage(paramMap.get("image"));

      studentDao.insert(student);

      response.sendRedirect("list");
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }

  }
}

