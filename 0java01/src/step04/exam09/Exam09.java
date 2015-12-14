/*
 * 주제 : 인스턴스 변수의 사용
 * - 개별적으로 값을 관리해야 한다면 인스턴스 변수에 저장하라.
 */
package step04.exam09;

public class Exam09 {

  public static void main(String[] args) {
    //계산1 : 2 + 5 * 3 - 1
    //계산2 : 5 - 3 / 2 * 7
    //조건 : 연산자 우선 순위 적용하지 않음. 그냥 순서대로 처리할 것.
    //문제점 : 두 계산을 다음과 같이 동시에 수행할 수 없다.
    //       => result 변수를 공유하기 때문이다.
    //해결책 : 계산1과 계산2에 대해 result 변수를 개별적으로 관리 해야 한다.
    //       => Calculator2 클래스를 보라!
    
    
    Calculator.plus(2);
    Calculator.plus(5);
    
    Calculator.plus(5);
    Calculator.minus(3);
    
    Calculator.multiple(3);
    Calculator.divide(2);
    
    Calculator.minus(1);
    Calculator.multiple(7);
    
    System.out.println(Calculator.result);
    
    
    //Calculator2 사용 
    // 계산1을 위한 메모리 준비
    // new 명령의 의미?
    // => Calculator2에 선언된 변수 중에서 
    //    개별적으로 관리 되어야 할 변수(static이 붙지 않은 변수)를 준비하라!
    Calculator2 calc1 = new Calculator2();
    
    // 계산2를 위한 메모리 준비
    Calculator2 calc2 = new Calculator2();
    
    // 계산을 수행할 때 어떤 result 변수를 사용할 것인지 알려줘야 한다.
    Calculator2.plus(calc1, 2);
    Calculator2.plus(calc2, 5);
    
    Calculator2.plus(calc1, 5);
    Calculator2.minus(calc2, 3);
    
    Calculator2.multiple(calc1, 3);
    Calculator2.divide(calc2, 2);
    
    Calculator2.minus(calc1, 1);
    Calculator2.multiple(calc2, 7);
    
    System.out.println(calc1.result);
    System.out.println(calc2.result);
    
    //  Calculator3 사용 
    Calculator3 calc3, calc4; 
    calc3 = new Calculator3();
    calc4 = new Calculator3();

    // 인스턴스를 메서드 앞에 두고 싶으면, 메서드 선언에 static을 붙이지 말아야 한다.
    // => 인스턴스 메서드
    calc3.plus(2);
    calc4.plus(5);
    
    calc3.plus(5);
    calc4.minus(3);
    
    calc3.multiple(3);
    calc4.divide(2);
    
    calc3.minus(1);
    calc4.multiple(7);
    
    System.out.println(calc3.result);
    System.out.println(calc4.result);
  }

}
