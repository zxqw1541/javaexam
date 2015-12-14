package java76.pms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.domain.Project;
import java76.pms.util.DBConnectionPool;


@Component
public class ProjectDao {
  DBConnectionPool dbPool;

  public void setDBConnectionPool(DBConnectionPool dbConnectionPool) {
    this.dbPool = dbConnectionPool;
  }
  
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public ProjectDao() {}
  

  public List<Project> selectList(int pageNo, int pageSize, 
      String keyword, String align) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String, Object> paramMap = new HashMap<>();
      paramMap.put("startIndex", (pageNo - 1) * pageSize);
      paramMap.put("length", pageSize);
      paramMap.put("keyboard", keyword);
      paramMap.put("align", align);
      
      return sqlSession.selectList("java76.pms.dao.ProjectDao.selectList", paramMap);//namesapce.ID
            
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
    
  }

  public int insert(Project project) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    try {
      return sqlSession.insert("java76.pms.dao.ProjectDao.insert", project);//namesapce.ID
            
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
    
  }

  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    try {
      return sqlSession.delete("java76.pms.dao.ProjectDao.delete", no);//namesapce.ID
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public int update(Project project) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    try {
      return sqlSession.update("java76.pms.dao.ProjectDao.update", project);//namesapce.ID
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
    
  }
}







