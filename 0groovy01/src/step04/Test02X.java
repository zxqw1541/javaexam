package step04;

public class Test02X {
  
  interface GeneratedClosure {
    Object call(Object... args);
  }
  
  public static void main(String[] args) {
    Test02X p = new Test02X();
    p.run();
  }

  public Object run() {
    /*
    plus = { a, b

    println "111"
    println "222"
    println "333"
    
    a + b 
  }
  */
    GeneratedClosure plus = new GeneratedClosure() {
      public Object call(Object... args) {
        System.out.println("111");
        System.out.println("222");
        System.out.println("333");
        return (Integer)args[0] + (Integer)args[1];
      }
    };

    //println plus(10, 20)
    System.out.println(plus.call(10, 20));

    //println plus.getClass().getName()
    System.out.println(plus.getClass().getName());
    return null;
  }
  
  
}
