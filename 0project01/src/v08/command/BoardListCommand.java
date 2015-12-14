package v08.command;

import java.util.ArrayList;
import java.util.HashMap;

import v08.dao.BoardDao;
import v08.domain.Board;

// Command 규칙 적용
public class BoardListCommand implements Command {
  BoardDao boardDao;
  
  public void setBoardtDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  public void execute(HashMap<String, Object> params) {
    ArrayList<Board> list = boardDao.selectList();

    Board board = null;
    for (int i = 0; i < list.size(); i++) {
      board = list.get(i);
      if (board == null) // 배열의 항목이 null인 경우, 다음 항목으로 바로 이동.
        continue;
      System.out.printf("%d %s %s %s %s\n", i, board.getTitle(), board.getContent(), board.getCreatedDate(),
          board.getWriter());
    }
  }
}
