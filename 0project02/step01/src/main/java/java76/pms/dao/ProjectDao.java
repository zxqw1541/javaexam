package java76.pms.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import java76.pms.annotation.Component;
import java76.pms.domain.Project;
import java76.pms.exception.DaoException;


@Component
public class ProjectDao {
  ArrayList<Project> list = new ArrayList<Project>();
  
  public ProjectDao() {
    String filename = "./data/project.dat";
    try (
      FileReader in = new FileReader(filename);
      BufferedReader in2 = new BufferedReader(in);
    ) {
      String line = null;
      while ((line = in2.readLine()) != null) {
        list.add(new Project(line));
      }
    } catch (Exception e) {
      throw new DaoException("프로젝트 정보 로딩 실패!");
    }
  }
  
  public void save() {
    try (
      FileWriter out = new FileWriter("./data/project.dat");
      BufferedWriter out2 = new BufferedWriter(out);
      PrintWriter out3 = new PrintWriter(out2);
    ) {
      for (Project project : list) {
        out3.println(project);
      }
    } catch (Exception e) {
      throw new DaoException("프로젝트 정보 저장 실패!");
    }
  }

  public ArrayList<Project> selectList() {
    return list;
  }

  public void insert(Project project) {
    list.add(project);
    this.save();
  }

  public Project delete(int no) {
    Project obj = list.remove(no);
    this.save();
    return obj;
  }
}







