package java76.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

@Component("/board/delete.do")
public class BoardDeleteController implements PageController {

  @Autowired
  BoardDao boardDao;

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    String password = request.getParameter("password");


    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setPassword(request.getParameter("password"));

    if (boardDao.delete(no, password) <= 0) {
      request.setAttribute("erroerMessage", "401");
      return "/board/BoardAuthError.jsp";
    } 
    
    return "redirect:list.do";
  }
}
