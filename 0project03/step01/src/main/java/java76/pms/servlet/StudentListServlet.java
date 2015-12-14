package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;

public class StudentListServlet extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    int pageNo = 1;
    int pageSize = 200;
    
    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
    }
    
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    
    
    PrintWriter out = response.getWriter();
    
    StudentDao studentDao = ContextLoader.context.getBean(StudentDao.class);
    
    out.printf("%-3s %-10s %-20s %-20s %-10s\n", 
        "No", "name", "email", "tel", "cid");
    
    for (Student student : studentDao.selectList(pageNo, pageSize)) {
      out.printf("%-3d %-10s %-20s %-20s %-10s\n", 
          student.getNo(),
          student.getName(),
          student.getEmail(),
          student.getTel(),
          student.getCid());
    }
  }
}
