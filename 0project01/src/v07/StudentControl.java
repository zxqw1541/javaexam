package v07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import v07.command.StudentDeleteCommand;
import v07.command.StudentAddCommand;
import v07.command.StudentHelpCommand;
import v07.command.StudentListCommand;

public class StudentControl extends StorageMenuControl<Student> {
  StudentListCommand listHandler = new StudentListCommand();
  StudentAddCommand addHandler = new StudentAddCommand();
  StudentDeleteCommand deleteHandler = new StudentDeleteCommand();
  StudentHelpCommand helpHandler = new StudentHelpCommand();

  public StudentControl() throws Exception {
    String filename = "./data/student.dat";
    FileReader in = new FileReader(filename);
    BufferedReader in2 = new BufferedReader(in);
    
    String line = null;
    
    while ((line = in2.readLine()) != null) {
      list.add(new Student(line));
    }
    in2.close();
    in.close();
  }
  
  public StudentControl(Scanner scanner) {
    super(scanner);
  }
  
  public void service() {
    String command = null;
    
    HashMap<String,Object> params = new HashMap<String,Object>();
    params.put("list", list);
    params.put("scanner", scanner);
    
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
      case "main":
        try {
          save();
        } catch (Exception e) {
          System.out.println("저장 실패!");
        }
        return;
      case "help":
        helpHandler.execute(params);
        break;
      default:
        System.out.println("해당 명령을 지원하지 않습니다.");
      }
    } while (true);
  }
  
  private void save() throws Exception {
    FileWriter out = new FileWriter("./data/student.dat");
    BufferedWriter out2 = new BufferedWriter(out);
    PrintWriter out3 = new PrintWriter(out2);
    
    for (Student s: list) {
      out3.println(s);
    }
    
    out3.close();
    out2.close();
    out.close();
  }
  
}
