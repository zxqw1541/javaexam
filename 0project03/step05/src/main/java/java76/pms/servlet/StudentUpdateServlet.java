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

public class StudentUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
      String email = request.getParameter("email");
      
      ApplicationContext iocContainer = 
          (ApplicationContext) this.getServletContext()
          .getAttribute("iocContainer");
      StudentDao studentDao = iocContainer.getBean(StudentDao.class);
      
      Student student = studentDao.selectOne(email);
      request.setAttribute("student", student);
      
      response.setContentType("text/html;charset=UTF-8"); // 다운로드가 되면 컨텐츠타입에 ; 인지 확인
      
      RequestDispatcher rd = request.getRequestDispatcher("/student/StudentDetail.jsp");
      rd.include(request, response);
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
    
  
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      Map<String,String> paramMap = 
          MultipartHelper.parseMultipartData(
              request, 
              this.getServletContext().getRealPath("/file"));
      
      Student student = new Student();
      student.setName(paramMap.get("name"));
      student.setEmail(paramMap.get("email"));
      student.setTel(paramMap.get("tel"));
      student.setCid(paramMap.get("cid"));
      student.setPwd(paramMap.get("pwd"));
      
      if(paramMap.get("image") != null){
        student.setImage(paramMap.get("image"));
      }
      else if (paramMap.get("himage").length() > 0){
        student.setImage(paramMap.get("himage"));
      }
      
      ApplicationContext iocContainer = 
          (ApplicationContext) this.getServletContext()
                                   .getAttribute("iocContainer");
      StudentDao studentDao = iocContainer.getBean(StudentDao.class);

      response.setContentType("text/html;charset=UTF-8");

      if (studentDao.update(student) > 0)
        response.sendRedirect("list");
      
      request.setAttribute("errorCode", "401");
      RequestDispatcher rd = request.getRequestDispatcher("/student/StudentAuthError.jsp");
      rd.include(request, response);

    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}
