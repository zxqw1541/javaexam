package test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CountFilter implements Filter {
  int count;
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    System.out.println("CountFilter.doFilter()");
    request.setAttribute("count", ++count);
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub
    
  }
  

}
