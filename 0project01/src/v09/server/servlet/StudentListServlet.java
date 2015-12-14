package v09.server.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import v09.server.dao.StudentDao;
import v09.server.domain.Student;

// Command 규칙 적용
public class StudentListServlet implements Servlet {
  StudentDao studentDao;

  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    
    int i = 0;
    for (Student student : studentDao.selectList()) {
      if (student == null) // 배열의 항목이 null인 경우, 다음 항목으로 바로 이동.
        continue;
      out.printf("%d %s %s %s %s\n", i++, student.getName(), student.getEmail(), student.getTel(),
          student.getCid());
    }
  }
}
