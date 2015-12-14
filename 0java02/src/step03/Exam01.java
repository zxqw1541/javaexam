/*
 * 주제 : 조건문
 */
package step03;

public class Exam01 {
  public static void main(String[] args) {

    // 1) if 만 사용하는 예
    int a = 30;
    if (a >= 19)
      System.out.println("성인");
    if (a < 19)
      System.out.println("미성년자");

    System.out.println();

    // 2) if ~ else : 앞의 조건이 참일 때 뒤의 조건을 검사하지 않는다.
    // if 만 쓰는 경우보다 속도가 빠르다
    if (a >= 19)
      System.out.println("성인");
    else
      System.out.println("미성년자");

    System.out.println();

  }
}
