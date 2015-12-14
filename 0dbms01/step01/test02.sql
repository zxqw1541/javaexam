/* 데이터 중복 등록과 삭제
*/
--기존에 등록된 데이터를 중복 등록한다.
INSERT INTO test01(name ,age) values ('홍길동', 20);

-- 중복 데이터 중에서 한 개를 지우기
/*
delete from 테이블명 where 컬럼명=값 and 칼럼명=값 ...;
*/
delete from test01 where name='홍길동' and age=20;
-- 중복 데이터 모두 삭제된다.
-- 특정 데이터만 삭제하려면, 각 데이터마다 고유의 식별자가 있어야 한다.


/* Key - 데이터를 식별하기 위한 컬럼 
 * 
 * 1) Key: 데이터를 식별하기 위해 여러 개의 컬럼을 묶은 것
 * 2) Candidate Key: Key들 중에서 최소의 컬럼으로 묶은 것. 최소키 또는 후보키라 부른다.
 * 3) Primary Key: 후보키 중에서 관리자가 사용하기 ㅜ이해서 사용된 키.
 * */
-- student 테이블의 예.
-- 1) Key
 name, email,
 name, tel,
 name, tel, cid
 namem email, tel
 email,
 tel

-- 2) Candidate Key
 email
 tel
 
 
-- 3) Primary Key
tel

/* 키로 사용할 마땅한 컬럼이 없을 때? 
 * - 보통 일련 번호를 식별자로 사용한다.
 *   => 일련 번호 컬럼을 추가한다.
 */
 
-- test01 테이블을 복사하여 test02를 만들고, primary key를 적용하라!
-- 일련 번호를 primary key로 갖도록 한다.
-- 컬럼명: sno
CREATE TABLE test02 (
  tno  INT PRIMARY KEY,
  name VARCHAR(10), 
  age  INT
);


-- 데이터 입력
INSERT INTO test02(tno, name ,age) values (1, '홍길동', 20);
 
-- 다음 데이터를 입력하면 tno(pk) 컬럼의 값이 중복되었다고 오류가 뜬다. 
INSERT INTO test02(tno, name ,age) values (1, '홍길동', 20);

-- pk 컬럼(tno)의 값이 중복되지 않도록 한다.
INSERT INTO test02(tno, name ,age) values (2, '홍길동', 20);
INSERT INTO test02(tno, name ,age) values (3, '홍길동', 20);

-- 중복 데이터를 제거해 보자!
-- pk 컬럼의 값으로 특정 데이터를 삭제한다.
delete from test02 where tno=2;
select * from test02;  -- 삭제 확인!
 
delete from test02 where tno=3;
select * from test02;  -- 삭제 확인! 
 