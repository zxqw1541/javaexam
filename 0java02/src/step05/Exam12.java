/*
 * 주제 : 인스턴스 블록
 */
package step05;

public class Exam12 {

  // 성적 정보를 다룰 특별한 데이터 타입을 정의한다.
  static class Score {
    
    // 초기화 문장: 변수 선언과 함께 값을 할당하는 문장.
    String name = "홍길동";
    int[] subjects;
    int sum = 100;
    float aver = 100.0f;

    //인스턴스 블록 실행 후 생성자 호출
    
    { //인스턴스 블록 : 인스턴스가 생성될 때마다 자동으로 실행하는 블럭
      // - 생성자와 달리 인스턴스 블록을 선택적으로 실행할 수 없다. 무조건 실행!
      // - 목적 : 인스턴스 변수를 사용하기 전에 적절한 유효한 값으로 초기화 시키는 용도
      //   => 생성자가 있는데? 평상 시에는 사용하지 않는다. 익명 클래스에서 주로 사용!
      System.out.println("인스턴스 블럭1");
    }
    
    public Score () {
      System.out.println("Score() 호출");
    }
    
    { 
      System.out.println("인스턴스 블럭2");
    }
    
    public Score (String name) {
      this.name = name;
    }
    
  }
  
    
  public static void main(String[] args) {
    
    new Score();
    // 인스턴스 생성 시 변수 초기화 순서
    // 1) 모든 변수는 0비트로 초기화 된다.
    //    - 정수(byte, short, char, int, long) : 0
    //    - 실수(float, double) : 0.0
    //    - 논리(boolean) : false
    //    - 레퍼런스 : null
    // 2) 초기화 수행문이 실행된다.
    // 3) 생성자 실행된다.
    
    // Score 인스턴스의 예: name, subjects, sum, aver
    // null,     0,    0,    0,    0,    0,    0,    0.0 // 인스턴스 생성 직후
    // "홍길동",   0,    0,    0,    0,    0,  100,  100.0 // 초기화 문장 실행 후
    // "임꺽정", 100,   90,   80,   70,   60,  100,  100.0 // 생성자 실행 후
    
    
    
    
    
  }
}
