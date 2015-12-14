package v09.server.servlet;

import java.util.HashMap;

public interface Servlet { //server + let(작은조각) => servlet
  void service(HashMap<String, Object> params);
}
