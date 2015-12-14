package step12.ex02;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test06 {
  static class Student {
    String name;
    String tel;
    
    @Override
    public String toString() {
      return "Student [name=" + name + ", tel=" + tel + "]";
    }
    
    public void m1() {
      System.out.println("m1()");
    }
    
    public void m1(String name) {
      System.out.printf("m1(%s)\n", name);
    }
    
    public void m1(String name, int age) {
      System.out.printf("m1(%s,%d)\n", name, age);
    }
    
  }
  
  public static void main(String[] args) throws Exception {
    Class clazz = Student.class;
    
    Method p1 = clazz.getMethod("m1");
    Method p2 = clazz.getMethod("m1", String.class);
    Method p3 = clazz.getMethod("m1", String.class, int.class);
    
    Student s1 = new Student();
    
    //p1.invoke(null, "홍길동"); // 오류! 아규먼트를 넘길 수 없는 메서드이다. 
    p1.invoke(s1);
    p2.invoke(s1, "홍길동");
    p3.invoke(s1, "홍길동", 0);
  }
  
}
