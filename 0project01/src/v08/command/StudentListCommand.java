package v08.command;

import java.util.ArrayList;
import java.util.HashMap;

import v08.dao.StudentDao;
import v08.domain.Student;

// Command 규칙 적용
public class StudentListCommand implements Command {
  StudentDao studentDao;

  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  public void execute(HashMap<String, Object> params) {
    ArrayList<Student> list = studentDao.selectList();

    Student student = null;
    for (int i = 0; i < list.size(); i++) {
      student = list.get(i);
      if (student == null) // 배열의 항목이 null인 경우, 다음 항목으로 바로 이동.
        continue;
      System.out.printf("%d %s %s %s %s\n", i, student.getName(), student.getEmail(), student.getTel(),
          student.getCid());
    }
  }
}
