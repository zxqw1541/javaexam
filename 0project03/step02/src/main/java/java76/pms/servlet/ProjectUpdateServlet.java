package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.ProjectDao;
import java76.pms.domain.Project;

public class ProjectUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    try {
      response.setContentType("text/plane;charset=UTF-8");
      
      ApplicationContext iocContainer = 
          (ApplicationContext) this.getServletContext()
                                   .getAttribute("iocContainer");
      ProjectDao projectDao = iocContainer.getBean(ProjectDao.class);
      
      PrintWriter out = response.getWriter();

      Project project = new Project();
      project.setNo(Integer.parseInt(request.getParameter("no")));
      project.setTitle(request.getParameter("title"));
      project.setStartDate(Date.valueOf(request.getParameter("startDate")));
      project.setEndDate(Date.valueOf(request.getParameter("endDate")));
      project.setMember(request.getParameter("member"));

      if (projectDao.update(project) > 0)
        out.println("저장되었습니다.");
      else
        out.println("일치하는 번호가 없습니다.");
      
      RequestDispatcher rd = request.getRequestDispatcher("/copyright");
      rd.include(request, response);

      response.setHeader("Refresh", "list");
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }
  }
}
