package step16.ex02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
    BufferedReader in = null;
    PrintStream out = null; 
    
    try (
      //1) 서버의 연결
      Socket socket = new Socket("localhost", 8888);
    ) {
      //2) 서버와 데이터를 주고 받기 위한 도구를 준비한다.
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintStream(socket.getOutputStream()); // 바이트 또는 캐릭터 출력 스트림, 두가지 역할 수행.
     
      //3) 서버에 요청하기
      out.println("Hello!");
      
      //4) 서버로부터 응답 받기
      String message = in.readLine();
      
      //5) 서버가 응답한 메시지 출력하기
      System.out.println(message);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
    }
  }

}
