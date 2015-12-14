/*
 * 멀티 스레딩
 * - 동시에 작업을 수행해야 하는 코드를 지정하기
 * - 문법 : 
 * 1) Thread 클래스를 상속 받아서 run() 메서드를 오버라이딩 한다.
 * 2) run() 메서드에 코드를 넣는다.
 * 3) Thread의 start() 메서드를 호출하여 작업을 실행시킨다.
 */
package step16.ex06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
/*
 * Runnable 인터페이스를 구현하여 클라이언트 요청 처리
 * 실습:
 * 1) main 메서드의 작업을 Server 클래스의 메서드로 만들기
 * 2) MyThread가 하던 일을 Runnable 인터페이스 구현으로 대체하기
 * 
 */
public class Server {
  static class EchoAgent implements Runnable {
    Socket socket;
    
    public EchoAgent(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      BufferedReader in = null;
      PrintStream out = null;
      String message = null;
      try {
        in = new BufferedReader(
            new InputStreamReader(
                socket.getInputStream()));

        out = new PrintStream(socket.getOutputStream()); // 바이트 또는 캐릭터 출력 스트림,
                                                         // 두가지 역할 수행.
        message = in.readLine();
        int result = 0;
        String[] arr = message.split("&");
        HashMap<String,String> map = new HashMap<String,String>();
        String[] keyValue = null;
        for (String param : arr) {
          keyValue = param.split("=");
          map.put(keyValue[0], keyValue[1]);
        }
        int a = Integer.parseInt(map.get("a"));
        int b = Integer.parseInt(map.get("b"));
        
        switch (map.get("op")) {
        case "+":
          result = a + b;
          break;
        case "-":
          result = a - b;
          break;
        case "*":
          result = a * b;
          break;
        case "/":
          result = a / b;
          break;
        default:
          System.out.println("지원하지 않는 연산자 입니다.");
          return;
        }
        out.println(result);
        
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }
  }
  
  public void service() {
    try (ServerSocket ss = new ServerSocket(8888);)
    {
      System.out.println("클라이언트 연결 기다림...");
      Socket socket = null;
      
      while (true) {
        socket = ss.accept();
        new Thread(new EchoAgent(socket)).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  public static void main(String[] args) {
    Server server = new Server();
    server.service();
  }
}
