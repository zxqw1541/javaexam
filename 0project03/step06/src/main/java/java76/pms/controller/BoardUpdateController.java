package java76.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

@Component("/board/update.do")
public class BoardUpdateController implements PageController {
  @Autowired
  BoardDao boardDao;

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) 
      throws Exception {
    if (request.getMethod().equals("GET")) {
      return get(request, response);
    } else {
      return post(request, response);
    }
  }

  private String get(HttpServletRequest request, HttpServletResponse response) 
      throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Board board = boardDao.selectOne(no);
    request.setAttribute("board", board);
    return "/board/BoardDetail.jsp";
  }

  // POST 요청이 들어오면 해당 게시물을 입력한 값으로 변경한다.
  private String post(HttpServletRequest request, HttpServletResponse response) 
      throws Exception {
    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    board.setPassword(request.getParameter("password"));

    if (boardDao.update(board) <= 0) {
      request.setAttribute("erroerMessage", "401");
      return "/board/BoardAuthError.jsp";
    }
    return "redirect:list.do";
  }

}
