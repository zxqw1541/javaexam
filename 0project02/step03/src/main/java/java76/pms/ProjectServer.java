/*
 * 
 */
package java76.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import java76.pms.context.AnnotionApplicationContext;
import java76.pms.servlet.Servlet;
import java76.pms.util.DBConnectionPool;

public class ProjectServer {
  AnnotionApplicationContext context;
  
  class RequestHandler implements Runnable {
    Socket socket;
    public RequestHandler(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      System.out.println("클라이언트 요청 처리...");
      try (
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
          ) 
      {
        String message = in.readLine();
        
        int i = message.indexOf('?');
        String command = message.substring(0, 
                                    (i != -1) ? i : message.length());
        
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("out", out);
        
        extractParamDataFromMessage(params, message);
        
        Object servlet = context.getBean(command);
        
        if (servlet != null && servlet instanceof Servlet) {
          ((Servlet)servlet).service(params);
        } else {
          out.println("죄송하지만, 요청하신 명령은 실행할 수 없습니다.");
        }
        
        out.println();
        
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        try {socket.close();} catch (Exception e) {}
      }
    }
  }
  
  public ProjectServer() throws Exception {
    context = new AnnotionApplicationContext("java76.pms");
    DBConnectionPool dbPool = new DBConnectionPool(
        "com.mysql.jdbc.Driver", 
        "jdbc:mysql://localhost:3306/java76db", 
        "java76", 
        "1111");
    context.addBean("dbPool", dbPool);
  }

  public static void main(String[] args) {
    try {
      ProjectServer server = new ProjectServer();
      server.execute();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void execute() {
    try (
      ServerSocket ss = new ServerSocket(8888);
        ) 
    {
      while (true) {
        System.out.println("클라이언트 요청을 기다리는 중...");
        new Thread(new RequestHandler(ss.accept())).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  private void extractParamDataFromMessage(Map<String,Object> map, String message) {
    int i = 0;
    String paramString = null;
    String[] tokens = null;
    if (message.contains("?")) {
      i = message.indexOf('?');
      paramString = message.substring(i + 1);
      tokens = paramString.split("&");
      String[] keyValue = null;
      for (String token : tokens) {
        keyValue = token.split("=");
        map.put(keyValue[0], keyValue[1]);
      }
    }
  }

}





