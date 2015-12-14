drop table books;
create table books (
  bno int,
  title varchar(100) not null,
  authors varchar(100) not null,
  press varchar(100) not null,
  tag varchar(100) not null,
  rent boolean default false
);

alter table books
  add constraint books_pk primary key (bno);
  
alter table books
  modify bno int auto_increment;
  
insert into books (title,authors,press,tag) values ('book1','pp1','1111','java');
insert into books (title,authors,press,tag) values ('book2','pp2','2222','db');
insert into books (title,authors,press,tag) values ('book3','pp3','3333','db');
insert into books (title,authors,press,tag) values ('book4','pp4','4444','java');
insert into books (title,authors,press,tag) values ('book5','pp5','5555','java');
