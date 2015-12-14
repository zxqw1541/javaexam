package step16.ex08.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.Socket;



public class FileClient {
  
  byte[] bytes = new byte[8192];
  
  
  
  private void service(String filePath) {
    try ( 
        Socket socket = new Socket("192.168.0.58", 8888);
        FileInputStream fileIn = new FileInputStream(filePath);
        BufferedInputStream in = new BufferedInputStream(fileIn);
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
    ) {
      DataOutputStream outName = new DataOutputStream(socket.getOutputStream());
      
      int length = 0;
      System.out.println("파일 전송중...");
      outName.writeUTF(filePath);
      while ((length = in.read(bytes)) != -1){
        out.write(bytes, 0, length);
      }
      System.out.println("전송 완료!");
    } catch (FileNotFoundException e) {
      System.out.println("파일을 찾을 수 없습니다.");
    } catch (Exception e) {e.printStackTrace();
    } 
     
    
  }
  
  public static void main(String[] args) {
    FileClient client = new FileClient();
    if (args.length < 1) {
      System.out.println("사용법: java -cp ./bin step16.ex08.client.FileClient 파일 경로");
      return;
    }
    client.service(args[0]);
  }

}
