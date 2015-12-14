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
import java76.pms.domain.Board;

public class BoardUpdateServlet extends HttpServlet {  
  private static final long serialVersionUID = 1L;

  // GET 요청이 들어오면 해당 게시물의 상세 정보를 출력한다.
  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    ApplicationContext iocContainer = (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    BoardDao boardDao = iocContainer.getBean(BoardDao.class);
    
    int no = Integer.parseInt(request.getParameter("no"));
    Board board = boardDao.selectOne(no);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게시판 수정</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p1>정보 수정</p1>");

    out.println("<form id='form1' action='update' method='post'>");
    out.println("<table border='1'>");
    out.println("  <tr>");
    out.println("    <th>번호</td>");
    out.printf("    <td><input type='text' name='no' value='%d' readonly></td>\n", board.getNo());
    out.println("  </tr>");
    out.println("  <tr>");
    out.println("    <th>타이틀</td>");
    out.printf("    <td><input type='text' name='title' value='%s'></td>\n", board.getTitle());
    out.println("  </tr>");
    out.println("  <tr>");
    out.println("    <th>내용</td>");
    out.printf("    <td><textarea name='content' rows='10' cols='60'>%s</textarea></td>\n", board.getContent());
    out.println("  </tr>");
    out.println("  <tr>");
    out.println("   <th>조회수</td>");
    out.printf("    <td>%d</td>\n", board.getViews());
    out.println("  </tr>");
    out.println("  <tr>");
    out.println("    <th>등록일</td>");
    out.printf("    <td>%s</td>\n", board.getCreatedDate());
    out.println("  </tr>");
    out.println("  <tr>");
    out.println("    <th>비밀번호</td>");
    out.println("    <td><input type='password' name='password'></td>");
    out.println("  </tr>");
    out.println("</table>");
    out.println("<button name='update' type='submit'>변경</button>");
    out.println("<button name='delete' type='submit' onclick='deleteBoard()'>삭제</button>");
    out.println("</form>");

    out.println("<script>");
    out.println("function deleteBoard() {");
    out.println("  document.getElementById('form1').action ='delete';");
    out.println("}");
    out.println("</script>");

    out.println("</body>");
    out.println("</html>");
    
 
  }
  
  // POST 요청이 들어오면 해당 게시물을 입력한 값으로 변경한다.
  @Override
  public void doPost(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    try {
    ApplicationContext iocContainer = (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    BoardDao boardDao = iocContainer.getBean(BoardDao.class);
    
    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    board.setPassword(request.getParameter("password"));
    
    if (boardDao.update(board) > 0){
      response.sendRedirect("list");
      return;
    }
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게시판 수정-실패</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p1>수정 실패</p1>");
    out.println("</body>");
    out.println("</html>");
    
    response.setHeader("refresh", "2;url=list");
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
}

