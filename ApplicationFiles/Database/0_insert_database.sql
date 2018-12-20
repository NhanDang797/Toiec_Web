use toieconline;
insert  into role values(1,"Admin");

select  * from user;
insert  into user(name, password, fullname, createdate, roleid) values ("admin","123","admin",current_timestamp,1);
insert  into user(name, password, fullname, createdate, roleid) values ("nhandang","123","Dang Huu Nhan",current_timestamp,2);
insert  into user(name, password, fullname, createdate, roleid) values ("nhan123","123","Hữu Nhân",current_timestamp,2);



