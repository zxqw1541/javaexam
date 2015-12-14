package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;


@Component("/board/add")
public class BoardAddServlet implements Servlet {
  BoardDao boardDao;
  
  public void setBoardtDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    
    Board board = new Board();
    board.setTitle((String)params.get("title"));
    board.setContent((String)params.get("content"));
    board.setPassword((String)params.get("password"));
    boardDao.insert(board);
    out.println("저장되었습니다.");
  }

}
