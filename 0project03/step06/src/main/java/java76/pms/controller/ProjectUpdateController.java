package java76.pms.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.dao.ProjectDao;
import java76.pms.domain.Project;

@Component("/project/update.do")
public class ProjectUpdateController implements PageController {
  
  @Autowired
  ProjectDao projectDao;
  
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equals("GET")) {
      return get(request, response);
    } else {
      return post(request, response);
    }
  }
  
  private String get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    int no = Integer.parseInt(request.getParameter("no"));
    
    Project project = projectDao.selectOne(no);
    
    request.setAttribute("project", project);
    
    return "/project/ProjectDetail.jsp";
  }

  private String post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
      Project project = new Project();
      project.setNo(Integer.parseInt(request.getParameter("no")));
      project.setTitle(request.getParameter("title"));
      project.setStartDate(Date.valueOf(request.getParameter("startDate")));
      project.setEndDate(Date.valueOf(request.getParameter("endDate")));
      project.setMember(request.getParameter("member"));

      if (projectDao.update(project) <= 0) {
        request.setAttribute("error", "401");
        return "/project/ProjectAuthError.jsp";
      }
      
      return "redirect:list.do";
  }
}
