package step14.ex06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStream extends FileInputStream {
  byte[] buffer = new byte[8192];
  int len;
  int cursor;
  
  public BufferedInputStream(String name) throws FileNotFoundException {
    super(name);
  }
  
  @Override
  public int read() throws IOException {
    if (cursor == len) {
      cursor = 0; //커서의 위치를 처음으로 돌린다.
      if((len = super.read(buffer)) == -1)
      {        
        return -1;
      }
    }
    
    return 0x000000ff & buffer[cursor++];
  }
}
