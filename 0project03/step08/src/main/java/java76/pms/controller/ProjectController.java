package java76.pms.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.annotation.RequestMapping;
import java76.pms.dao.ProjectDao;
import java76.pms.domain.Project;

@Component
public class ProjectController {

  @Autowired
  ProjectDao projectDao;

  @RequestMapping("/project/list.do")
  public String list(int pageNo,
      int pageSize,
      String keyword,
      String align,
      HttpServletRequest request) 
          throws Exception {

    // 파라미터 값이 넘오지 않으면 기본 값으로 설정한다.
    if (pageNo < 0) pageNo = 1;
    if (pageSize < 0) pageSize = 10;
    if (keyword != null) keyword = "no";
    if (align != null) align = "desc";

    List<Project> projects = projectDao.selectList(pageNo, pageSize, keyword, align);
    request.setAttribute("projects", projects);

    return "/project/ProjectList.jsp";
  }

  @RequestMapping("/project/delete.do")
  public String delete(int no,
      HttpServletRequest request) throws Exception {

    if (projectDao.delete(no) <= 0) {
      request.setAttribute("error", "401");
      return "/project/ProjectAuthError.jsp";
    }

    return "redirect:list.do";
  }
  
  @RequestMapping("/project/detail.do")
  public String detail(
      int no,
      HttpServletRequest request
      ) throws ServletException, IOException {
    
    
    Project project = projectDao.selectOne(no);
    
    request.setAttribute("project", project);
    
    return "/project/ProjectDetail.jsp";
  }

  @RequestMapping("/project/update.do")
  public String update(
      int no,
      String title,
      String startDate,
      String endDate,
      String member,
      HttpServletRequest request) throws ServletException, IOException {
    
      Project project = new Project();
      project.setNo(no);
      project.setTitle(title);
      project.setStartDate(Date.valueOf(startDate));
      project.setEndDate(Date.valueOf(endDate));
      project.setMember(member);

      if (projectDao.update(project) <= 0) {
        request.setAttribute("error", "401");
        return "/project/ProjectAuthError.jsp";
      }
      
      return "redirect:list.do";
  }
  
  @RequestMapping("/project/add.do")
  public String add(String title,
      Date startDate,
      Date endDate,
      String member,
      HttpServletRequest request) throws Exception {
    
    
    Project project = new Project();
    project.setTitle(title);
    project.setStartDate(startDate);
    project.setEndDate(endDate);
    project.setMember(member);

    projectDao.insert(project);
    
    return "redirect:list.do";
}

}
