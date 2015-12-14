package step14.ex03;

import java.io.FileInputStream;

public class Test03_In {
  public static void main(String[] args) throws Exception{
    FileInputStream in = new FileInputStream("./test/ex03.test03.txt");
    
    byte[] bytes = new byte[100];
    int len = 0;
    len = in.read(bytes); // 이 메서드의 리턴 값은 읽은 바이트 개수이다.
    
    String str = new String(bytes, 0, len, "UTF-8");
    System.out.println(str);
    
    in.close();
    System.out.println("실행 완료!");
  }
}
