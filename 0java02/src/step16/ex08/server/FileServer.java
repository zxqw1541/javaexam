package step16.ex08.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
  // 일단 1byte보냄
  // 다음 100byte정도 전송
  // 같은지 비교
  // 다음 전체 파일 읽어서 전송

  class CopyFileAgent extends Thread {
    Socket socket;
    String path = "c:\\test\\download\\";

    public CopyFileAgent(Socket socket) {
      this.socket = socket;
    }
    private String getFileName(String filePath) {
      System.out.println(filePath);
      String[] split = filePath.split("\\\\");
      for (String s : split)
        System.out.println( );
      return split[split.length -1];
    }

    @Override
    public void run() {
      byte[] bytes = new byte[8192];
      System.out.println("연결 되었습니다.");
      FileOutputStream fileOut = null;
      try (
          DataInputStream in = new DataInputStream(socket.getInputStream());
          BufferedInputStream in2 = new BufferedInputStream(socket.getInputStream());
      ) 
      {
        String fileName = getFileName(in.readUTF());
        fileOut = new FileOutputStream(path + fileName);
      
        int length = 0;
        while ((length = in2.read(bytes)) != -1) {
          fileOut.write(bytes, 0, length);
        }
        System.out.println("생성완료");

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        fileOut.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    }
  }

  private void service() {
    byte[] bytes = new byte[8192];
    System.out.println("서버가동");
    try (ServerSocket ss = new ServerSocket(8888);) {

      while (true) {
        new CopyFileAgent(ss.accept()).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    FileServer server = new FileServer();
    server.service();

  }

}
