-- 여러 개의 컬럼 값 정렬하기

-- 1) 정렬할 기준 컬럼을 지정하지 않으면 PK컬럼을 기준으로 오름차순 정렬한다.
select email, name
from student;

-- 실행 순서: from ---> order by ---> select
select name
from student
order by email;

-- 2) email 내림차순 연결
select email, name
from student
order by email desc;

-- 3) name 내림차순 정렬
select name, email
from student
order by name desc;

-- 4) name 내림차순, email 내림차순
select name, email
from student
order by name desc, email desc;

-- 4) name 오름차순, email 내림차순
select name, email
from student
order by name, email desc;