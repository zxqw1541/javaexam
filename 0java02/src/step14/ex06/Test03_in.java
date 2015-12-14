package step14.ex06;

public class Test03_in {
  public static void main(String[] args) throws Exception {
    // 캐싱을 적용한 BufferedInputStream 사용하기
    // => 1 바이트씩 읽을 때 속도는?
    BufferedInputStream in = new BufferedInputStream("./test/test.mp4");
    
    long start = System.currentTimeMillis();
    int b;
    while((b = in.read()) != -1);
    long end = System.currentTimeMillis();
    
    System.out.println(end - start);
    
    in.close();
  }

}
