[주제: 애노테이션을 이용한 페이지 컨트롤러의 요청 핸들러 관리]
* 요청 핸들러(request handler)?
- 요청이 들어 왔을 때 호출되는 메서드.
 .예) 페이지 컨트롤러의  execute() 메서드

* 목표
 1) CRUD 코드를 한 클래스에 모은다.
 2) 요청 핸들러(메서드)에 URL을 지정한다.
   - RequestMapping 애노테이션 사용.
   
* 실습
1. AuthController 클래스 작성

2. RequestMapping 애노테이션 작성

3. ContrextLoaderListener 클래스 변경
  - 각 객체에서 RequestMapping 애노테이션이 붙은 메서드를 찾아서,
  . 별도 테이블에 관리한다.
  1) 인스턴스와 메서드를 담을 새로운 타입을 정의한다.
    => RequestHandler
  2) 작업내용은 주석 내용을 참조할 것!
  
4. DispatcherServlet 클래스 변경
  - 