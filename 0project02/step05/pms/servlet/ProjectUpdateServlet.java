package java76.pms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.ProjectDao;
import java76.pms.domain.Project;

@Component("/project/update")
public class ProjectUpdateServlet implements Servlet {
  ProjectDao projectDao;
  
  public void setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }
  
  public void service(HashMap<String,Object> params) {
    Project project = new Project();
    project.setNo(Integer.parseInt((String)params.get("no")));
    project.setTitle((String)params.get("title"));
    project.setStartDate(Date.valueOf((String)params.get("startDate")));
    project.setEndDate(Date.valueOf((String)params.get("endDate")));
    project.setMember((String)params.get("member"));
    
    
    PrintStream out = (PrintStream)params.get("out");
    
    if (projectDao.update(project) > 0)
      out.println("저장되었습니다.");
    else
      out.println("일치하는 번호가 없습니다.");
    
  }
}



