/*
 * 작업 목표:
 * - help 명령 처리: 다음과 같이 출력한다.
 * [사용법]
 * 명령  [옵션]
 * 
 * [명령]
 * list       학생 목록을 리턴한다.
 * add        학생을 추가한다.
 * delete     학생을 삭제한다.
 * quit       프로그램을 종료한다.
 * 
 * - help 명령을 처리하는 코드를 묶어서 유지보수 하기 좋도록 별도의 메서드로 분리하라!
 * - 명렁어 마다 그 명령어를  처리할 코드를 
 * 
 */
package step09.v04;

import java.util.Scanner;

public class ProjectApp {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String command = null;
    do {
      System.out.printf("명령> ");
      command = scanner.nextLine();
      switch (command) {
      case "list":
        doList();
        break;
      case "add":
        doAdd();
        break;
      case "delete":
        doDelete();
        break;
      case "help":
        doHelp();
        break;
      case "quit":
        doQuit();
        break;
      default:
        System.out.println("해당 명령어를 지원하지 않습니다!");
      }

    } while (!command.equals("quit"));
    System.out.println("안녕히가세요!");
    scanner.close();
  }
  
  private static void doList() {
    System.out.println("목록입니다.");
  }
  
  private static void doAdd() {
    System.out.println("추가입니다.");
  }
  
  private static void doDelete() {
    System.out.println("삭제입니다.");
  }
  
  private static void doQuit() {
  }
  
  private static void doHelp() {
    System.out.println("[사용법]");
    System.out.println("명령");
    System.out.println();
    System.out.println("[명령]");
    System.out.println("list       학생 목록을 리턴한다.");
    System.out.println("add        학생을 추가한다.");
    System.out.println("delete     학생을 삭제한다.");
    System.out.println("quit       프로그램을 종료한다.");
  }
}