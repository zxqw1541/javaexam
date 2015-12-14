package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Test09 {
  
  public static void main(String[] args) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try (
        // java.lang.AutoCloseable 구현체인 경우 자동으로 close()를 호출한다.
        // try ~ catch를 실행한 후 자동으로 close()를 호출된다.
        Scanner keyboard = new Scanner(System.in)) 
    {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java76db","java76", "1111");

      // SQL문을 준비한다.
      // => 값이 들어갈 자리는 '?' 문자로 표시한다. => in-parameter 라 부른다.
      stmt = con.prepareStatement("update board set title=?, content=? where bno=?");
      
      System.out.print("번호?");
      int no = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("제목?");
      String title = keyboard.nextLine();
      
      System.out.print("내용?");
      String content = keyboard.nextLine();
      
      // 값을 in-parameter에 할당한다.
      // => 문자열이면 setString(), 정수 값이면 setInt()
      //    즉 데이터와 컬럼의 타입에 따라 setXxx()를 선택하라!
      // => in-parameter의 인덱스는 1부터 시작한다.
      stmt.setString(1, title);
      stmt.setString(2, content);
      stmt.setInt(3, no);
      
      // insert 실행 => 아규먼트를 전달할 필요가 없다.
      int count = stmt.executeUpdate();

      /* PreparedStatement를 사용할 때 이점?
       * 1) SQL 문을 만들기 위해 + 연산자를 사용하여  문자열을 붙이는 번거로움이 없다.
       * 2) SQL에 영향을 끼치는 문자 (예: 따옴표 - ' )를 삽입해도 문제 없다.
       * 3) SQL 삽입을 임의적으로 할 수 없다. 
       *    => in-parameter에 넣는 데이터는 단순한 값으로 취급한다.
       *    => SQL문에 영향을 끼치지 못한다.
       *    => SQL 삽입 해킹을 할 수 없다.
       * 4) 바이너리 데이터를 넣을 수 있다.
       */
      
      
      
      
      
      if (count > 0)
        System.out.println("변경 성공!");
      else
        System.out.println("변경 실패!");
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
    
  }
  
  

}
