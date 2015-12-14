/*
 * 주제 : 자바 핵심 클래스 - String (1)
 */
package step06;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Exam03 {

  public static void main(String[] args) {
    String s1 = new String("hello");

    // immutable: 값을 바꿀 수 없다.
    // => String 인스턴스는 한 번 생성되면 값을 바꿀 수 없다.
    // => immutable 객체라 부른다.
    // 예)
    String s2 = s1.replace('l', 'x');
    System.out.println(s1);
    // replace(): 기존의 문자열을 바꾸는 것이 아니라, 새로운 문자열 인스턴스를 생성한다.
    System.out.println(s2);

    // 자주 사용하는 문자열 메서드
    String s3 = s1.substring(2); // 2번 문자부터 끝가지 추출하여 새로 인스턴스를 만든다.
    System.out.println(s3);

    String s4 = s1.substring(1, 3); // 1<= x < 3
    System.out.println(s4);

    // 특정 문자의 위치 알아내기 => 첫 번째 찾은 문자의 위치
    System.out.println(s1.indexOf('e'));
    System.out.println(s1.indexOf('l'));

    System.out.println(s1.lastIndexOf('l')); // 끝에서부터 찾는다.

    // 퀴즈?
    // - 스캐너로부터 한 줄 입력 받는다.
    // - 해당 문자열이 이메일인지 확인한다.
    System.out.print(">");
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    scanner.close();

    int at = str.indexOf('@');
    int dot = str.lastIndexOf('.');
    String cutStr = str.substring(at);
    int nextDot = cutStr.indexOf('.');

    /*
    if (at > 0) {
      if (dot - at > 1) {
        if (str.length() - dot > 0)
          if (nextDot > 1) {
            System.out.println("true");
          } else {
            System.out.println("false");
          } else
          System.out.println("false");
      } else
        System.out.println("false");
    } else
      System.out.println("false");
    */
    // 정규 표현식을 이용하여 이메일을 검사하라!
    //?
    String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
    
    boolean tf = Pattern.matches(regex, str);
    if (tf) 
      System.out.println("email");
    else
      System.out.println("not email");

  }
}