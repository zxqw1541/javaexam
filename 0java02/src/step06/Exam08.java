/*
 * 주제 : 자바 핵심 클래스 - Object (3)
 */
package step06;

public class Exam08 /* extends Object */{
  
  static class Student /* extends Object */{
    String  name;
    String  tel;
    boolean gender;
    
    //생성자가 하나라도 있으면 JVM이 기본생성자(default constructor)를 만들지 않는다.
    public Student(String name, String tel, boolean gender) {
      this.name = name;
      this.tel = tel;
      this.gender = gender;
    }
    
    //Object로부터 상속 받은 toString()를 재정의한다. => overriding
    //=> overriding 규칙 : 메서드 시그너처가 같아야 한다.
    // 
    //"메서드 시그너처(signature)"? == function prototype(c/c++ 언어)
    //=> 리턴타입, 메서드명, 파라미터 타입과 개수을 말한다.
    //=> 단, 파라미터의 변수명은 달라도 된다. 상관없다.
    //
    //오버라이딩 한다고해놓고 다음과같이 메서드명에 오타를 넣음으로써 
    //오버라이딩을 한 것이 아니라 toSting()이라는 메서드를 추가한 것이 되는 경우가 있다.
    //이런 오류는 문버 오류가 아니기 때문에 컴파일러에서 잡아 낼 수 없다.
    //이런 오류를 방지하기위한 방법  => 애노테이션(annotation)
    // "애노테이션"이란?
    //컴파일러나 JVM에게 전달하는 아주 특별한 주석, 명령, 정보를 말한다.
    @Override // 자바 컴파일러에게 오버라이드 검사를 요청하는 주석이다.
    public String toString() { //메서드명이 잘못되면 컴파일러가 오류를 띄운다.
      return "[" + this.name +"," + this.tel + "," 
          + (this.gender ? "여자" : "남자") + "]";
    }
    
    //(Server Application + let = servlet)
    //애노테이션의 원류? doclet(작은 문서 조각) 
    
  }
  
  public static void main(String[] args) {
    //Object의 메서드를 상속 받았다는 것을 확인
    Student s1 = new Student("홍길동", "111-111", false);
    Student s2 = new Student("홍길동", "111-111", false);
    
    System.out.println(s1.toString());
    System.out.println(s2.toString());
  }
  
  // 용어정리 
  // parent(super) / child(sub)
  // 수퍼 클래스(부모 클래스) : super class, parent class
  // => 어떤 클래스의 상위 클래스를 말한다.
  // 서브 클래스(자식 클래스): sub class, child class
  // => 어떤 클래스의 하위 클래스를 말한다.
  
  //알았다 할수있다.
}
