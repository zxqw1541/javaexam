package util;

import java.util.Base64;

public class Base64Converter {
  public static void main(String[] args) {
    String str = "ABC가각간";
    byte[] base64 = Base64.getEncoder().encode(str.getBytes());
    System.out.printf("%s ----------> %s\n", str, base64);
    for (byte b : base64)
      String.format("%s", Integer.toBinaryString(b))
      .replace(" ", "0");
   
    
    String newStr = new String(Base64.getDecoder().decode(base64));
    System.out.println(newStr);
    
  }

}
