/* ServletContextListener 구현하기
 * contextInitialized() 
 *   - 웹 애플리케이션이 시작될 때 호출된다.
 *   - 웹 애플리케이션이 사용할 객체나 자원을 준비하는 코드를 넣는다.
 * contextDestroyed()
 *   - 웹 애플리케이션이 종료될 때 호출된다.
 *   - 웹 애플리케이션이 사용한 객체나 지원을 해제하는 코드를 넣는다.
 */
package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeListener01 implements ServletContextAttributeListener{

  @Override
  public void attributeAdded(ServletContextAttributeEvent event) {
    // ServletContext에 데이터가 추가될 때 호출된다.
    //=> setAttribute() 메서드가 호출될 때마다 이 메서드가 호출된다.
    System.out.printf("ServletContext에 값 추가: %s=%s\n", event.getName(), event.getValue());
  }

  @Override
  public void attributeRemoved(ServletContextAttributeEvent event) {
    // ServletContext의 데이터가 삭제될 때 호출된다.
    System.out.printf("ServletContext에 등록된 값 삭제: %s=%s\n", event.getName(), event.getValue());
  }

  @Override
  public void attributeReplaced(ServletContextAttributeEvent event) {
    // ServletContext의 데이터가 변경될 때 호출된다.
    System.out.printf("ServletContext에 등록된 값 변경: %s=%s->%s\n", event.getName(), event.getValue(), 
        event.getServletContext().getAttribute(event.getName()));
  }

}
