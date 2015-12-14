package step17.ex02;

public class Test02 {
  // 스레드 정의 2 - Runnable 인터페이스 구현하기
  // => Thread가 실행할 코드를 갖고 있는 객체!
  static class MyRunnable implements Runnable {
    String name;
    
    public MyRunnable(String name) {
      this.name = name;
    }

    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        System.out.println(this.name + ":" + i);
      }
    }
  }

  public static void main(String[] args) {
    MyRunnable r = new MyRunnable("t1");
    Thread t1 = new Thread(r);
    
    //=> 스레드 시작 => Thread에 장착된
    t1.start(); 
    // CPU 사용권을 얻기 위해 대기하는 상태로 들어간다. "Runnable" 상태
    // Runnable 상태로 보낸 후 즉시 리턴한다. => 다음 문장으로 바로 간다.
    
    System.out.println("***************************");
    
    // main 스레드가  main() 호출을 끝냈다 하더라도, 
    // 자식 스레드가 실행 중이면 JVM을 종료하지 않는다.

  }

}
