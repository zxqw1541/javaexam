/*
 * 주제 : 배열 전용 반복문
 * - for(변수 : 배열) {...}
 */
package step04;

public class Exam03 {

  public static void main(String[] args) {
    
    int[] sub = {100, 90, 100, 90, 100, 0, 0}; 
    
    
    
    // 특정 범위만 반복할 때는 다음 방식이 더 낫다.
    for (int i = 0; i < 5; i++){
      sub[5] += sub[i];
    }
    
    sub[6] = sub[5] / 5;
    //sub[7] = 100; // 컴파일 할 때 오류가 발생하지 않지만, 실행할 때 인덱스 범위 오류가 발생!
    
    // 이 방식은 배열의 시작에서 끝까지 반복한다.
    // 반복할 때 마다 배열에서 한 개의 값을 꺼네 value
    for (int value : sub) {
      System.out.println(value);
    }
    
    
    
    
  }

}
