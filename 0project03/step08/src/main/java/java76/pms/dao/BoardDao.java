package java76.pms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.domain.Board;

@Component
public class BoardDao {

  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public BoardDao() {}

  public List<Board> selectList(int pageNo, int pageSize,
      String keyword, String align) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String, Object> paramMap = new HashMap<>();
      paramMap.put("startIndex", (pageNo - 1) * pageSize);
      paramMap.put("length", pageSize);
      paramMap.put("keyboard", keyword);
      paramMap.put("align", align);
      // selectList()에 주는 값은,
      // SQL 맴퍼 파일에 정의된 namespace 이름과 sql 아이디이다.
      return sqlSession.selectList("java76.pms.dao.BoardDao.selectList", paramMap);//namesapce.ID
      // 굳이 예외를 받지 않는다.
      // 
            
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
    
  }

  public int insert(Board board) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    try {
      return sqlSession.insert("java76.pms.dao.BoardDao.insert", board);//namesapce.ID
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }

  public int delete(int no, String password) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("no", no);
    paramMap.put("password", password);
    
    try {
      return sqlSession.delete("java76.pms.dao.BoardDao.delete", paramMap);//namesapce.ID
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public int update(Board board) {
    // auto-commit 활성화
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.update("java76.pms.dao.BoardDao.update", board);//namesapce.ID
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }

  public Board selectOne(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    try {
      return sqlSession.selectOne("java76.pms.dao.BoardDao.selectOne", no);// namesapce.ID
    } finally {
      try {
        sqlSession.close();} catch (Exception e) {}
    }
  }
}

