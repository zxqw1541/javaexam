/*
create 테이블명 (
  컬럼명 타입 옵션, 
  컬럼명 타입 옵션,
  ...
);
*/

--예1) 테이블 생성
CREATE TABLE test01 (
  name VARCHAR(10), 
  age INT
);


/* 테이블 내용 출력
mysql>  desc[ribe] 테이블명;
*/
-- 예) 
mysql > desc test01;


/* 테이블 삭제 - 물론, 테이블에 들어있는 모든 데이터를 삭제한다. 
drop table 테이블명;
*/
-- 예)
DROP TABLE test01;

/* 테이블에 데이터 입력 
insert into 테이블명(컬럼명, 컬럼명, ....) values('값','값',....);
*/

--예) 모든 컬럼 값 입력
INSERT INTO test01(name ,age) values ('홍길동', 20);
INSERT INTO test01(name ,age) values ('임꺽정', 30);
INSERT INTO test01(name ,age) values ('유관순', 17);
INSERT INTO test01(name ,age) values ('유관순', 17);

--예) 일부 컬럼 값 입력
INSERT INTO test01(name, age) values ('사용자1', null);
INSERT INTO test01(name, age) values (null, 50);
INSERT INTO test01(name) values ('사용자2');
INSERT INTO test01(age) values (60);


/* 데이터 조회 
select * from 테이블명;
*/
-- 예) 모든 컬럼 출력하기
SELECT * FROM test01;

-- 예) 출력할 항목을 선택한다.
SELECT name FROM test01;
SELECT age FROM test01;

/*
 * 문제 :
 * Student와 Project를 저장할 테이블을 정의하시오!.
 * 
 */

-- Student 객체 정보를 저장할 테이블
CREATE TABLE student (
  name VARCHAR(20),
  email VARCHAR(100),
  tel VARCHAR(20),
  cid VARCHAR(50)
);

-- Project 객체 정보를 저장할 테이블
CREATE TABLE project (
  title VARCHAR(255),
  start_dt DATETIME,
  end_dt DATETIME,
  member VARCHAR(255)
);


