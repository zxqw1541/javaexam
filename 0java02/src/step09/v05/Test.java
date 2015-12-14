/*
 * 주제 : 스태틱 메서드는 왜 인스턴스 변수에 접근할 수 없는가?
 * - 스태틱 메서드는 this 내장 변수가 없다.
 * - 인스턴스 변수나 메서드를 사용하려면 반드시 this 내장 변수가 있어야 한다!!!
 */
package step09.v05;

public class Test {
  public static void main(String[] args) {
    A.m1(); // 클래스 메서드를 직접 호출한다면, m1()에서 b변수는 어떤 인스턴스의 것인가?
    
  }
  
  static class A {
    static int a;
    int b; // 인스턴스가 생성되야 사용 가능
    
    static void m1() {
      A.a = 20; //(A. 생략 가능)
      //b = 20; // 왜 접근할 수 없는가? (static 메서드는 this가 없다.)
    }
    
    void m2() {
      A.a = 20; // 클래스 변수는 클래스 이름을 줘야하고
      this.b = 20; // 인스턴스 변수는 인스턴스 주소가 담겨있는 this가 있어야 한다.
      // 코딩의 편의성을 위해서 같은 클래스 안에 클래스는 변수는 클래스명 생략
    }
  }


}
