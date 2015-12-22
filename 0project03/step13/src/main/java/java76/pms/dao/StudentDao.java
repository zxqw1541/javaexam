package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Student;

public interface StudentDao {

  public List<Student> selectList(Map<String,Object> paramMap);
  public int insert(Student student);
  public int delete(Map<String,Object> paramMap);
  public int update(Student student);
  public Student selectOne(String email);
  public Student login(Map<String,Object> paramMap);
}
