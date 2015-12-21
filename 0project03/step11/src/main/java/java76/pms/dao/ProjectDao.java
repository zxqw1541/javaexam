package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Project;


public interface ProjectDao {

  public List<Project> selectList(Map<String,Object> paramMap);
  public int insert(Project project);
  public int delete(int no);
  public int update(Project project);
  public Project selectOne(int no);
  
}







