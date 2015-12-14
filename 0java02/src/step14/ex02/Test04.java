package step14.ex02;

import java.io.File;
import java.util.regex.Pattern;

public class Test04 {
  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File(".");

 // => 문제: 클래스 이름만 출력하라!
    // => .class 확장자는 출력하지 않는다.
    search(file);
  }

  public static void search(File file) {
    File[] files = file.listFiles();
    for (File f : files) {
      if (f.isFile())
        printClassName(f.getName());
      if (f.isDirectory()) {
        search(f);
      }
    }
  }

  public static void printClassName(String str) {
    if (str.endsWith(".class"))
    {
      int len = str.length();
      System.out.println(str.substring(0, len - 6));
    }
  }

}
