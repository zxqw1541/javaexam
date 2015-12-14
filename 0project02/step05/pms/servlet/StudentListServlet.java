package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;

@Component("/student/list")
public class StudentListServlet implements Servlet {
  StudentDao studentDao;
  
  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  public void service(HashMap<String,Object> params) {
    int pageNo = 1;
    int pageSize = 10;
    
    if (params.get("pageNo") != null) {
      pageNo = Integer.parseInt((String)params.get("pageNo"));
    }
    
    if (params.get("pageSize") != null) {
      pageSize = Integer.parseInt((String)params.get("pageSize"));
    }
    PrintStream out = (PrintStream)params.get("out");
    
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
