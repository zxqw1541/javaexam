package step14.ex08;

import java.io.FileInputStream;

public class Test01_in {
  
  public static void main(String[] args) throws Exception {
    //FileInputStream을 이용하여 primitive type 데이터 읽기
    FileInputStream sink = new FileInputStream("./test/ex08.test01.dat");
    DataInputStream in = new DataInputStream(sink);
    
    String name = null;
    int kor = 0, eng = 0, math = 0;
    
    // 성적 데이터를 읽어서 각 변수에 저장하라.
    // 파일 포멧에 따라 읽는다.
    // 1) 문자열 크기 읽는다.
    
    name = in.readUTF();
    kor = in.readInt();
    eng = in.readInt();
    math = in.readInt();
    
    System.out.printf("%s,%d,%d,%d\n", name, kor, eng, math);
    
    in.close();
    sink.close();
  }
}
