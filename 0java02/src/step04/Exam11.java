/*
 * 주제 : 가비지(garbage)와 가비지 컬렉터(garbage collector)
 */
package step04;

public class Exam11 {

  static class Score {
    String name;
    int[] subjects = new int[5];
    int sum;
    float aver;
  }
  
  
  public static void main(String[] args) {
    Score v1 = new Score();
    Score v2 = new Score();
    Score v3 = v1;
    
    v2 = v1; // v2가 가리키던 인스턴스의 주소는 잃어버린다.
             // 즉 사용할 수 없는 인스턴스가 된다. => "garbage"
    
    //garbage? == dangling object
    // - 참조하는 레퍼런스가 단 한 개도 존재하지 않는 인스턴스를 말한다.
    // - 즉 사용할 수 없는 상태. => 그냥 메모리만 점유하고있는 상태. => 낭비되고 있는 상태.
    // - JVM은 "garbage collector"를 통해서 다음 규칙에 따라 가비지를 제거한다.
    //   => 다시 그 메모리를 사용할 수 있는 상태로 만든다.
    //   1) 메모리가 부족할 때,
    //   2) CPU가 한가할 때(idle time)
    
    /*
     * 참고 : dangling pointer?
     * - 무효한 인스턴스를 가리키는 경우.
     */
    
    
    // 인스턴스 생성
    // => Score 클래스에 선언된 메모리가 준비된다.
    // => 인스턴스의 모든 변수는 0으로 자동 초기화 된다.
    // => 인스턴스 생성 후 리턴 값은 그 메모리의 시작 주소이다.
    // => 이렇게 생성된 인스턴스 메모리를 나중에 사용하려면
    //    인스턴스 주소값을 변수에 보관해야 한다.
    new Score(); // 이 인스턴스를 주소를 보관하지 않았기 때문에 나중에 사용할 수 없다.
    v1 = new Score(); // 이 인스턴스의 주소는 v1 변수에 보관되어 있다.
    
    // 주소를 이용하여 인스턴스 변수에 값을 보관할 수 있다.
    v1.name = "홍길동"; // v1에 보관된 주소로 찾아가서 그 메모리의 name 변수에 값을 할당.
    
    //v2.name = "오호라"; // 컴파일할 때는 오류가 발생하지 않는다. 실행할 때 오류 발생!
    
    // 레퍼런스 변수 활용
    v3 = v1;
    
    v3.name = "임꺽정";
    System.out.println(v1.name);
    
  }
}

/*
 * Class 용도
 * 1) 사용자 정의 데이터 타입 
 * 2) 메서드 분류
 * 1) 2) 를 하는 문법
 */

