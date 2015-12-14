package v10.server.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import v10.server.dao.StudentDao;
import v10.server.domain.Student;



// Command 규칙 적용
public class StudentAddServlet implements Servlet {
  StudentDao studentDao;
  
  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    
    Student student = new Student();
    student.setName((String)params.get("name"));
    student.setEmail((String)params.get("email"));
    student.setTel((String)params.get("tel"));
    student.setCid((String)params.get("cid"));
    studentDao.insert(student);
    out.println("저장되었습니다.");
  }
}
