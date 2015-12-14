/*
 * 주제 : 자바 핵심 클래스 - Object (4)
 * - equals() : 인스턴스가 같은지 검사하는 메서드이다.
 */
package step06;

public class Exam09 /* extends Object */{
  
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
    
    @Override 
    public String toString() { 
      return "[" + this.name +"," + this.tel + "," 
          + (this.gender ? "여자" : "남자") + "]";
    }
    
    //Student의 값이 같을 때, true를 리턴하도록 equals()를 오버라이딩 하자!
    @Override
    public boolean equals(Object obj) {
      if (obj == null)
        return false;
      
      if (!(obj instanceof Student))
        return false;
      
      // obj에 들어 있는 주소가 Student의 주소이니,
      // 원래 타입의 래퍼런스로 만들어 사용한다.
      // 그래야 온전히 Student의 모든 기능을 이용할 수 있다.
      Student other = (Student) obj;
      
      if (!this.name.equals(other.name))
        return false;
      
      if (!this.tel.equals(other.tel))
        return false;
      
      if (this.gender != other.gender)
        return false;
      
      return true;
    }
  }
  
  public static void main(String[] args) {
    //Object의 메서드를 상속 받았다는 것을 확인
    Student s1 = new Student("홍길동", "111-111", false);
    Student s2 = new Student("홍길동", "111-111", false);
    Student s3 = new Student("홍길동", "111-111", true);
    
    if (s1.equals(s2))
      System.out.println("s1.equals(s2)");
    if (s1.equals(s3))
      System.out.println("s1.equals(s3)");
    System.out.println("----------------------------");
    
    String str1 = new String("Hello");
    String str2 = new String("Hello");
    
    // 인스턴스가 다름에도 불구하고 equals()를 true 리턴한다. 이유는?
    // => 상속 받은 equals()를 overriding 했기 때문이다.
    // => 문자열이 같으면 true를 리턴하도록 재정의 하였다.
    if (str1.equals(str2))
      System.out.println("str1.equals(str2)");
    System.out.println("----------------------------");
    
    StringBuffer sb1 = new StringBuffer("Hello");
    StringBuffer sb2 = new StringBuffer("Hello");
    
    // StringBuffer는 상속 받은 toString()을 overriding 하지 않았다.
    // 그래서 리턴 값이 false이다.
    if (sb1.equals(sb2))
      System.out.println("sb1.equals(sb2)");
    System.out.println("----------------------------");
    
    // 자바에서 제공해주는 클래스를 사용 할 때, equals()메서드의 재정의 여부 알아내기:
    // => API 문서의 메서드 목록에 상속받은 목록에 equals
  }
  
}
