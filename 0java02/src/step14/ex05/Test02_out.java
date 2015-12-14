package step14.ex05;

import java.io.FileOutputStream;

public class Test02_out {

  public static void main(String[] args) throws Exception {
    // primitive type 데이터 출력하기
    FileOutputStream out = new FileOutputStream("./test/ex05.test02.dat");

    // 성적 데이터 출력하기
    String name = "홍길동";
    int kor = 100;
    int eng = 90;
    int math = 80;

    // 이름국어영어수학 순서로 출력하시오!

    // 출력형식(File Format) 정의
    // 2: 문자열 크기
    // 문자열 바이트
    // 4: 국어 점수
    // 4: 영어 점수
    // 4: 수학 점수
    byte[] bytes = name.getBytes();
    // 1) 문자열 크기 출력
    out.write(bytes.length >> 8);
    out.write(bytes.length);
    // 2) 문자열 바이트 출력
    out.write(bytes);

    // 3) 국어 점수 출력
    for (int i = 3; i >= 0; i--)
      out.write(kor >> (8 * i));

    // 3) 영어 점수 출력
    for (int i = 3; i >= 0; i--)
      out.write(eng >> (8 * i));

    // 3) 수학 점수 출력
    for (int i = 3; i >= 0; i--)
      out.write(math >> (8 * i));

    out.close();
    System.out.println("실행완료");

  }
}
