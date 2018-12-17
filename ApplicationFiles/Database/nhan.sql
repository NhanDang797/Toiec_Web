
use toieconline;

create table listenguideline(
  listenguidelineid bigint auto_increment not null primary key ,
  title varchar(512) null,
  image varchar(512) null,
  content text null,
  createdate timestamp null,
  modifydate timestamp null

);

create table comment(
  commentid bigint auto_increment not null primary key ,
  content text null,
  userid bigint null,
  listenguidelineid bigint null,
  createdate timestamp null
);
-- thêm 2 khóa ngoại cho bảng  comment
alter  table  comment add constraint fk_user_comment foreign key (userid) references user(userid);
alter  table  comment add constraint fk_listenguideline_comment foreign key (listenguidelineid) references listenguideline(listenguidelineid);
