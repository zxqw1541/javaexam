package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.StudentDao;

public class StudentDeleteServlet extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    
    PrintWriter out = response.getWriter();
    StudentDao studentDao = ContextLoader.context.getBean(StudentDao.class);
    
    int no = Integer.parseInt(request.getParameter("no"));

    if (studentDao.delete(no) == 0) 
      out.println("해당 번호의 학생이 존재하지 않습니다.");
    else 
      out.println("삭제하였습니다.");
  }
}