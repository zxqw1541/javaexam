package v03;

import java.util.Scanner;

public abstract class MenuControl {
  Scanner scanner;
  
  public MenuControl() {}
  public MenuControl(Scanner scanner) {
    this.scanner = scanner;
  }
  
  public abstract void service();

}
