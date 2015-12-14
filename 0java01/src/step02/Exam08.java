/*
 * 주제: 키보드로부터 입력을 받는 도구 사용 - Scanner 
 */
package step02;

import java.util.Scanner;

public class Exam08 {
  public static void main(String[] args) throws Exception {
    //1) 키보드 정보 얻기
    
    
    //2) Scanner 도구를 통해 키보드로 입력된 한 줄의 문자열 얻기
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    System.out.println(a);
    System.out.println(b);
  }
}








