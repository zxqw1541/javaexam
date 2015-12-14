/*
 * 주제 : 변수의 초기화
 */
package step04;

public class Exam04 {
  static int v1;
  int v2; //인스턴스 변수는 인스턴스와 함꼐 쓰여야한다.

  public static void main(String[] args) {
    Exam04 p = new Exam04();
    int v3;
    
    System.out.println(v1); // 클래스 변수는 자동으로 0으로 초기화 된다.
    System.out.println(p.v2); // 인스턴스 변수도 자동으로 0으로 초기화 된다.
    //System.out.println(v3); // 오류! 로컬 변수는 반드시 초기화 시킨 후 사용하여야 한다.
    
    // 로컬 변수는 사용하기 전에 초기화 시켜야 한다.
    // - 배열은 생성하는 순간 자동으로 0으로 초기화 된다.
    int[][] scores = new int[3][7];    
    System.out.println(scores[0][0]);
    
    
    
    
  }

}
