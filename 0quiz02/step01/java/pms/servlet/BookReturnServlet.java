package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import pms.annotation.Component;
import pms.dao.BookDao;
import pms.dao.BookDao.Return;



@Component("/book/return")
public class BookReturnServlet implements Servlet {
  BookDao bookDao;
  
  public void setBooktDao(BookDao bookDao) {
    this.bookDao = bookDao;
  }

  public void service(HashMap<String, Object> params) {
    
    int no = Integer.parseInt((String)params.get("no"));
    PrintStream out = (PrintStream)params.get("out");
    
    
    switch (bookDao.returnBook(no)) {
    case Return.ALREADY_RETURNED:
      out.println("이미 반납된 도서입니다.");
      break;
    case Return.RETURN_OK:
      out.println("반납처리가 되었습니다.");
      break;
    case Return.SEARCH_FAIL:
      out.println("해당 번호의 도서 정보가 없습니다.");
      break;
    }
    
  }

}
