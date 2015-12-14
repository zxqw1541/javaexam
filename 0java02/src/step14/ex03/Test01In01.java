package step14.ex03;

import java.io.FileInputStream;

public class Test01In01 {
  public static void main(String[] args) throws Exception{
    //FileInputStream 도구 사용법
    //==> 데이터를 읽어들일 떄 사용하는 도구.
    //==> 지정한 파일리 존재하지 않으면 예외 발생!
    //==> 파일의 형식이 있다면, 읽어들일 때도 그 형식에 맞춰 읽어라!
    FileInputStream in = new FileInputStream("./test/ex03.test01.txt");
    
    //2) 반복문을 사용하여 읽기
    int b;
    while ((b = in.read()) != -1) 
      System.out.println(Integer.toHexString(b));
    
    in.close();
    System.out.println("실행 완료!");
  }
}
