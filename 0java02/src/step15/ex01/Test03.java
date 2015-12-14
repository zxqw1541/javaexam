package step15.ex01;

public class Test03 {
  public static void main(String[] args) {
    // 예외 정보를 받기
    // => 예외를 던질 수 있는 메서드를 호출할 때는 try 블록안에서 호출하라!
    // => 그리고 catch 블록에서 예외를 받아서 처리하라!

    try {
      compute();
      
    } catch (Throwable err) {
      System.out.println("예외 발생:");
      System.out.println(err.getMessage());
    }

  }
  
  // compute() 안에서 발생한 예외를 compute()에서 처리하지 않고,
  // 상위 호출자에게 패스하는 기법
  public static void compute() throws Throwable {
    int result = 0;
    result = Calculator2.plus(10, 20);
    result = Calculator2.multiple(result, 2);
    result = Calculator2.divide(result, 0);
    System.out.printf("결과 = %d\n", result);
  }
  

}
