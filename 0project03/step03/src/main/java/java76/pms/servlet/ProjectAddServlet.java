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

public class ProjectAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      ApplicationContext iocContainer = 
          (ApplicationContext) this.getServletContext()
                                   .getAttribute("iocContainer");
      ProjectDao projectDao = iocContainer.getBean(ProjectDao.class);
     
      response.setContentType("text/plane;charset=UTF-8");
      PrintWriter out = response.getWriter();

      Project project = new Project();
      project.setTitle(request.getParameter("title"));
      project.setStartDate(Date.valueOf(request.getParameter("startDate")));
      project.setEndDate(Date.valueOf(request.getParameter("endDate")));
      project.setMember(request.getParameter("member"));

      projectDao.insert(project);
      
      response.sendRedirect("list");
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}
