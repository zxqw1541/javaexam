package step10.ex05;

import java.util.HashSet;

public class Test02 {
  public static void main(String[] args) {
    HashSet set = new HashSet(); //set은 집합
    set.add("홍길동");
    set.add("임꺽정");
    set.add("유관순");
    set.add("홍길동"); // 중복을 허용하지 않는다. 저장안됨.
                     // 중복 기준 : hashCode()의 리턴 값이 같고, 
                     // equals()의 리턴 값이 true일 때,
                     // 인스턴스가 달라도 같은 값으로 취급한다.
    set.add(null);
    set.add(null);
    
    
    //set에 저장된 값 꺼내기 - get() 메서드가 없다.
    System.out.println(set.size());
    //1) set에 저장된 값을 담을 배열을 준비한다.
    Object[] list = new Object[set.size()];
    
    //2) set 객체에 배열을 넘기면서 담아달라고 요청한다.
    set.toArray(list);
    
    for (Object value : list) {
      System.out.println(value);
    }
    
  }

}
