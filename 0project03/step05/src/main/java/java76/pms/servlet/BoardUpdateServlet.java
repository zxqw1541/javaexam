package java76.pms.servlet;

import java.io.IOException;

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
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    int no = Integer.parseInt(request.getParameter("no"));
    
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext()
        .getAttribute("iocContainer");
    BoardDao boardDao = iocContainer.getBean(BoardDao.class);
    
    Board board = boardDao.selectOne(no);
    request.setAttribute("board", board);
    
    
    response.setContentType("text/html;charset=UTF-8"); // 다운로드가 되면 컨텐츠타입에 ; 인지 확인
    RequestDispatcher rd = request.getRequestDispatcher(
                                        "/board/BoardDetail.jsp");
    
    rd.include(request, response);
  }
  
  // POST 요청이 들어오면 해당 게시물을 입력한 값으로 변경한다.
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      ApplicationContext iocContainer = 
          (ApplicationContext) this.getServletContext()
                                   .getAttribute("iocContainer");
      BoardDao boardDao = iocContainer.getBean(BoardDao.class);

      Board board = new Board();
      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));
      board.setPassword(request.getParameter("password"));

      if (boardDao.update(board) > 0) {
        response.sendRedirect("list");
        return;
      }
      
      // 오류 코드를 ServletRequest 보관소에 담는다.
      request.setAttribute("erroerMessage", "401");
      
      response.setContentType("text/html;charset=UTF-8");
      RequestDispatcher rd = request.getRequestDispatcher("/board/BoardAuthError.jsp");//서블릿 URL
      rd.include(request, response);
      
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e); //오류 정보를 ErrorServlet에게 전달한다.
      rd.forward(request, response);
    }
  }

}
