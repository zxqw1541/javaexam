package step09.v08;

import java.sql.Date;
import java.util.Scanner;

public class ProjectApp {
  Scanner scanner = new Scanner(System.in);
  Project[] projects = new Project[1000];
  int pos;

  public static void main(String[] args) {
    ProjectApp app = new ProjectApp();
    app.service();
  }

  private void service() {
    String command = null;

    do {
      System.out.print("명령> ");
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
      case "quit":
        doQuit();
        break;
      default:
        System.out.println("해당 명령을 지원하지 않습니다.");
      }
    } while (!command.equals("quit"));

    System.out.println("안녕히가세요!");
    scanner.close();
  }

  private void doAdd() {
    Project project = new Project();

    System.out.print("프로젝트명? ");
    project.setName(scanner.nextLine());

    System.out.print("시작일? ");
    project.setStartDate(Date.valueOf(scanner.nextLine()));

    System.out.print("종료일? ");
    project.setEndDate(Date.valueOf(scanner.nextLine()));

    System.out.print("멤버? ");
    project.setMember(scanner.nextLine());

    System.out.print("정말 저장하시겠습니까?(y/n)");
    String yesno = scanner.nextLine();
    if (yesno.toLowerCase().equals("y")) {
      if (pos < projects.length) {
        projects[pos++] = project;
        System.out.println("저장되었습니다.");
      } else {
        System.out.println("저장소가 모두 찼습니다.\n저장할 수 없습니다!");
      }
    } else {
      System.out.println("취소하였습니다.");
    }
  }

  private void doList() {
    String format = "% 3d\t%-16s%s\t%s\t%s\n";
    System.out.printf("번호\t프로젝트명\t\t시작일\t\t종료일\t\t멤버\n");
    for (int i = 0; i < pos; i++) {
      System.out.printf(format,
          i, projects[i].name, projects[i].startDate, projects[i].endDate,
          projects[i].member);
    }

  }

  private void doDelete() {
    System.out.print("프로젝트 번호? ");
    int no = Integer.parseInt(scanner.nextLine());

    System.out.print("정말 삭제하시겠습니까?(y/n)");
    String yesno = scanner.nextLine();
    if (yesno.toLowerCase().equals("y")) {
      if (no > -1 && no < pos) {
        for (int i = no; i < pos - 1; i++) {
          projects[i] = projects[i + 1];
        }
        pos--;
        System.out.println("삭제 되었습니다.");
      } else {
        System.out.println("유효하지 않은 번호입니다.");
      }
    } else {
      System.out.println("취소하였습니다.");
    }
  }

  private void doQuit() {

  }

}
