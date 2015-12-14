/*
 * 주제 : 자바 핵심 클래스 - 랩퍼 클래스 (2)
 * - auto-boxing : 원시 타입 --> 랩퍼 객체로, 랩퍼 객체 --> 원시 타입 자동 변환
 */
package step06;

public class Exam13 {
  
  public static void main(String[] args) {
    int i = 20;
    Integer obj = new Integer(30);
    
    //1) unboxing: 랩퍼 클래스 ---> 원시 타입
    int i2 = obj; // 내부적으로 obj.intValue()를 자동 호출한다. 다음 코드와 같다.
    //int i2 = obj.intValue();
    System.out.println(i2);    
    // 이렇게 인스턴스 안에 들어 있던 값을 꺼내서 i2 변수에 담는다고 해서 
    // "unboxing"이라고 부른다. 
    
    //2) boxing : 원시 타입 ---> 랩퍼 클래스
    Integer obj2 = i; // 내부적으로 new Integer(i)로 바꾼다. 즉 다음 코드와 같다.
    //Integer obj2 = new Integer(i);
    // 이렇게 원시 타입의 값을 랩퍼 클래스의 인스턴스로 포장한다고 해서,
    //"boxing"이라고 부른다.
    
    // 오토박싱(autoboxing)?
    // 원시 타입과 랩퍼 클래스 사이에 자동으로 boxing/unboxing이 일어난다.
  }
}