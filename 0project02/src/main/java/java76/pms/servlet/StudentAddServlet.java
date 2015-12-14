package java76.pms.servlet;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.dao.StudentDao;

@Component("/student/add")
public class StudentAddServlet implements Servlet {
  @Autowired
  StudentDao studentDao;
  
  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }
  
  public void service(HashMap<String,Object> params) {
  }
}

