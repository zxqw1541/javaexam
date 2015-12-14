package v09.server.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import v09.server.domain.Student;
import v09.server.exception.DaoException;


// 데이터의 지속성(persistence)을 관리
// => 등록(Create), 조회(Read/Retrieve), 변경(Update), 삭제(Delete)을 관리
// => 이런 기능을 CRUD 라고 부른다.
public class StudentDao {
  ArrayList<Student> list = new ArrayList<Student>();

  public StudentDao() {
    String filename = "./data/student.dat";
    try (
        FileReader in = new FileReader(filename); 
        BufferedReader in2 = new BufferedReader(in);
        ) {
      String line = null;

      while ((line = in2.readLine()) != null) {
        list.add(new Student(line));
      }

    } catch (Exception e) {
      throw new DaoException("학생정보 로딩 실패!");
    }
  }

  public void save() {

    try (FileWriter out = new FileWriter("./data/student.dat");
        BufferedWriter out2 = new BufferedWriter(out);
        PrintWriter out3 = new PrintWriter(out2);) {

      for (Student s : list) {
        out3.println(s);
      }
    } catch (Exception e) {
      throw new DaoException("학생정보 저장 실패!");
    }
  }

  public ArrayList<Student> selectList() {
    return list;
  }

  public void insert(Student student) {
    list.add(student);
    this.save();
  }

  public Student delete(int no) {
    Student obj = list.remove(no);
    this.save();
    return obj;
  }

}
