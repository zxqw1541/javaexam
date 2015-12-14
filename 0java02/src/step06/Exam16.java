/*
 * 주제 : 자바 핵심 클래스 - Date (2)
 * -       
 */
package step06;

import java.util.Calendar;

public class Exam16 {
  //여러 메서드에서 상수를 사용하고 싶다면, 클래스 변수로 만들라!
  static final int YEAR = 1;
  static final int MONTH = 2;
  static final int DAY_OF_MONTH = 4;
  static final int HOUR = 10;
  static final int MINUTE = 12;
  static final int SECONDS = 13;
  
  
  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    
    System.out.println(cal.get(YEAR));
    System.out.println(cal.get(MONTH) + 1); 
    System.out.println(cal.get(DAY_OF_MONTH));
    System.out.println(cal.get(HOUR));
    System.out.println(cal.get(MINUTE));
    System.out.println(cal.get(SECONDS));
    System.out.println();
  }
  
  public static void printYear() {
    Calendar cal = Calendar.getInstance();
    System.out.println(cal.get(YEAR));
  }
}