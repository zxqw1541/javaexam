package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import pms.annotation.Component;
import pms.dao.BookDao;
import pms.domain.Book;


@Component("/book/list")
public class BookListServlet implements Servlet {
  BookDao bookDao;
  
  public void setBoardtDao(BookDao bookDao) {
    this.bookDao = bookDao;
  }

  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    out.printf("%-3s %-25s %-15s %-10s\n", 
        "번호", "제목", "저자", "출판사");

    for (Book book : bookDao.selectList()) {
      out.printf("%-3d %-25s %-15s %-10s\n", book.getNo(), book.getTitle(), 
          book.getOneAuthor(), book.getPress());
    }
  }
}
