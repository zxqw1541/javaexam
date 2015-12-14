/*
 * 주제 : 문자 값 저장
 * - char(2) : 유니코드 문자표에 정의된 값을 담는다.
 */

package step01;

public class Exam09 {
  public static void main(String[] args) {
    
    // char 변수에는 16비트 유니코드 값을 저장해야 한다.
    // 유니코드 문자표에 정의된 한글 '가'의 정수 값은 0xAC00 이다.
    // 
    char c1 = 0xAC00;
    char c2 = 44032;
    
    // println()은 해당 숫자를 들고 유니코드 문자표를 조회한다.
    // 그리고 글자를 찾아 출력한다.
    System.out.println(c1);
    System.out.println(c2);
    
    // short(2)와 char(2)의 차이점?
    // - short: -32768 ~ 32767
    // - char : 0 ~ 65535
    
    short v1 = -32768;
    //char v2 = -32768; // 오류! 범위가 아니다.
    
    //short v3 = 65535; // 오류! 값의 범위를 넘었다.
    char v4 = 65535;
    
    // 문제? 문자 '헐' 유니코드 값을 저장하시오! 구글링 하시오!
    char v5 = 0xD5D0;
    System.out.println(v5);
    
    // 문자를 유니코드 값으로 변환해주는 기가막힌 도구를 소개한다.
    char v6 = '혱'; // 작은 따옴표를 사용하여 문자에 대한 유니코드 값을 알아낸다.
    System.out.println(v6);
    System.out.println((int)v6);
    System.out.println("----------------------------");
    // 응용
    char c;
    for (int i = 0 ; i < 100 ; i++) {
      //c = '가' + i; // int 값과 byte, short, char 값을 계산하면 int 값이 된다. 오류!
      c = (char)('가' + i); // 컴파일러에게 계산 결과가  char임을 알려준다.
      System.out.println(c);
    }
  }
}
