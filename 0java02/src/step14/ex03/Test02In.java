package step14.ex03;

import java.io.FileInputStream;

public class Test02In {
  public static void main(String[] args) throws Exception{
    FileInputStream in = new FileInputStream("./test/ex03.test02.txt");
    
    byte[] bytes = new byte[100];
    int len = 0;
    len = in.read(bytes); // 이 메서드의 리턴 값은 읽은 바이트 개수이다.
    
    for (int i = 0; i < len; i++)
      System.out.printf("%02x\n", bytes[i]);
    
    in.close();
    System.out.println("실행 완료!");
  }
}
