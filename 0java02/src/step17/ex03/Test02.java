/*
 * 스레드 동기화 적용 후
 * => 뮤텍스 적용. 한 번에 한 스레드만이 접근하도록 만든다.
 */
package step17.ex03;

public class Test02 {
  static class Account {
    String  accId;
    long    balance;
    
    // 메서드에 동기화 적용하기
    // => 작업한 값이 일치하게 만든다. => 동기화
    // => synchronized를 붙이면 해당 블록은 한 스레드만이 접근할 수 있다.
    //    만약 어떤 스레드가 해당 블록에 진입했다면, 그 스레드가 나올 때까지
    //    다른 스레드는 기다려야 한다.
    synchronized public long withdraw(long money) {
      long temp = balance - money;
      
      delay();
      
      if (temp < 0)
        return 0;
      
      delay();
      
      this.balance = temp;
      
      delay();
      
      return money;
    }
    
    // 크리티컬 섹션(Critical Section)
    // => 여러 스레드가 동시에 접근했을 때 문제가 발생할 수 있는 코드
    // => 해결책? 한 번에 한 스레드만이 접근하도록 제약을 가한다.
    //          "뮤텍스(MUTual EXclustion)"라 부른다.
    private void delay() {
      // 시간 지연 효과 얻기 => CPU를 많이 사용하기
      // 1) 8바이트 크기의 데이터를 다루는 것이 4바이트를 다루는 것보다 느리다.
      //    자바는 기본이 4바이트이다.
      // 2) 정수 보다 부동소수점을 다루는 것이 더 시간을 소요한다.
      double d1 = 3.14, d2 = 2.1234567;
      double d3 = d1 / d2;
      
      for (int i = 0; i < 1000; i++) {
        d3 /= 2.345;
      }
    }
  }
  
  static class Atm365 extends Thread {
    Account account;
    public Atm365(String name, Account account) {
      super(name);
      this.account = account;
    }
    
    
    @Override
    public void run() {
      long sum = 0;
      long money = 0;
      
      while (true) {
        money = account.withdraw(100);
        if (money == 0)
          break;
        
        sum += money;
      }
      System.out.printf("%s = %d\n", this.getName(), sum);
    }
  }
  public static void main(String[] args) {
    Account account = new Account();
    account.accId = "111-11-11111";
    account.balance = 10000;
    
    Atm365 t1 = new Atm365("강남", account);
    Atm365 t2 = new Atm365("양재", account);
    Atm365 t3 = new Atm365("논현", account);
    Atm365 t4 = new Atm365("종로", account);

    
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    
    
    
  }

}
