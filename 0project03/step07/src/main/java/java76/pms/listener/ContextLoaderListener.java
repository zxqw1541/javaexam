package java76.pms.listener;

import static org.reflections.ReflectionUtils.getAllMethods;
import static org.reflections.ReflectionUtils.withAnnotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java76.pms.annotation.RequestMapping;
import java76.pms.domain.RequestHandler;

public class ContextLoaderListener implements ServletContextListener {

  @SuppressWarnings("unchecked")
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    //System.out.println("스프링 IoC 컨테이너 준비하기");
    
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
        sce.getServletContext().getInitParameter("contextConfigLocation"));
    
    ServletContext servletContext = sce.getServletContext();
    servletContext.setAttribute("iocContainer", iocContainer);
    
    //0) RequestHandler 정보를 저장할 테이블을 준비한다.
    Map<String,RequestHandler> handlerMap = new HashMap<>();
    
    Object bean;
    Set<Method> methods = null;
    RequestMapping anno = null;
    
    //1) IoC 컨테이너에서 저장된 빈의 이름을 가져온다.
    String[] beanNames = iocContainer.getBeanDefinitionNames();
    
    for (String name : beanNames) {
      //System.out.println("=> " + name);
      //2) 빈의 이름을 이용하여 IoC
      bean = iocContainer.getBean(name);
      
      //3) 객체를 통해 @RequestMapping이 붙은 메서드를 알아낸다.
      //- getAllMethods(클래스, 조건1, 조건2, 조건3, ...)
      //- withAnootation(애노테이션타입) ==> getAllMethods()가 사용할 조건을 리턴한다.
      methods = getAllMethods(bean.getClass(), /* 해당 클래스에서 찾는다. */ 
          withAnnotation(RequestMapping.class) /*검색 조건 */);
      
      //System.out.println(bean.getClass().getName());
      for (Method m : methods) {
        //4) 메서드에서 RequestMapping 애노테이션 정보를 꺼낸다.
        anno = m.getAnnotation(RequestMapping.class);
        
        //System.out.println("==> " + m.getName());
        //5) RequestHandler 객체에 인스턴스와 메스드 정보를 저장한 후
        //   요청 핸들러 테이블에 보관한다.
        handlerMap.put(anno.value(), /* URL */ 
            new RequestHandler(bean, m)/* 메서드 정보 */);
      }
    }
    
    //servletContext 보관소에 (url-method) 정보가 들어있는 맵 객체를 저장한다.
    servletContext.setAttribute("handlerMap", handlerMap);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    
  }

}
