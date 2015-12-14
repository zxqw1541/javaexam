package java76.pms.domain;

import java.io.Serializable;

public class Student implements Serializable {
  private static final long serialVersionUID = 1L;
  protected String name;
  protected String email;
  protected String tel;
  protected String cid; // class ID
  protected String pwd;
  protected String image;
  
  public Student() {}
  
  public Student(String name, String tel) {
    this.name = name;
    this.tel = tel;
  }
  
  


  @Override
  public String toString() {
    return "Student [name=" + name + ", email=" + email + ", tel=" + tel + ", cid=" + cid + ", pwd=" + pwd + ", image="
        + image + "]";
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
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









