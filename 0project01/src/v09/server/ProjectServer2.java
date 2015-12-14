package v09.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import v09.server.dao.ProjectDao;
import v09.server.dao.StudentDao;
import v09.server.servlet.ProjectAddServlet;
import v09.server.servlet.ProjectListServlet;
import v09.server.servlet.StudentListServlet;

public class ProjectServer2 {
  ProjectDao projectDao;
  StudentDao studentDao;
  ProjectListServlet projectListServlet;
  StudentListServlet studentListServlet;
  ProjectAddServlet projectAddServlet;
  
  public ProjectServer2() {
    projectDao = new ProjectDao();
    projectListServlet = new ProjectListServlet();
    projectListServlet.setProjectDao(projectDao);
    
    projectAddServlet = new ProjectAddServlet();
    projectAddServlet.setProjectDao(projectDao);
    
    studentDao = new StudentDao();
    studentListServlet = new StudentListServlet();
    studentListServlet.setStudentDao(studentDao);
    
    
  }
  
  public static void main(String[] args) {
    ProjectServer2 server = new ProjectServer2();
    server.execute();
  }

  private void execute() {
    try (
        ServerSocket ss = new ServerSocket(8888);
    ) 
    {
      while (true) {
        System.out.println("클라이언트 요청을 기다리는 중.....");
        service(ss.accept());
      }
    } catch (Exception e) {e.printStackTrace();}
  }
  
  private void service(Socket socket) {
    System.out.println("클라이언트 요청 처리....");
    
    try (
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
    ) 
    {
      String message = in.readLine();

      HashMap<String, Object> params = new HashMap<String, Object>();
      params.put("out", out);
      
      extractParamDataFromMessage(params, message);

      if (message.startsWith("/project/list"))
        projectListServlet.service(params);
      else if (message.startsWith("/project/add"))
        projectAddServlet.service(params);
      else if (message.startsWith("/student/list"))
        studentListServlet.service(params);
      else
        out.println("죄송하지만, 요청하신 명령은 실행할 수 없습니다.");
      
      out.println();
      
    } catch (Exception e) { e.printStackTrace();}
    finally {
      try {socket.close();} catch (Exception e) {}
    }
  }
  
  private void extractParamDataFromMessage(Map<String, Object> map, String message) {
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
