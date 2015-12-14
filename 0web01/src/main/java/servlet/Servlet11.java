package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 파일 업로드 */
@WebServlet("/file/upload")
public class Servlet11 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    // 멀티파트 형식으로 받은 데이터를 getParameter()를 통해 값을 꺼낼 수 없다.
    //String name = request.getParameter("name");
    //String photo = request.getParameter("photo");
    
    // 멀티파트 형식으로 받은 데이터를 분석하여 값 꺼내기
    InputStream in = request.getInputStream();
    for (int i = 0; i < 100; i++) {
      System.out.printf("%c",in.read());
    }
    
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    //out.printf("이름 = %s\n", name);
    //out.printf("사진 = %s\n", photo);
  }
}


