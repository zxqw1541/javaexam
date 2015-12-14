package java76.pms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.annotation.RequestMapping;
import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;
import java76.pms.util.MultipartHelper;

@Component
public class StudentController {
  
  @Autowired StudentDao studentDao;

  @RequestMapping("/student/list.do")
  public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int pageNo = 1;
    int pageSize = 200;

    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
    }

    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    // 정렬처리
    String keyword = "no";
    if (request.getParameter("keyword") != null) {
      keyword = request.getParameter("keyword");
    }

    String align = "desc";
    if (request.getParameter("align") != null) {
      align = request.getParameter("align");
    }
    
    List<Student> students = studentDao.selectList(pageNo, pageSize, keyword, align);
    request.setAttribute("students", students);
    
    return "/student/StudentList.jsp";
  }
  
  @RequestMapping("/student/add.do")
  public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Map<String, String> paramMap = MultipartHelper.parseMultipartData(request,
        request.getServletContext().getRealPath("/file"));

    Student student = new Student();
    student.setName(paramMap.get("name"));
    student.setEmail(paramMap.get("email"));
    student.setTel(paramMap.get("tel"));
    student.setCid(paramMap.get("cid"));
    student.setPwd(paramMap.get("pwd"));
    student.setImage(paramMap.get("image"));

    studentDao.insert(student);

    return "redirect:list.do";
  }
  
  @RequestMapping("/student/delete.do")
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    
    String email = request.getParameter("email");
    String pwd = request.getParameter("pwd");

    System.out.println(email + ":" + pwd);

    if (studentDao.delete(email, pwd) <= 0) {
      request.setAttribute("errorCode", "401");
      return "/student/StudentAuthError.jsp";
    }
      
    return "redirect:list.do";
  }
  
  @RequestMapping("/student/update.do")
  public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
