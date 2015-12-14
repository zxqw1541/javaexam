-- 프로젝트 테이블 생성
create table student (
  sno     int,
  name    varchar(100) not null,
  email   varchar(100) not null,
  tel     varchar(20) not null,
  cid     varchar(20)
);

alter table student
  add constraint stu_pk primary key (sno);
  
alter table student
  modify sno int auto_increment;
  
-- 샘플 데이터 입력
insert into student(name, email, tel, cid) values ('aaaa','aaaa@test.com','111-1111','c01');
insert into student(name, email, tel, cid) values ('bbbb','bbbb@test.com','111-1112','c01');
insert into student(name, email, tel, cid) values ('cccc','cccc@test.com','111-1113','c01');
insert into student(name, email, tel, cid) values ('dddd','dddd@test.com','111-1114','c01');
