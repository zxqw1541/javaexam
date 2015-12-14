package step12.ex01;

import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

public class Test02 {
  public static void main(String[] args) {
    Map<String, String> envMap = System.getenv();
    for (Entry<String, String> entry : envMap.entrySet())
      System.out.println(entry.getKey() + "=" + entry.getValue());
    

    System.out.println("--------------------------");
    
    // JVM의 프로퍼티 값 알아내기
    Properties props = System.getProperties();
    for (Entry<Object, Object> entry : props.entrySet())
      System.out.println(entry.getKey() + "=" + entry.getValue());
  }

}
