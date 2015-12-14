package step14.ex05;

import java.io.FileOutputStream;

public class Test01_out {
  
  public static void main(String[] args) throws Exception {
    //primitive type 데이터 출력하기
    FileOutputStream out = new FileOutputStream("./test/ex05.test01.dat");
  
    int i = 1735432111; // 6770 97AF
    
    // value를 출력하라!
    // => FileOutputStream의 write(int) 메서드는 
    //    출력하고 싶은 
    out.write(i >> 24); //3바이트 이동 (24비트) //0x00000067
    out.write(i >> 16); //0x00006770
    out.write(i >> 8);  //0x00677097
    out.write(i);       //0x677097af
    
    out.close();
    
    System.out.println("실행완료");
  }
}
