package pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pms.annotation.Component;
import pms.domain.Book;
import pms.exception.DaoException;
import pms.util.DBConnectionPool;

@Component
public class BookDao {
  
  public static class Rent {
    public static final int RENT_OK = 1;
    public static final int ALREADY_RENTED = 2;
    public static final int SEARCH_FAIL = 3;
  }
  
  public static class Return {
    public static final int RETURN_OK = 1;
    public static final int ALREADY_RETURNED = 2;
    public static final int SEARCH_FAIL = 3;
  }
  
  DBConnectionPool dbPool;

  public void setDBConnectionPool(DBConnectionPool dbConnectionPool) {
    this.dbPool = dbConnectionPool;
  }

  public BookDao() {}

  //To do list : 저자명은 1인 출력
  public List<Book> selectList() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    ArrayList<Book> list = new ArrayList<>();
    
    try {
      con = dbPool.getConnection();
      
      stmt = con.createStatement();
      rs = stmt.executeQuery("select bno, title, authors, press from books");
      
      Book book = null;
      while (rs.next()) { //서버로부터 결과를 가져왔으면 true, 아니면 false
        book = new Book();
        book.setNo(rs.getInt("bno"));
        book.setTitle(rs.getString("title"));
        book.setAuthors(rs.getString("authors"));
        book.setPress(rs.getString("press"));
        list.add(book);
      }
      return list;
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
    
  }

  public int insert(Book book) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();
      stmt = con.prepareStatement(
          "insert into books(title,authors,press,tag) values(?,?,?,?)");
      
      stmt.setString(1, book.getTitle());
      stmt.setString(2, book.getAuthors());
      stmt.setString(3, book.getPress());
      stmt.setString(4, book.getAllTags());
      
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
    
  }

  public int delete(int no) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try (
        Scanner keybook = new Scanner(System.in)) 
    {
      con = dbPool.getConnection();

      stmt = con.prepareStatement("delete from books where bno=?");
      
      stmt.setInt(1, no);
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public int update(Book book) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();

      stmt = con.prepareStatement("update books set title=?, authors=?, press=?, tag=? where bno=?");
      
      stmt.setString(1, book.getTitle());
      stmt.setString(2, book.getAuthors());
      stmt.setString(3, book.getPress());
      stmt.setString(4, book.getAllTags());
      stmt.setInt(5, book.getNo());
      
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public Book selectOne(int no) {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement("select title, authors, press, tag from books where bno=?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();
      
      Book book = null;
      while (rs.next()) { //서버로부터 결과를 가져왔으면 true, 아니면 false
        book = new Book();
        book.setTitle(rs.getString("title"));
        book.setAuthors(rs.getString("authors"));
        book.setPress(rs.getString("press"));
        book.setTag(rs.getString("tag"));
      }
      return book;
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public int rentBook(int no) {
    Connection con = null;
    PreparedStatement stmt = null;
    PreparedStatement stmt1 = null;
    ResultSet rs = null;
    try {
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement("select rent from books where bno=?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();
      boolean rent = false;
    //서버로부터 결과를 가져왔으면 true, 아니면 false
      if(rs.next()) {
        rent = rs.getBoolean("rent");
      } else {
        return Rent.SEARCH_FAIL;
      }
      
      //랜트중
      if (rent)
        return Rent.ALREADY_RENTED;//대여중.
      
      stmt1 = con.prepareStatement("update books set rent=? where bno=?");
      
      stmt1.setBoolean(1, true);
      stmt1.setInt(2, no);
      stmt1.executeUpdate();
      
      return Rent.RENT_OK; //대여 완료

    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {stmt1.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  
  public int returnBook(int no) {
    Connection con = null;
    PreparedStatement stmt = null;
    PreparedStatement stmt1 = null;
    ResultSet rs = null;
    try {
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement("select rent from books where bno=?");
      stmt.setInt(1, no);
      rs = stmt.executeQuery();
      boolean rent = false;
      //서버로부터 결과를 가져왔으면 true, 아니면 false
      if(rs.next()) {
        rent = rs.getBoolean("rent");
      } else {
        return Return.SEARCH_FAIL;
      }
      
      //반납중
      if (!rent)
        return Return.ALREADY_RETURNED;
      
      stmt1 = con.prepareStatement("update books set rent=? where bno=?");
      
      stmt1.setBoolean(1, false);
      stmt1.setInt(2, no);
      stmt1.executeUpdate();
      
      return Return.RETURN_OK; 

    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {stmt1.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
}
