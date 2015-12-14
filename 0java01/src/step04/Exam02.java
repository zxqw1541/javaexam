/*
 * 주제 : 기능 정의2
 * - function = method
 */

package step04;

public class Exam02 {
  
  //1) 메서드 정의
  // 
  //return : void
  //parameter : 있음
  //parameter? 값을 받는 변수(메모리)를 가리킨다.
  static void hello(String name) {
    System.out.println("안녕하세요." + name + "님");
  }
    
  public static void main(String[] args) {
    hello("홍길동");//메서드 호출
    //"홍길동" - 메서드 호출할 때 넘기는 값 => argument
  }

}
