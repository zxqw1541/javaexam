
package step09.v07;

public class Student {
  
  String name;
  String email;
  String tel;
  String cId; // class ID
  
  public Student() {}
  
  public Student(String name, String tel) {
    this.name = name;
    this.tel = tel;
    
  }
  

  @Override
  public String toString() {
    return "Student [name=" + name + ", email=" + email + ", tel=" + tel + ", cId=" + cId + "]";
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

  public String getcId() {
    return cId;
  }

  public void setcId(String cId) {
    this.cId = cId;
  }

}
