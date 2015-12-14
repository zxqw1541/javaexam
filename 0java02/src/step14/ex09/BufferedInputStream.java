package step14.ex09;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream extends InputStream{
  InputStream inputStream;
  byte[] buffer = new byte[8192];
  int len;
  int cursor;
  
  public BufferedInputStream(InputStream inputStream) throws FileNotFoundException {
    this.inputStream = inputStream;
  }
  
  public int read() throws IOException {
    if (cursor == len) {
      cursor = 0; //커서의 위치를 처음으로 돌린다.
      if((len = inputStream.read(buffer)) == -1)
      {        
        return -1;
      }
    }
    
    return 0x000000ff & buffer[cursor++];
  }
  
  public void close() throws IOException {
    // 이 클래스에서 해제할 자원이 있다면 여기 밑에 작성하라.
  }
}
