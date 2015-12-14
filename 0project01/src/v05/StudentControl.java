package v05;

import java.util.HashMap;
import java.util.Scanner;

import v05.command.StudentAddCommand;
import v05.command.StudentDeleteCommand;
import v05.command.StudentHelpCommand;
import v05.command.StudentListCommand;

public class StudentControl extends StorageMenuControl<Student> {
  StudentListCommand listHandler = new StudentListCommand();
  StudentAddCommand addHandler = new StudentAddCommand();
  StudentDeleteCommand deleteHandler = new StudentDeleteCommand();
  StudentHelpCommand helpHandler = new StudentHelpCommand();
  
  public StudentControl (Scanner scanner) {
    super(scanner);
  }
  
  public void service() {
    String command = null;
    
    HashMap<String, Object> params = new HashMap<String, Object>();

    do {
      System.out.print("학생관리> ");
      command = scanner.nextLine();
      switch (command) {
      case "list":
        listHandler.execute(params);
        break;
      case "add":
        addHandler.execute(params);
        break;
      case "delete":
        deleteHandler.execute(params);
        break;
      case "help":
        helpHandler.execute(params);
        break;
      case "main":
        return;
      default:
        System.out.println("해당 명령을 지원하지 않습니다.");
      }
    } while (!command.equals("quit"));
  }
}
