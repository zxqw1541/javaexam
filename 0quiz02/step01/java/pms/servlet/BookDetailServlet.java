package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import pms.annotation.Component;
import pms.dao.BookDao;
import pms.domain.Book;


@Component("/book/detail")
public class BookDetailServlet implements Servlet {
  BookDao bookDao;
  
  public void setBoardtDao(BookDao bookDao) {
    this.bookDao = bookDao;
  }

  public void service(HashMap<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    int no = Integer.parseInt((String)params.get("no"));
    
    Book book = bookDao.selectOne(no);
    if (book == null) {
      out.println("해당 번호의 책이 없습니다.");
      return;
    }
    
    out.printf("제목: %s\n", book.getTitle());
    out.printf("저자: %s\n", book.getAuthors());
    out.printf("출판사: %s\n", book.getPress());
    out.printf("태그: %s\n", book.getAllTags());
  }
}
