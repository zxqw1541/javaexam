package step07.ex09;

import step07.ex05.Calculator3;

public class Calculator4 extends Calculator3 {

  // 이름이 같지만 타입이타입이 다른 메서드 추가
  // - 파라미터의 타입과 개수가 다르더라고, 같은 기능을 수행하면
  //   같은 이름을 부여함으로써 프로그래밍의 일관성을 부여하는 방법
  // - 같은 클래스의 메서드이든 상속 받은 메서드이든 상관없다.
  public void plus(float value) {
    this.result += Math.round(value);    
  }
  
  public void print() {
    System.out.printf("결과: %d\n", this.result);
  }
}
