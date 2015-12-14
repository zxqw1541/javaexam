package v11.server.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import v11.server.annotation.Component;
import v11.server.dao.BoardDao;



@Component("/board/delete")
public class BoardDeleteServlet implements Servlet {
  BoardDao boardDao;

  public void setBoardtDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");

    try {
      boardDao.delete(Integer.parseInt((String)params.get("no")));
      out.println("삭제하였습니다.");
    } catch (Exception e) {
      out.println("해당 번호의 게시물이 존재하지 않습니다.");
    }
  }
}
