package step14.ex11;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test03_in {
  public static void main(String[] args) throws Exception {
    //직렬화 사용 후
    FileInputStream in = new FileInputStream("./test/ex11.test02.dat");
    ObjectInputStream in2 = new ObjectInputStream(in);

    // 파일 포멧에 맞춰 읽는다.
    Student2 s1 = (Student2)in2.readObject();
    Student2 s2 = (Student2)in2.readObject();
    
    in2.close();
    in.close();
    
    System.out.println(s1);
    System.out.println(s2);
  }

}
