package step10.ex07;

import java.util.HashMap;
import java.util.Map.Entry;

public class Test02 {
  
  static class Student {
    String name;
    String tel;
    
    public Student(String name, String tel) {
      this.name = name;
      this.tel = tel;
    }

    @Override
    public String toString() {
      return "Student [name=" + name + ", tel=" + tel + "]";
    }
  }

  public static void main(String[] args) {
    HashMap<String, Student> map = new HashMap<String, Student>();
    map.put("s01", new Student("홍길동", "111-1111"));
    map.put("s02", new Student("임꺽정", "111-1112"));
    map.put("s03", new Student("유관순", "111-1113"));
    
    // key 목록을 꺼내기
    for(String key : map.keySet()) {
      System.out.printf("%s : %s\n", 
          key, 
          map.get(key));
      
    }
    
    
    
    
  }
}
