package v11.server.domain;

public class Student {
  protected String name;
  protected String email;
  protected String tel;
  protected String cid; // class ID
  
  public Student() {}
 
  public Student(String str) {
    this.setValue(str);
  }
  
  public Student(String name, String tel) {
    this.name = name;
    this.tel = tel;
  }
  
  void setValue(String str) {
    String[] tokens = str.split(",");
    if (tokens.length < 4)
      return;
    name = tokens[0];
    email = tokens[1];
    tel = tokens[2];
    cid = tokens[3];    
  }
  
  @Override
  public String toString() {
    return this.getName() + "," + this.getEmail() + "," + 
           this.getTel() + "," + this.getCid();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }
  
  
}









