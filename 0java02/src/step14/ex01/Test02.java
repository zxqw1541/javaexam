package step14.ex01;

import java.io.File;

public class Test02 {

  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File("./test/a.txt");
    
    System.out.println("존재 여부 : " + file.exists());
    
    //2) 빈 파일 파일 생성하기 
    file.createNewFile();

  }

}
