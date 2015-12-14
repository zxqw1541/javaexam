package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.BoardDao;
import java76.pms.dao.StudentDao;
import java76.pms.domain.Board;
import java76.pms.domain.Student;

public class StudentUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int no = Integer.parseInt(request.getParameter("no"));
    
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext()
        .getAttribute("iocContainer");
    StudentDao studentDao = iocContainer.getBean(StudentDao.class);
    
    Student student = studentDao.selectOne(no);
    
    response.setContentType("text/html;charset=UTF-8"); // 다운로드가 되면 컨텐츠타입에 ; 인지 확인
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("   <meta charset='UTF-8'>");
    out.println("   <title>학생-상세정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>학생 정보</h1>");
    
    if (student != null) {
      out.println("<form id='form1' action='update' method='post'>");
      out.println("<table border='1'>");
      out.println("<tr>");
      out.println("  <th>번호</th>");
      out.printf("  <td><input type='text' name='no' value='%d' readonly ></td>\n", 
          student.getNo());
      out.println("</tr>");
      out.println("<tr>");
      out.println("  <th>이름</th>");
      out.printf("  <td><input type='text' name='name' value='%s'></td>\n", 
          student.getName());
      out.println("</tr>");
      out.println("<tr>");
      out.println("  <th>이메일</th>");
      out.printf("  <td><input type='email' name='email' value='%s'></td>\n",
          student.getEmail());
      out.println("</tr>");
      out.println("<tr>");
      out.println("  <th>전화번호</th>");
      out.printf("  <td><input type='text' name='tel' value='%s'></td>\n",
          student.getTel());
      out.println("</tr>");
      out.println("<tr>");
      out.println("  <th>cid</th>");
      out.printf("  <td><input type='text' name='cid' value='%s'></td>\n",
          student.getCid());
      out.println("</tr>");
      
      
      out.println("</table>");
      
      out.println("<p>");
      out.println("<button name='update' type='submit'>변경</button>");
      out.printf("<button name='delete' type='submit' onclick='deleteBoard()'>삭제</button>");
      out.println("</p>");
      out.println("</form>");
    } else {
      out.println("<p>해당 번호의 게시물을 찾을 수 없습니다</p>");
    }
    
    RequestDispatcher rd = request.getRequestDispatcher("/copyright");
    rd.include(request, response);
    
    
    out.println("<script>");
    out.println("function deleteBoard() {");
    out.println("  document.getElementById('form1').action = 'delete';");
    out.println("}");
    out.println("</script>");
    
    
    out.println("</body>");
    out.println("</html>");
  
  
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      Student student = new Student();
      student.setNo(Integer.parseInt(request.getParameter("no")));
      student.setName(request.getParameter("name"));
      student.setEmail(request.getParameter("email"));
      student.setTel(request.getParameter("tel"));
      student.setCid(request.getParameter("cid"));

      ApplicationContext iocContainer = 
          (ApplicationContext) this.getServletContext()
                                   .getAttribute("iocContainer");
      StudentDao studentDao = iocContainer.getBean(StudentDao.class);

      response.setContentType("text/plane;charset=UTF-8");

      if (studentDao.update(student) > 0)
        response.sendRedirect("list");
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("   <meta charset='UTF-8'>");
      out.println("   <title>학생-삭제</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>학생 정보</h1>");
      out.println("<p>해당 학생정보가 일치하지 않습니다.</p>");
      
      RequestDispatcher rd = request.getRequestDispatcher("/copyright");//서블릿 URL
      rd.include(request, response);
      
      out.println("</body>");
      out.println("</html>");

      response.setHeader("Refresh", "2;url=list");
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}
