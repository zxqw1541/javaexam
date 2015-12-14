package step14.ex02;

import java.io.File;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

public class Test05 {

  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File("./bin");

    // 문제: 클래스 이름만 출력하라!
    // => .class 확장자는 출력하지 않는다.
    // => 패키지명을 포함하라.
    // 예) Test04

    displayDirectory(file);
  }

  private static void displayDirectory(File file) {

    File[] files = file.listFiles();
    for (File f : files) {
      if (f.isFile()) {
        if (f.getName().endsWith(".class")) {
          System.out.println(
              f.getPath().replace(".class", "")
                         .substring(6)
                         .replace(System.getProperty("file.separator"), "."));
        }
      } else if (f.isDirectory()) {
        displayDirectory(f);
      }
    }
  }
}
