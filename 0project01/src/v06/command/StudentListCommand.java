package v06.command;

import java.util.ArrayList;
import java.util.HashMap;

import v06.Student;

// Command 규칙 적용
public class StudentListCommand implements Command {
  public void execute(HashMap<String, Object> params) {
    ArrayList<Student> list = (ArrayList<Student>)params.get("list");
    for (int i = 0; i < list.size(); i++) {
      Student student = list.get(i);
      if (student == null) // 배열의 항목이 null인 경우, 다음 항목으로 바로 이동.
        continue;
      System.out.printf("%d %s %s %s %s\n", 
          i, 
          student.getName(),
          student.getEmail(),
          student.getTel(),
          student.getCid());
    }
  }
}
