/*
 * 주제 : 반복문 - while, do ~ while
 */
package step03;

public class Exam05 {
  public static void main(String[] args) {

    int count = 10;
    
    while (count < 10)
      System.out.println(count++);
    
    System.out.println("-----------------");
    
    count = 10;
    do
      System.out.println(count++);
    while (count < 10);
  }
}
