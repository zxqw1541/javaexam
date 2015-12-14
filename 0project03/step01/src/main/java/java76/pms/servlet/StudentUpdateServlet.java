package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;

public class StudentUpdateServlet extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    
    
    Student student = new Student();
    student.setName(request.getParameter("name"));
    student.setEmail(request.getParameter("email"));
    student.setTel(request.getParameter("tel"));
    student.setCid(request.getParameter("cid"));

    StudentDao studentDao = ContextLoader.context.getBean(StudentDao.class);
    PrintWriter out = response.getWriter();
    
    
    if (studentDao.update(student) > 0)
      out.println("저장되었습니다.");
    else 
      out.println("일치하는 이메일이 없습니다.");
  }
}
