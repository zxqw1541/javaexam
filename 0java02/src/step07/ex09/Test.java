/*
 * 주제 : 다형성(polymorphism) - 오버로딩(overloading) 
 * - 파라미터의 타입과 개수는 다르지만 기능은 같은 메서드 추가하기
 * 
 */
package step07.ex09;

public class Test {
  public static void main(String[] args) {
    
    Calculator4 cal = new Calculator4();
    cal.plus(10);
    cal.plus(7.2f); // Calculator2.plus(int) 호출됨. result = 17
    cal.plus(3.5f); // Calculator4.plus(double) 호출됨. result = 21 (반올림 했다)
    cal.print();
    
  }
  
}
