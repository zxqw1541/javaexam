package java76.pms.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;
import java76.pms.util.MultipartHelper;
import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/student/*")
public class StudentController {
  public static final String SAVED_DIR = "/file";
  @Autowired StudentDao studentDao;
  @Autowired ServletContext servletContext;

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
    
    return "student/StudentList";
  }
  
  @RequestMapping(value="add", method=RequestMethod.GET)
  public String form() {
    return "student/StudentForm";
  }
  
  @RequestMapping(value="add", method=RequestMethod.POST)
  public String add(
      Student student,
      MultipartFile image1) throws Exception {

    String newFileName = null;
    if (image1.getOriginalFilename().length() > 0) {
      newFileName = MultipartHelper.generateFilename(image1.getOriginalFilename());
      makeFile(servletContext.getRealPath(SAVED_DIR)
          + "/" + newFileName, image1);
    }
    
    student.setImage(newFileName);

    studentDao.insert(student);

    return "redirect:list.do";
  }
  
  private void makeFile(String path, MultipartFile image) throws Exception {
    File attachFile = new File(path);
    image.transferTo(attachFile);
    Thumbnails.of(attachFile).size(100, 100).toFile(path);
  }

  @RequestMapping("/student/delete.do")
  public String delete(
      String email,
      String password,
      Model model) throws Exception {
    
    
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("pwd", password);

    if (studentDao.delete(paramMap) <= 0) {
      model.addAttribute("errorCode", "401");
      return "/student/StudentAuthError.jsp";
    }
      
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(
      String email,
      Model model) throws Exception {

    Student student = studentDao.selectOne(email);
    model.addAttribute("student", student);

    return "student/StudentDetail";
  }

  @RequestMapping("update")
  public String update(
      Student student,
      MultipartFile oimage,
      String image,
      Model model) throws Exception {

    String newFileName = null;
    if (oimage.getOriginalFilename().length() > 0) {
      newFileName = MultipartHelper.generateFilename(oimage.getOriginalFilename());
      makeFile(servletContext.getRealPath(SAVED_DIR)
          + "/" + newFileName, oimage);
      student.setImage(newFileName);
    }
    
    if (studentDao.update(student) <= 0) {
      model.addAttribute("errorCode", "401");
      return "board/BoardAuthError";
    }
    return "redirect:list.do";

  }
}
