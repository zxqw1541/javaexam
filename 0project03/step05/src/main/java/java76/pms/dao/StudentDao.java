package java76.pms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.domain.Student;

@Component
public class StudentDao {

  @Autowired // 스프링 IoC 컨테니어에게 명령=> 객체를 모두 생성한 후 다음타입의 
  SqlSessionFactory sqlSessionFactory;


  public StudentDao() {
  }

  public List<Student> selectList(int pageNo, int pageSize, String keyword, String align) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      HashMap<String, Object> paramMap = new HashMap<>();
      paramMap.put("startIndex", (pageNo - 1) * pageSize);
      paramMap.put("length", pageSize);
      
      return sqlSession.selectList("java76.pms.dao.StudentDao.selectList", paramMap);// namesapce.ID
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }

  public int insert(Student student) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    try {
      return sqlSession.insert("java76.pms.dao.StudentDao.insert", student);// namesapce.ID

    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
    
  }

  public int delete(String email, String pwd) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("pwd", pwd);
    try {
      return sqlSession.delete("java76.pms.dao.StudentDao.delete", paramMap);// namesapce.ID

    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    
    }
  }

  public int update(Student student) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    try {
      return sqlSession.update("java76.pms.dao.StudentDao.update", student);// namesapce.ID

    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }

  public Student selectOne(String email) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      
      return sqlSession.selectOne("java76.pms.dao.StudentDao.selectOne", email);// namesapce.ID
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }

  public Student login(String email, String password) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      // 두개 값을 넘기고 싶으면 맵에 담아 보내라
      HashMap<String, Object> paramMap = new HashMap<>();
      paramMap.put("email", email);
      paramMap.put("password", password);
      
      return sqlSession.selectOne("java76.pms.dao.StudentDao.login", paramMap);// namesapce.ID
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }

}
