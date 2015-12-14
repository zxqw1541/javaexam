package v09.server.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;

import v09.server.dao.BoardDao;
import v09.server.domain.Board;


// Command 규칙 적용
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
