
package step09.v08;

import java.sql.Date;

public class Project {
  
  String name;
  Date   startDate;
  Date   endDate;
  String member;
  
  public Project() {}
  
  public Project(String name, Date startDate, Date endDate, String member) {
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.member = member;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getMember() {
    return member;
  }

  public void setMember(String member) {
    this.member = member;
  }

  @Override
  public String toString() {
    return "Project [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", member=" + member + "]";
  }
  
  
  
  
}