package java76.pms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java76.pms.domain.Student;

public class AuthInterceptor extends HandlerInterceptorAdapter {
  public static final Logger log = Logger.getLogger(AuthInterceptor.class);
  
  @Override
  public boolean preHandle(
      HttpServletRequest request, 
      HttpServletResponse response, 
      Object handler) throws Exception {
    
    log.debug("로그인 인터셉터 실행!");
    
    Student loginUser = (Student)request.getSession().getAttribute("loginUser");
    
    if (!request.getServletPath().startsWith("/auth") && loginUser == null) {
      log.debug(request.getContextPath() + "/auth/login.do");
      response.sendRedirect(request.getContextPath() + "/auth/login.do");
      return false; // 다음으로 가는 것을 멈춰라!!
    }
    
    return true; // 다음 인터셉터나 페이지 컨트롤러로 가라.
  }

}
