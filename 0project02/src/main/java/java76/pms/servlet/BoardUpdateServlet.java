package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;





@Component("/board/update")
public class BoardUpdateServlet implements Servlet {
  @Autowired
  BoardDao boardDao;
  
 

  public void service(HashMap<String, Object> params) {
    
    Board board = new Board();
    board.setNo(Integer.parseInt((String)params.get("no")));
    board.setTitle((String)params.get("title"));
    board.setContent((String)params.get("content"));
    board.setPassword((String)params.get("password"));
    
    
    PrintStream out = (PrintStream)params.get("out");
    if (boardDao.update(board) > 0) {
      out.println("저장되었습니다.");
    } else {
      out.println("해당 게시물 또는 비밀번호가 일치하지 않습니다.");
    }
    
  }

}
