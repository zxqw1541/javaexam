[주제: 필터 사용하기]
 웹 컴포넌트 (Servlet, Filter, Listener)
* 필터(filter)
=> 서블릿 컨테이너가 서블릿을 실행하기 전에 먼저 실행하는 웹 컴포넌트이다.
=> 서블릿 실행 전/후에 수행할 작업이 있다면 필터에 넣는다.
=> 실행 전: 압축 해제, 암호 해제, 로그 작성, 사용자 인증/권한 검사 등
  .실행 후: 콘텐츠 압축, 콘텐츠 암호화, 로그 작성 등


1. 필터 만들기
=> javax.servlet.Filter 인터페이스를 구현해야 한다ㅣ

1) Filter01.java 클래스 작성한다.
2) Servlet01.java 클래스 작성한다.
3) 필터와 서블릿정보를 web.xml에 등록한다.

2. 같은 URL에 필터 추가하기
1) Filter02.java 클래스 작성한다.
2) web.xml에 Filter01과 같은 URL로 Filter02를 등록한다

3. 더 넓은 범위의 필터 추가하기
1) Filter03.java 클래스 작성한다.
2) Servlet02.java 클래스를 작성한다.
3) web.xml에 서블릿 등록하고, 필터는 /step08/*로 URL을 등록한다.

4. 모든 요청에 대해 작업하는 필터 추가하기
1) Filter04.java 클래스 작성한다.
2) web.xml에 * URL로 필터를 등록한다.

5. 필터에 설정 데이터 전달하기
=> 변경 가능성이 있는 데이터는 소스 코드에 작성하지 말고,
  .외부 파일(예: web.xml)에 작성하여 필터에 전달하라!
=> 필터 초기화 파라미터 설정을 이용하라!
1) Filter05.java클래스를 작성한다.
2) web.xml에 * URL로 필터를 등록한다. 
  .또한 필터가 참조할 데이터를 초기화 파라미터로 전달한다.

  
* 리스너(listener)
=> 특정 사건에 대해 알림을 받고 싶을 때 사용하는 웹 컴포넌트이다. 
=> 사건? 세션의 상태 변경, 웹 서버의 상태 변경, 보관소에 값 저장/추출 상태 등
=> 예) 세션이 생성될 때 마다 카운트를 하고 싶다면!

1. ServletcontextListener 만들기
=> 웹 애플리케이션이 시작되거나 종료될 때 호출된다.
=> ServletcontextListener01.java 클래스 작성.
=> ServletcontextListener02.java 클래스 작성.
=> web.xml에 리스너 등록
=> 웹 애플리케이션을 시작하고 종료하여 호출되는 것을 확인한다.

2. ServletContextAttributeListener
=> ServletContext에 데이터를 저장할 때 마다 호출되는 리스너 만들기
=> ServletContextAttributeListener01.java 클래스 작성
=> Servlet04.java 클래스 작성


























