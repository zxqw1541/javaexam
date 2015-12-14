package v09.server.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import v09.server.dao.BoardDao;
import v09.server.domain.Board;

// Command 규칙 적용
public class BoardListServlet implements Servlet {
  BoardDao boardDao;
  
  public void setBoardtDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    ArrayList<Board> list = boardDao.selectList();

    Board board = null;
    for (int i = 0; i < list.size(); i++) {
      board = list.get(i);
      if (board == null) // 배열의 항목이 null인 경우, 다음 항목으로 바로 이동.
        continue;
      out.printf("%d %s %s %s %s\n", i, board.getTitle(), board.getContent(), board.getCreatedDate(),
          board.getWriter());
    }
  }
}
