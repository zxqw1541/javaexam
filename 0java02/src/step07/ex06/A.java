package step07.ex06;

public class A {
  int v1;
  {
    System.out.println("A 블록호출");
  }
  
  public A() {
//    super();<-- 자바 컴파일러가 자동 삽입 함.
    System.out.println("A() 호출됨.");
  }

}
