package pms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
  String url;
  String username;
  String password;  
  ArrayList<Connection> list = new ArrayList<>();
  
  public DBConnectionPool(String drvier, String url, String username, String password) 
      throws Exception {
    
    
    this.url = url;
    this.username = username;
    this.password = password;

    // 다음 방법은 직접 클래스 이름을 명시하기 때문에,
    // 다른 JDBC 드라이버에 대해서는 ㄴ
    //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    
    //대신 다음과 같이 드라이버 클래스 이름을 받아서 클래스를 로딩한다.
    Class.forName(drvier);
  }
  
  public Connection getConnection() throws Exception {
    Connection con = null;
    
    for (int i = 0 ; i < list.size(); i++) {
      con = list.get(i);
      if (con.isClosed() || !con.isValid(1000)) {
        list.remove(i--);
        continue;
      }
      System.out.println("get:" + list.size());
      return list.remove(i);
    }
    
    
    System.out.println("get:" + list.size() +", 커넥션 객체 생성");
    return DriverManager.getConnection(url, username, password);
  }
  
  public void returnConnection(Connection con) {
    try {
      if (con.isClosed())
        return;
      
      if (!con.isValid(1000))
        return ;
      
      list.add(con);
      System.out.println(list.size());
  } catch (Exception e) {}
  }

}
