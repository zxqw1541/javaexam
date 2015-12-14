package pms.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int     no;
  protected String  title;
  protected ArrayList<String>  authors;
  //protected String  authors;
  
  protected String  press;
  protected ArrayList<String>  tag;
  protected boolean rent;
   
  public Book() {
    tag = new ArrayList<>();
    authors = new ArrayList<>();
  }
  
  
  public String getAllTags() {
    if (tag.size() == 0)
       return "";
    
    String result = "";
    result += tag.get(0);
    if (tag.size() > 1) {
      for (int i = 1; i < tag.size(); i++) {
        result += "," + tag.get(i);
      }
    }
    return result;
  }

  public void setTag(String tag) {
    String[] tok = tag.split(",");
    for (String s : tok)
      this.tag.add(s);
  }
  
  
  public String getAuthors() {
    String result = "";
    result += authors.get(0);
    if (authors.size() > 1) {
      for (int i = 1; i < authors.size(); i++) {
        result += "," + authors.get(i);
      }
    }
    return result;
  }
  
  public String getOneAuthor() {
    return authors.get(0);
  }


  public void setAuthors(String authors) {
    String[] tok = authors.split(",");
    for (String s : tok)
      this.authors.add(s);
  }


  
  @Override
  public String toString() {
    return "Book [no=" + no + ", title=" + title + ", authors=" + authors + ", press=" + press + ", tag=" + tag
        + ", rent=" + rent + "]";
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
//  public ArrayList<String> getAuthors() {
//    return authors;
//  }
//  public void setAuthors(ArrayList<String> authors) {
//    this.authors = authors;
//  }
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
  
  
  
}
