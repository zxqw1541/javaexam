package step14.ex07;

import java.io.IOException;

import step14.ex05.DataInputStream;

public class BufferedDataInputStream extends DataInputStream {
  byte[] buffer = new byte[8096];
  int len;
  int cursor;

  public BufferedDataInputStream(String name) throws Exception {
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
  
  @Override
  public int read(byte[] bytes) throws IOException {
    int i = 0;
    int b = - 1;
    for (; i < bytes.length ; i++) {
      if ((b = this.read()) == -1)
        break;
      bytes[i] = (byte)b;
    }
    
    return i;
  }
  

}
