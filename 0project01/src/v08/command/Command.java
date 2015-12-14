package v08.command;

import java.util.HashMap;

// MenuControl가 호출하는 메서드를 정의한다.
// 예) ProjectControl, StudentControl
// - 인터페이스의 메서드는 구현해서는 안된다.
// - 무조건 public 이고 abstract 이어야 하기 때문에 생략한다.
public interface Command {
 /* public abstract */ void execute(HashMap<String, Object> params);

}
