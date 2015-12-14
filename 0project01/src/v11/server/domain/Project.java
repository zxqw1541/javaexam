package v11.server.domain;

import java.sql.Date;

public class Project {
  protected String  title;
  protected Date    startDate;
  protected Date    endDate;
  protected String  member;
  
  public Project() {}
  
  public Project(String str) {
    this.setValue(str);
  }
  
  public Project(String title, Date startDate, Date endDate) {
    this.title = title;
    this.startDate = startDate;
    this.endDate = endDate;
  }
  
  void setValue(String str) {
    String[] tokens = str.split(",");
    if (tokens.length < 4)
      return;
    title = tokens[0];
    startDate = Date.valueOf(tokens[1]); //yyyy-MM-dd ------> Date 객체
    endDate = Date.valueOf(tokens[2]);
    member = tokens[3];    
  }

  @Override
  public String toString() {
    return this.getTitle() + "," + this.getStartDate() + "," + 
        this.getEndDate() + "," + this.getMember();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

}
