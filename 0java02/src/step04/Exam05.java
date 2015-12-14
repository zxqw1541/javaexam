/*
 * 주제 : 다차원 배열
 */
package step04;

public class Exam05 {
  static int v1;
  int v2; //인스턴스 변수는 인스턴스와 함꼐 쓰여야한다.

  public static void main(String[] args) {
    
    int[][] scores = new int[3][7];    
    
    //홍길동 점수 초기화
    scores[0][0] = 100;
    scores[0][1] = 100;
    scores[0][2] = 100;
    scores[0][3] = 100;
    scores[0][4] = 100;
    
    //임꺾정 점수 초기화
    scores[1][0] = 100;
    scores[1][1] = 100;
    scores[1][2] = 100;
    scores[1][3] = 100;
    scores[1][4] = 100;  
    
    //신채호 점수 초기화
    scores[2][0] = 100;
    scores[2][1] = 100;
    scores[2][2] = 100;
    scores[2][3] = 100;
    scores[2][4] = 100;  
   
    
    
  }

}
