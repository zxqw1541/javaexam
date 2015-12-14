package step16.ex06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public void send(String message) {
    try (
        //Socket socket = new Socket("192.168.0.36", 8888);
        //Socket socket = new Socket("192.168.0.60", 8888);
        Socket socket = new Socket("localhost", 8888);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                  socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream()); 
    ) {
      int result = 0;
      out.println(message);
      
      try {
        result = Integer.parseInt(in.readLine());
      } catch (Exception e) {
        result = -1;
      }
      
      System.out.println("결과 = " + result);
      
     } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    String message = null;
    Client client = new Client();
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.print("입력> ");
      message = scanner.nextLine();
      client.send(message);
    } while (!message.equals("bye"));
    scanner.close();
  }

}