[주제:서블릿 만들기]
Servlet01.java 
  - Servlet 인터페이스를 구현하여 서블릿 만들기
  - 만든 서블릿을 웹 어플리케이션 설정 파일에 등록하기
  
Servlet02.java
  - GenericServlet 추상 클래스 사용
  
Servlet03.java
  - 클라이언트로 출력하기
  
Servlet04.java
  - 한글, 중문 등 멀티바이트 문자 깨짐 현상 해결
  - MIME 개요

Servlet05.java
  - 클라이언트가 보낸 데이터를 꺼내는 방법

form.html
  - 한글 데이터 꺠짐 현상
  
Servlet06.java
  - 한글 데이터 깨짐 현상 해결
  - form.html의 action="exam/servlet06"으로 변경해야 한다.
  
* HTTP 프로토콜
1. 요청 프로토콜
request line
((일반헤더 | 요청해더 | 엔티티해더)CRLF)* <--0개 이상
CRLF
엔티티(서버에 보내는 데이터)

1) request-line
=> method request-URI HTTP버전 CRLF
예) POST /0web01/exam/servlet06 HTTP/1.1

2) ((일반헤더 | 요청해더 | 엔티티헤더)CRLF)*
=> 일반헤더
Cache-Control: max-age=0

=> 요청해더
Host: localhost:8080
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8 // 출력형식 요청(순차적으로 우선순위)   
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36
Referer: http://localhost:8080/0web01/form.html // 어떤 링크에서 여기로 넘어 왓는지 확인 (이전 페이지에 대한 정보)
Accept-Encoding: gzip, deflate 
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

=> 엔티티 헤더:
Content-Length: 26 <= 파라미터 길이
Content-Type: application/x-www-form-urlencoded

=> 기타 해더:
Upgrade-Insecure-Requests: 1
Origin: http://localhost:8080

요청 프로토콜 전체 예)
-----------------------------------------
POST /0web01/exam/servlet06 HTTP/1.1
Host: localhost:8080
Content-Length: 26
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36
Content-Type: application/x-www-form-urlencoded
Referer: http://localhost:8080/0web01/form.html
Accept-Encoding: gzip, deflate
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

name=aaaa&age=20&tel=11111
------------------------------------------


* 요청 메서드
=> GET
   - 서버에 단순한 콘텐츠를 요청할 때 사용
   - 서버에 보내는 데이터는 URL에 포함시킨다.
    .예) http://localhost:8080/web01/board/list?pageNo=1&pageSize=20
   - URL에 서버에 보내는 데이터가 함께 있기 때문에 조회나 검색 URL을 저장할 때 유용하다.
    .검색 결과를 출력하는 페이지의 URL을 즐겨찾기에 등록한다.
   - URL에 데이터가 있기 때문에 로그인 정보와 같은 보안 데이터를
    .GET 방식으로 서버에 보내서는 안된다.
   - 헤더의 크기가 보통 8k로 정해져 있다. => 대량의 데이터를 전송할 수 없다.
   - URL에 보낼 데이터를 포함해야 하기 때문에 바이너리 데이터 전송 불가.
    .(Base64 형태로 만든다면 보낼 수 있다. => 그래도 크기 제한에 걸린다.)
=> POST
   - 서버에 대량의 데이터를 보낼 때 사용
   - 서버에 보내는 데이터는 요청 프로토콜의 맨 뒤에 붙인다.
   . 예)
     POST /web01/board/list HTTP/1.1
     Host: localhost:8080
     ... (여러개의 헤더들)
     (빈줄)
     name=aaaa&age=20&tel=11111
   - URL에 데이터를 포함하고 있지 않기 때문에, 데이터를 등록/변경 한다거나
    .로그인 하는 등 보안을 요구하는 경우에 유용하다.
   - 즐겨찾기에 등록해봐야 소용없다. 왜? URL에 보내는 데이터가 포함되어 있지 않기 때문에.
   - 보내는 데이터의 크기에 제한이 없다. 서버가 받아들이는 만큼 보낼 수 있다.
   - 멀티파트 방식으로 보낸다면 바이너리 데이터를 무제한으로 보낼 수 있다.
     
=> HEAD
   - 응답 헤더까지만 정보를 요구할 때. 즉 콘텐츠는 요구하지 않는다.
   - 보통 콘텐츠의 부가 정보를 알아내고 싶을 때 사용한다.
   - GET의 응답 결과에서 콘텐츠가 빠진 형태이다.
=> PUT
   - 서버에 새 항목(HTML, CSS, JS 등)을 추가할 때. 
   - 해킹의 위험 때문에 보통 막아둔다.
=> DELETE
   - 서버의 항목을 제거할 때.
   - 해킹의 위험 때문에 보통 막아둔다.
=> TRACE
=> CONNECT
=> OPTIONS

2. 응답 프로토콜
status line
((일반헤더 | 응답해더 | 엔티티해더)CRLF)*
CRLF
엔티티(서버에서 클라이언트로 보내는데이터)

=> status line = HTTP버전 상태코드 간단한 메시지 CRLF
HTTP/1.1 200 OK

=> 일반헤더
Date: Wed, 18 Nov 2015 06:46:49 GMT

=> 응답헤더
Accept-Ranges: bytes
ETag: W/"343-1447829202079"
Server: Apache-Coyote/1.1

=> 엔티티헤더
Last-Modified: Wed, 18 Nov 2015 06:46:42 GMT
Content-Type: text/html
Content-Length: 343


응답프로토콜 전체 예)
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Accept-Ranges: bytes
ETag: W/"343-1447829202079"
Last-Modified: Wed, 18 Nov 2015 06:46:42 GMT
Content-Type: text/html
Content-Length: 343
Date: Wed, 18 Nov 2015 06:46:49 GMT

<!DOCTYPE html>
...
</html>

* Modeling과 Rendering
=> 모델링
  - 생각하는 바를 글과 그림으로 표현한 것.
  - 예) UML, DB Modeling, Business Modeling
  
=> 렌더링
  - 코드를 분석하여 화면으로 출력하는 것.
  - HTML 렌더링
  - 예) 웹 브라우저, 캐드
  
* 응답 상태 코드
=> 200 - 정상적인 요청 처리
=> 302 - 리다이렉트를 통해 다른 주소를 알려줄 때
=> 404 - URL에 해당하는 자원 또는 서블릿이 없을 경우
=> 405 - GET, POST 등을 처리할 서블릿이 없는 경우 
=> 500 - 요청한 자원을 실행하는 중에 예외 상황이 발생했을 때
