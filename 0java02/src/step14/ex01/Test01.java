package step14.ex01;

import java.io.File;

public class Test01 {

  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File("./src/..");
    
    System.out.println("존재 여부 : " + file.exists());
    System.out.println("파일 여부 : " + file.isFile());
    System.out.println("폴더 여부 : " + file.isDirectory());
    System.out.println("파일명 : " + file.getName());
    System.out.println("파일 크기 : " + file.length());
    System.out.println("캐노니컬 경로(., .. 등의 계산을 끝낸 결과 경로) : " + file.getCanonicalPath());
    System.out.println("절대 경로 (날것 그대로): " + file.getAbsolutePath());
    System.out.println("파일 경로 : " + file.getPath());
    System.out.println("여유 공간 : " + file.getFreeSpace());
    System.out.println("총 크기: " + file.getTotalSpace());
    System.out.println("사용 가능 크기 : " + file.getUsableSpace());

  }

}
