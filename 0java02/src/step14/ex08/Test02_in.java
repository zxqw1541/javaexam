package step14.ex08;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test02_in {
  public static void main(String[] args) throws Exception {
    // 캐싱을 적용한 BufferedInputStream 사용하기
    // => 1 바이트씩 읽을 때 속도는?
    FileInputStream sink = new FileInputStream("./test/test.mp4");
    BufferedInputStream in = new BufferedInputStream(sink);
    
    FileOutputStream sink2 = new FileOutputStream("./test/test2.mp4");
    BufferedOutputStream out = new BufferedOutputStream(sink2);
    
    long start = System.currentTimeMillis();
    int b;
    
    while ((b = in.read()) != -1)
      out.write(b);
    
    long end = System.currentTimeMillis();
    
    System.out.println(end - start);
    
    in.close();
    sink.close();
    out.close();
    sink2.close();
  }

}
