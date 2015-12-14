package step14.ex04;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class Test02_out {
  
  public static void main(String[] args) throws Exception {
    //FileWriter와 FileOutputStream의 출력비교
    FileOutputStream out = new FileOutputStream("./test/ex04.test02.txt");
    
    //write(int)
    // => 마지막 1바이트 출력.
    // => 출력할때 변환 없음
    out.write(0xaabbccdd); // => dd
    out.write(0xaabb0041); // => 41
    out.write(0xaabbAC00); // => 00
    
    // 출력 결과 dd4100
    
    
    out.close();
    System.out.println("실행완료");
    
  }

}
