package step07.ex06;

public class B extends A{
  int v2;
  
  {
    System.out.println("B 블록호출");
  }
  
  public B() {
  //    super(); <-- 자바 컴파일러가 자동 삽입 함.
    System.out.println("B() 호출됨.");
  }
}
 