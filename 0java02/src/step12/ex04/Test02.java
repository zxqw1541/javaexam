package step12.ex04;

public class Test02 {

  // value 프로퍼티
  static @interface MyAnno {
    // => 애노테이션에 저장할 프로퍼티를 선언한다. => 메서드 형태로 선언한다.
    String value();
  }
  
  //예1:
  @MyAnno(
    //애노테이션 프로퍼티 값 설정 => 프로퍼티명=값
    value="테스트"
  )
  static class MyClass {}
  
  
  //예2:
  //=> 프로퍼티명이 "value"인 경우, 프로퍼티명을 생략하고 값만 지정할 수 있다. 
  @MyAnno("테스트")
  static class MyClass2 {}
  
  public static void main(String[] args) {
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
