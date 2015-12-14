/* 
 * 주제: 해시맵 사용하기 (3)
 * - MyKey의 해시코드 조정하기
 */
package step10.ex04;

import java.util.HashMap;

public class Test03 {
  
  static class MyKey {
    String id;
    int secNo;
    
    public MyKey(String id, int secNo) {
      this.id = id;
      this.secNo = secNo;
    }

    @Override
    public String toString() {
      return "MyKey [id=" + id + ", secNo=" + secNo + "]";
    }
    
    @Override
    public int hashCode() {
      return 1;
    }
    
    @Override
    public boolean equals(Object obj) {
      return true;
    }
  }
  
  public static void main(String[] args) {
    MyKey mk1 = new MyKey("aaa", 10);
    MyKey mk2 = new MyKey("bbb", 20);
    MyKey mk3 = new MyKey("ccc", 30);
    MyKey mk4 = new MyKey("bbb", 20);
    
    HashMap map = new HashMap();
    map.put(mk1, "떡볶이"); 
    map.put(mk2, "족발");
    map.put(mk3, "보쌈");
    
    System.out.println(map.get(mk2));
    System.out.println(map.get(mk4)); 
    System.out.println("----------------------");
    
    // mk1, mk2, mk3, mk4 모두 같은 해시코드이고,
    // 내용에 상관없이 equals()의 리턴 값이 true이기 때문에
    // 모두 같은 키이다.
    // => 해시코드가 같고, equals()의 결과가 true라면 두 키는 같은 것은 취급한다. 
  }
}






