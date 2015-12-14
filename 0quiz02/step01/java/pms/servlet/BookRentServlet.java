package pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import pms.annotation.Component;
import pms.dao.BookDao;
import pms.dao.BookDao.Rent;
import pms.domain.Book;



@Component("/book/rent")
public class BookRentServlet implements Servlet {
  BookDao bookDao;
  
  public void setBooktDao(BookDao bookDao) {
    this.bookDao = bookDao;
  }

  public void service(HashMap<String, Object> params) {
    
    int no = Integer.parseInt((String)params.get("no"));
    
    PrintStream out = (PrintStream)params.get("out");
    
    
    switch (bookDao.rentBook(no)) {
    case Rent.ALREADY_RENTED:
      out.println("이미 대여된 도서입니다.");
      break;
    case Rent.RENT_OK:
      out.println("대여처리가 되었습니다.");
      break;
    case Rent.SEARCH_FAIL:
      out.println("해당 번호의 도서 정보가 없습니다.");
      break;
    }
    
  }

}
