package v11.server.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;

import v11.server.annotation.Component;
import v11.server.dao.BoardDao;
import v11.server.domain.Board;




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
    board.setCreatedDate(Date.valueOf((String)params.get("createdDate")));
    board.setWriter((String)params.get("writer"));
    boardDao.insert(board);
    out.println("저장되었습니다.");
  }

}
