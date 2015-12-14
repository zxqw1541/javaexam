package step03;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Exam06 {
  
  public static void main(String[] args) throws Exception {
    
    Socket 네이버연결정보 = new Socket("www.naver.com", 80);
    OutputStream 출력할때사용정보 = 네이버연결정보.getOutputStream();
    PrintStream 좀더진보된출력정보 = new PrintStream(출력할때사용정보);
    좀더진보된출력정보.println("GET / HTTP/1.1");
    좀더진보된출력정보.println("Host: www.naver.com");
    좀더진보된출력정보.println();
    
    InputStream 읽을때사용할정보 = 네이버연결정보.getInputStream();
    Scanner 좀더진보된읽기정보 = new Scanner(읽을때사용할정보);
    while(true){
      System.out.println(좀더진보된읽기정보.nextLine());
    }
    
    
  }
}
