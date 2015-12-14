package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import pms.annotation.Component;
import pms.dao.BookDao;
import pms.domain.Book;



@Component("/book/update")
public class BookUpdateServlet implements Servlet {
  BookDao bookDao;
  
  public void setBooktDao(BookDao bookDao) {
    this.bookDao = bookDao;
  }

  public void service(HashMap<String, Object> params) {
    
    Book book = new Book();
    book.setNo(Integer.parseInt((String)params.get("no")));
    book.setTitle((String)params.get("title"));
    book.setAuthors((String)params.get("authors"));
    book.setPress((String)params.get("press"));
    book.setTag((String)params.get("tag"));
    
    
    PrintStream out = (PrintStream)params.get("out");
    if (bookDao.update(book) > 0) {
      out.println("저장되었습니다.");
    } else {
      out.println("해당 번호의 도서 정보가 없습니다.");
    }
    
  }

}
