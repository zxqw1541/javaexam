package step14.ex01;

import java.io.File;

public class Test05 {

  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File("./test/ok");
    
    System.out.println("존재 여부 : " + file.exists());
    
    //6) 디렉토리 지우기
    file.delete();

  }

}
