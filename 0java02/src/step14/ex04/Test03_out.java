package step14.ex04;

import java.io.FileWriter;
import java.nio.charset.Charset;

public class Test03_out {
  
  public static void main(String[] args) throws Exception {
    FileWriter out = new FileWriter("./test/ex04.test03.txt");
    
    //write(String)
    // => 유니코드 문자열을 출력한다.
    String str = "ABC\nabc\n가각간\n똘똠똥\n";
    for (byte b : str.getBytes("utf-16")) {//utf-16 유니코드 2바이트로 뽑아내기 
      System.out.printf("%02x",b);
    }
    //출력 결과:
    // 첫번째 2바이트는 유니코드임을 알려주기 위해 부차적으로 붙은 데이터이다. 일단 무시 (feff)
    //feff 
    // 0041 0042 0043 000a 0061 0062 0063 000a 
    // ac00 ac01 ac04 000a b618 b620 b625 000a
    out.write(str); // Unicode ---> utf-8 출력
    
    out.close();
    System.out.println("실행완료");
    
  }

}
