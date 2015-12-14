package v09.server.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import v09.server.dao.ProjectDao;
import v09.server.domain.Project;

public class ProjectListServlet implements Servlet {
  ProjectDao projectDao; 
  

  public void setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  @Override
  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    
    out.printf("%-3s %-20s %-10s %-10s %-40s\n", "No", "Title", "Start", "End", "Members");
    
    int i = 0;
    for (Project project: projectDao.selectList()) {
      if (project == null) // 배열의 항목이 null인 경우, 다음 항목으로 바로 이동.
        continue;
      out.printf("% 3d %-20s %3$tY-%3$tm-%3$td %4$s %5$-40s\n", 
          i++,
          project.getTitle(),
          project.getStartDate(),
          project.getEndDate(),
          project.getMember());
    }
    
    try {
      Thread.currentThread().sleep(10000);
    } catch (InterruptedException e) {}
  }
}
