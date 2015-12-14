package step14.ex05;

import java.io.File;
import java.io.FileInputStream;

public class Test02_in {
  
  public static void main(String[] args) throws Exception {
    //FileInputStream을 이용하여 primitive type 데이터 읽기
    FileInputStream in = new FileInputStream("./test/ex05.test02.dat");
    
    String name = null;
    int kor = 0, eng = 0, math = 0;
    
    // 성적 데이터를 읽어서 각 변수에 저장하라.
    // 파일 포멧에 따라 읽는다.
    // 1) 문자열 크기 읽는다.
    int len = 0;
    len = in.read() << 8;
    len |= in.read();
    
    byte[] bytes = new byte[len];
    in.read(bytes);
    name = new String(bytes);
    
    kor |= in.read() << 24;
    kor |= in.read() << 16;
    kor |= in.read() << 8;
    kor |= in.read();
    
    eng |= in.read() << 24;
    eng |= in.read() << 16;
    eng |= in.read() << 8;
    eng |= in.read();

    math |= in.read() << 24;
    math |= in.read() << 16;
    math |= in.read() << 8;
    math |= in.read();
    
    System.out.printf("%s,%d,%d,%d\n", name, kor, eng, math);
    
    in.close();
  }
}
