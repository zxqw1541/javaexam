package java76.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java76.pms.annotation.Component;
import java76.pms.domain.Board;
import java76.pms.exception.DaoException;
import java76.pms.util.DBConnectionPool;

@Component
public class BoardDao {
  DBConnectionPool dbPool;

  public void setDBConnectionPool(DBConnectionPool dbConnectionPool) {
    this.dbPool = dbConnectionPool;
  }

  public BoardDao() {}

  public List<Board> selectList() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    ArrayList<Board> list = new ArrayList<>();
    
    try {
      con = dbPool.getConnection();
      
      stmt = con.createStatement();
      rs = stmt.executeQuery("select bno, title, views, cre_dt from board");
      
      Board board = null;
      while (rs.next()) { //서버로부터 결과를 가져왔으면 true, 아니면 false
        board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setTitle(rs.getString("title"));
        board.setViews(rs.getInt("views"));
        board.setCreateDate(rs.getDate("cre_dt"));
        list.add(board);
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

  public int insert(Board board) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement(
          "insert into board(title,content,pwd,cre_dt) values(?,?,?,now())");
      
      
      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setString(3, board.getPassword());
      
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
        Scanner keyboard = new Scanner(System.in)) 
    {
      con = dbPool.getConnection();

      stmt = con.prepareStatement("delete from board where bno=?");
      
      stmt.setInt(1, no);
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public int update(Board board) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();

      stmt = con.prepareStatement("update board set title=?, content=?, cre_dt=now() where bno=? and (pwd is null or pwd=?)");
      
      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getNo());
      stmt.setString(4, board.getPassword());
      
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
    
  }
}
