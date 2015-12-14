package pms.domain;

import java.io.Serializable;

public class Book implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int     no;
  protected String  title;
  protected String  authors;
  protected String  press;
  protected String  tag;
  protected boolean rent;

  

  public String getAuthor() {
    String[] tok = authors.split(",");
    
    if (tok.length > 1)
      return tok[0];
    
    return authors;
  }
  
  public String getAuthors() {
    return authors;
  }
  public void setAuthors(String authors) {
    this.authors = authors;
  }
  public String getTag() {
    return tag;
  }
  public void setTag(String tag) {
    this.tag = tag;
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getPress() {
    return press;
  }
  public void setPress(String press) {
    this.press = press;
  }
 
  public boolean isRent() {
    return rent;
  }
  public void setRent(boolean rent) {
    this.rent = rent;
  }

  @Override
  public String toString() {
    return "Book [no=" + no + ", title=" + title + ", authors=" + authors + ", press=" + press + ", tag=" + tag
        + ", rent=" + rent + "]";
  }
  
  
  
}
