/*
 * 주제 : 기능 정의4
 * - function = method
 */

package step04;

public class Exam04 {
  
  //메서드 정의
  //return : 있음
  //parameter : 있음
  static String hello(String name) {
    return "안녕하세요. " + name + "님!";
  }
    
  public static void main(String[] args) {
    String str = hello("홍길동"); // 리턴 값을 받는 예.    
    System.out.println(str);
  }

}
