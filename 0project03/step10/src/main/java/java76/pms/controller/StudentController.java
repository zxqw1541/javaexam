package java76.pms.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;
import java76.pms.util.MultipartHelper;

@Controller
public class StudentController {
  public static final String SAVED_DIR = "/file";
  @Autowired StudentDao studentDao;

  @RequestMapping("/student/list.do")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
      @RequestParam(defaultValue="no") String keyword,
      @RequestParam(defaultValue="desc") String align,
      HttpServletRequest request) 
          throws Exception {

    // 파라미터 값이 넘오지 않으면 기본 값으로 설정한다.
    if (pageNo < 0) pageNo = 1;
    if (pageSize < 0) pageSize = 10;
    if (keyword != null) keyword = "no";
    if (align != null) align = "desc";
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyboard", keyword);
    paramMap.put("align", align);
    
    List<Student> students = studentDao.selectList(paramMap);
    request.setAttribute("students", students);
    
    return "/student/StudentList.jsp";
  }
  
  @RequestMapping("/student/add.do")
  public String add(
      String name,
      String email,
      String tel,
      String cid,
      String pwd,
      MultipartFile image,
      HttpServletRequest request, 
      HttpServletResponse response) throws Exception {

    String newFileName = null;
    if (image.getOriginalFilename().length() > 0) {
      newFileName = MultipartHelper.generateFilename(image.getOriginalFilename());
      File attachFile = new File(
          request.getServletContext().getRealPath(SAVED_DIR)
          + "/" + newFileName);
      image.transferTo(attachFile);
    }
    
    Student student = new Student();
    student.setName(name);
    student.setEmail(email);
    student.setTel(tel);
    student.setCid(cid);
    student.setPwd(pwd);
    student.setImage(newFileName);

    studentDao.insert(student);

    return "redirect:list.do";
  }
  
  @RequestMapping("/student/delete.do")
  public String delete(
      String email,
      String password,
      HttpServletRequest request) throws Exception {
    
    
    System.out.println(email + ":" + password);
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("pwd", password);

    if (studentDao.delete(paramMap) <= 0) {
      request.setAttribute("errorCode", "401");
      return "/student/StudentAuthError.jsp";
    }
      
    return "redirect:list.do";
  }
  
  @RequestMapping("/student/detail.do")
  public String detail(
      String email,
      HttpServletRequest request) throws Exception {

    Student student = studentDao.selectOne(email);
    request.setAttribute("student", student);

    return "/student/StudentDetail.jsp";
  }

  @RequestMapping("/student/update.do")
  public String update(
      String name,
      String email,
      String tel,
      String cid,
      String password,
      MultipartFile image,
      String himage,
      HttpServletRequest request) throws Exception {

    String newFileName = null;
    if (image.getOriginalFilename().length() > 0) {
      newFileName = MultipartHelper.generateFilename(image.getOriginalFilename());
      File attachFile = new File(
          request.getServletContext().getRealPath(SAVED_DIR)
          + "/" + newFileName);
      image.transferTo(attachFile);
    }
    
    Student student = new Student();
    student.setName(name);
    student.setEmail(email);
    student.setTel(tel);
    student.setCid(cid);
    student.setPwd(password);
    
    if (newFileName != null) {
      student.setImage(newFileName);
    } else if (newFileName == null && himage.length() > 0){
      student.setImage(himage);
    }

    if (studentDao.update(student) <= 0) {
      request.setAttribute("errorCode", "401");
      return "/board/BoardAuthError.jsp";
    }
    return "redirect:list.do";

  }
}
