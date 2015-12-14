package pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pms.domain.Book;
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
  
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public BookDao() {}

  //To do list : 저자명은 1인 출력
  public List<Book> selectList() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectList("pms.dao.BookDao.selectList");
    } finally {
      try {sqlSession.close();} catch (Exception e){}
    }
    
  }

  public int insert(Book book) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    try {
      return sqlSession.insert("pms.dao.BookDao.insert", book);
    } finally {
      try {sqlSession.close();} catch (Exception e){}
    }
    
  }

  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    try {
      return sqlSession.delete("pms.dao.BookDao.delete", no);
    } finally {
      try {sqlSession.close();} catch (Exception e){}
    }
  }
  
  public int update(Book book) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    try {
      return sqlSession.update("pms.dao.BookDao.update", book);
    } finally {
      try {sqlSession.close();} catch (Exception e){}
    }
  }
  
  public Book selectOne(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    try {
      return sqlSession.selectOne("pms.dao.BookDao.selectOne", no);
    } finally {
      try {sqlSession.close();} catch (Exception e){}
    }
  }
  
  public int rentBook(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    boolean rent = false;
    try {
      rent = sqlSession.selectOne("pms.dao.BookDao.rentBook1", no);
    } catch (Exception e) {
      return Rent.SEARCH_FAIL;
    }
    finally {
      try {sqlSession.close();} catch (Exception e){}
    }
    
    if (rent)
      return Rent.ALREADY_RENTED;
    
    sqlSession = sqlSessionFactory.openSession(true);
    Book book = new Book();
    book.setNo(no);
    book.setRent(true);
    try {
      sqlSession.update("pms.dao.BookDao.rentBook2", book);
      return Rent.RENT_OK;
    } finally {
      try {sqlSession.close();} catch (Exception e){}
    }
  }
  
  
  public int returnBook(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    boolean rent = false;
    try {
      rent = sqlSession.selectOne("pms.dao.BookDao.rentBook1", no);
    } catch (Exception e) {
      return Return.SEARCH_FAIL;
    }
    finally {
      try {sqlSession.close();} catch (Exception e){}
    }
    
    if (!rent)
      return Return.ALREADY_RETURNED;
    
    sqlSession = sqlSessionFactory.openSession(true);
    Book book = new Book();
    book.setNo(no);
    book.setRent(false);
    try {
      sqlSession.update("pms.dao.BookDao.rentBook2", book);
      return Return.RETURN_OK;
    } finally {
      try {sqlSession.close();} catch (Exception e){}
    }
  }
}
