-- 프로젝트 테이블 생성
create table project (
  pno     int,
  title   varchar(100) not null,
  sdt     datetime not null,
  edt     datetime not null,
  member  varchar(100)
);

alter table project
  add constraint pro_pk primary key (pno);
  
alter table project
  modify pno int auto_increment;
  
-- 샘플 데이터 입력
insert into project(title, sdt, edt) values ('aaaa','2015-1-1','2015-5-5');
insert into project(title, sdt, edt) values ('bbbb','2015-2-1','2015-6-5');
insert into project(title, sdt, edt) values ('cccc','2015-3-1','2015-7-5');
insert into project(title, sdt, edt) values ('dddd','2015-4-1','2015-8-5');
