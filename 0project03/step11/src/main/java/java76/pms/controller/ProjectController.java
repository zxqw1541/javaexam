package java76.pms.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java76.pms.dao.ProjectDao;
import java76.pms.domain.Project;

@Controller
@RequestMapping("/project/*")
public class ProjectController {

  @Autowired
  ProjectDao projectDao;

  @RequestMapping("list")
  public String list(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
      @RequestParam(defaultValue = "no") String keyword, @RequestParam(defaultValue = "desc") String align,
      HttpServletRequest request) throws Exception {

    // 파라미터 값이 넘오지 않으면 기본 값으로 설정한다.
    if (pageNo < 0)
      pageNo = 1;
    if (pageSize < 0)
      pageSize = 10;
    if (keyword != null)
      keyword = "no";
    if (align != null)
      align = "desc";

    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyboard", keyword);
    paramMap.put("align", align);

    List<Project> projects = projectDao.selectList(paramMap);
    request.setAttribute("projects", projects);

    return "project/ProjectList";
  }

  @RequestMapping("delete")
  public String delete(int no, Model model) throws Exception {

    if (projectDao.delete(no) <= 0) {
      model.addAttribute("error", "401");
      return "project/ProjectAuthError";
    }

    return "redirect:list.do";
  }

  @RequestMapping("detail")
  public String detail(int no, Model model) throws ServletException, IOException {

    Project project = projectDao.selectOne(no);

    model.addAttribute("project", project);

    return "project/ProjectDetail";
  }

  @RequestMapping("update")
  public String update(Project project, Model model) throws ServletException, IOException {

    if (projectDao.update(project) <= 0) {
      model.addAttribute("error", "401");
      return "project/ProjectAuthError";
    }

    return "redirect:list.do";
  }

  @RequestMapping(value="add", method=RequestMethod.POST)
  public String add(Project project) throws Exception {

    projectDao.insert(project);

    return "redirect:list.do";
  }
  
  @RequestMapping(value="add", method=RequestMethod.GET)
  public String form() {
    return "project/ProjectForm";
  }

}
