/*
 * 작업 목표: delete : 회원을 삭제하는 명령어
회원 번호? 1
정말 삭제하시겠습니까? (y/n) y
삭제되었습니다.
정말 삭제하시겠습니까? (y/n) n
취소하였습니다.
 */
package step09.v07;

import java.util.Scanner;

public class ProjectApp02 {
  Scanner scanner = new Scanner(System.in);
  Student[] students = new Student[1000];
  int pos; // 저장 위치
  
  public static void main(String[] args) {
    ProjectApp02 app = new ProjectApp02();
    app.service();
  }
  
  private void service() {
    String command = null;
    do {
      System.out.printf("명령> ");
      command = scanner.nextLine();
      switch (command) {
      case "list":
        doList(); //this.를 붙이는게 원칙
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
  
  private void doList() {
    for (int i = 0; i < pos; i++) {
      System.out.printf("%d %s %s %s %s\n", 
          i, 
          students[i].name,
          students[i].email,
          students[i].tel,
          students[i].cId);
    }
  }
  
  private void doAdd() {
    Student student = new Student();
    System.out.print("이름? ");
    student.setName(scanner.nextLine());
    
    System.out.print("이메일? ");
    student.setEmail(scanner.nextLine());
    
    System.out.print("전화? ");
    student.setTel(scanner.nextLine());
    
    System.out.print("기수? ");
    student.setcId(scanner.nextLine());
    
    System.out.print("정말 저장하시겠습니까? (y/n) ");
    String yesno = scanner.nextLine();
    
    if (yesno.toLowerCase().equals("y")) {
      if (pos < students.length) {
        students[pos++] = student;
        System.out.println("저장되었습니다.");
      } else {
        System.out.println("저장소가 모두 찼습니다. \n저장할 수 없습니다.");
      }
    } else {
      System.out.println("취소하였습니다.");
    }
    
    
  }
  
  private void doDelete() {
    System.out.print("회원 번호 ? ");
    int del = scanner.nextInt();
    scanner.nextLine();

    System.out.print("정말 삭제하시겠습니까? (y/n) ");
    String yesno = scanner.nextLine();
    if (yesno.toLowerCase().equals("y")) {
      if(del > -1 && del < pos) {
        for(int i = del; i < pos-1; i++) {
          students[i] = students[i+1];
        }
        pos--;
        System.out.println("삭제하였습니다.");
      } else {
        System.out.println("유효하지 않은 번호입니다.");
      }
      
    } else {
      System.out.println("취소하였습니다.");
    }
  }
  
  private void doQuit() {
  }
  
  private void doHelp() {
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