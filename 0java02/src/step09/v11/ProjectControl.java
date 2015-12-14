package step09.v11;

import java.sql.Date;
import java.util.Scanner;

import step10.ex01.LinkedList;

public class ProjectControl {
  Scanner scanner;
  LinkedList projects = new LinkedList();

  public ProjectControl(Scanner scanner) {
    this.scanner = scanner;
  }

  public void service() {
    String command = null;
    do {
      System.out.print("프로젝트 관리> ");
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
      case "main":
        return;
      default:
        System.out.println("해당 명령을 지원하지 않습니다.");
      }
    } while (!command.equals("quit"));
  }

  private void doList() {
    System.out.printf("%-3s %-20s %-10s %-10s %-40s\n", "No", "Title", "Start", "End", "Members");

    Project project = null;
    for (int i = 0; i < projects.size(); i++) {
      project = (Project) projects.get(i);
      if (project == null) // 배열의 항목이 null인 경우, 다음 항목으로 바로 이동.
        continue;
      System.out.printf("% 3d %-20s %3$tY-%3$tm-%3$td %4$s %5$-40s\n", i, project.getTitle(), project.getStartDate(),
          project.getEndDate(), project.getMember());
    }
  }

  private void doAdd() {
    Project project = new Project();

    System.out.print("프로젝트명? ");
    project.setTitle(scanner.nextLine());

    System.out.print("시작일? ");
    project.setStartDate(Date.valueOf(scanner.nextLine()));

    System.out.print("종료일? ");
    project.setEndDate(Date.valueOf(scanner.nextLine()));

    System.out.print("멤버? ");
    project.setMember(scanner.nextLine());

    System.out.print("정말 저장하시겠습니까?(y/n)");
    String yesno = scanner.nextLine();
    if (yesno.toLowerCase().equals("y")) {
      if (projects.add(project) == 0) {
        System.out.println("저장되었습니다.");
      } else {
        System.out.println("저장소가 모두 찼습니다.\n저장할 수 없습니다!");
      }
    } else {
      System.out.println("취소하였습니다.");
    }
  }

  private void doDelete() {
    System.out.print("프로젝트 번호? ");
    int no = Integer.parseInt(scanner.nextLine());

    System.out.print("정말 삭제하시겠습니까?(y/n)");
    String yesno = scanner.nextLine();
    
    if (yesno.toLowerCase().equals("y")) {
      if (projects.remove(no) != null) {
        System.out.println("삭제하였습니다.");
      } else {
        System.out.println("유효하지 않은 번호입니다.");
      }
    } else {
      System.out.println("취소하였습니다.");
    }
  }

  private void doHelp() {
    System.out.println("[사용법]");
    System.out.println("명령");
    System.out.println();
    System.out.println("[명령]");
    System.out.println("list         프로젝트 목록을 리턴한다.");
    System.out.println("add          프로젝트를 추가한다.");
    System.out.println("delete       프로젝트를 삭제한다. ");
    System.out.println("main         메인으로 이동한다.");
  }
}
