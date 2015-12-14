package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Test02 {
  
  public static void main(String[] args) {
    Connection con = null;
    Statement stat = null;
    try {
      //1) java.sql.Driver 구현체를 드라이버 관리자에게 등록한다.
      // => com.mysql.jdbc.Driver
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
     // DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
      //DriverManager.registerDriver(new org.postgresql.Driver());
      
      
      //2) DriverManager에게 Connection 객체를 요구한다.
      // => JDBC URL을 통해 사용할 Driver를 선택한다.
      // => 그 드라이버 객체를 이용하여 DBMS에 연결한다.
      // => 드라이버가 생성해 준 연결 객체를 리턴한다.
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java76db", "java76", "1111");
      
      System.out.println("DBMS연결 성공");
      
      //3) Connection 객체를 통해 DBMS에 SQL을 전달할 객체를 얻는다.
      stat = con.createStatement();
      System.out.println("SQL 실행 객체 준비 완료!");
      
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {
        stat.close();
        con.close();
      } catch (Exception e) {}
    }
    
  }
  
  

}
