package java76.pms.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;
import java76.pms.util.MultipartHelper;

@Component("/student/update.do")
public class StudentUpdateController implements PageController {

  @Autowired
  StudentDao studentDao;

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equals("GET")) {
      return get(request, response);
    } else {
      return post(request, response);
    }
  }

  private String get(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String email = request.getParameter("email");
    Student student = studentDao.selectOne(email);
    request.setAttribute("student", student);

    return "/student/StudentDetail.jsp";
  }

  private String post(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Map<String, String> paramMap = MultipartHelper.parseMultipartData(request,
        request.getServletContext().getRealPath("/file"));

    Student student = new Student();
    student.setName(paramMap.get("name"));
    student.setEmail(paramMap.get("email"));
    student.setTel(paramMap.get("tel"));
    student.setCid(paramMap.get("cid"));
    student.setPwd(paramMap.get("pwd"));

    if (paramMap.get("a_file") != null) {
      student.setImage(paramMap.get("a_file"));
    } else if (paramMap.get("h_file").length() > 0) {
      student.setImage(paramMap.get("h_file"));
    }
    if (studentDao.update(student) <= 0) {
      request.setAttribute("errorCode", "401");
      return "/board/BoardAuthError.jsp";
    }
    return "redirect:list.do";

  }
}
