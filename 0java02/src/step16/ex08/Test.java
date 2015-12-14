package step16.ex08;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Test {
  public static void main(String[] args) {
    Properties p  = System.getProperties();
    Set<Entry<Object, Object>> set = p.entrySet();
    
    for (Entry<Object, Object> o : set)
      System.out.println(o.getKey() + " =" + o.getValue());
  }
}
