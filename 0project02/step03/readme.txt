[주제: DBMS 사용]
1. MySQL JDBC 드라이버를 CLASSPATH에 추가 
  => build.gradle에 의존 라이브러리 "MySQL JDBC 드라이버"를 등록한다.
  => gradle build... 수행
  
2. ProjectDao에 JDBC 적용
  => project 테이블 생성 => project.sql
  => Project 값 객체를 DB 테이블에 맞추어 변경 = > Project.java
    .프로젝트 번호 필드 추가
  => ProjectDao 클래스에 JDBC 적용 => ProjectDao.java
  