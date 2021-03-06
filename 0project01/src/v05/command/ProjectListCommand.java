package v05.command;

import java.util.ArrayList;
import java.util.HashMap;

import v05.Project;

// Command 규칙 적용
public class ProjectListCommand implements Command {
  public void execute(HashMap<String, Object> params) {
    ArrayList<Project> list = (ArrayList<Project>)params.get("list");
    System.out.printf("%-3s %-20s %-10s %-10s %-40s\n", "No", "Title", "Start", "End", "Members");

    Project project = null;
    for (int i = 0; i < list.size(); i++) {
      project = list.get(i);
      if (project == null) // 배열의 항목이 null인 경우, 다음 항목으로 바로 이동.
        continue;
      System.out.printf("% 3d %-20s %3$tY-%3$tm-%3$td %4$s %5$-40s\n", i, project.getTitle(), project.getStartDate(),
          project.getEndDate(), project.getMember());
    }
  }

}
