package step07.ex10;

import step07.ex09.Calculator4;

public class Calculator5 extends Calculator4 {
  @Override
  public void print() {
    
    System.out.println("******************************");
    //재정의 하기 전에 메서드를 호출하기
    //super는 부모 클래스를 가리키는 것이 아니다. 주의!
    //재정의 하기 바로 직전의 메서드를 가리킨다. super.super.test1()이런거 안됨. 있어봤자 혼란만 가중시킴.
    super.print();
    System.out.println("******************************");
  }

}
