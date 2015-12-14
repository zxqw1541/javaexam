package v08.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import v08.domain.Project;
import v08.exception.DaoException;

// 데이터의 지속성(persistence)을 관리
// => 등록(Create), 조회(Read/Retrieve), 변경(Update), 삭제(Delete)을 관리
// => 이런 기능을 CRUD 라고 부른다.
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
      throw new DaoException("프로젝트정보 로딩 실패!");
    }
  }

  public void save() {

    try (FileWriter out = new FileWriter("./data/project.dat");
        BufferedWriter out2 = new BufferedWriter(out);
        PrintWriter out3 = new PrintWriter(out2);) {

      for (Project p : list) {
        out3.println(p);
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
  }

  public Project delete(int no) {
    return list.remove(no);
  }

}
