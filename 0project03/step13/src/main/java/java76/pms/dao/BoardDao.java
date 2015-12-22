package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Board;

public interface BoardDao {

  public List<Board> selectList(Map<String,Object> paramMap);
    

  public int insert(Board board);

  public int delete(Map<String,Object> paramMap);
  
  public int update(Board board);

  public Board selectOne(int no);
  
}

