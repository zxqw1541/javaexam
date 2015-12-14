package java76.pms.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
  public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int pageNo = 1;
    int pageSize = 100;

    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
    }

    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }

    // 정렬처리
    String keyword = "no";
    if (request.getParameter("keyword") != null) {
      keyword = request.getParameter("keyword");
    }

    String align = "desc";
    if (request.getParameter("align") != null) {
      align = request.getParameter("align");
    }

    List<Project> projects = projectDao.selectList(pageNo, pageSize, keyword, align);
    request.setAttribute("projects", projects);

    return "/project/ProjectList.jsp";
  }

  @RequestMapping("/project/delete.do")
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    if (projectDao.delete(no) <= 0) {
      request.setAttribute("error", "401");
      return "/project/ProjectAuthError.jsp";
    }

    return "redirect:list.do";
  }
  
  @RequestMapping("/project/update.do")
  public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
  
  @RequestMapping("/project/add.do")
  public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    Project project = new Project();
    project.setTitle(request.getParameter("title"));
    project.setStartDate(Date.valueOf(request.getParameter("startDate")));
    project.setEndDate(Date.valueOf(request.getParameter("endDate")));
    project.setMember(request.getParameter("member"));

    projectDao.insert(project);
    
    return "redirect:list.do";
}

}
