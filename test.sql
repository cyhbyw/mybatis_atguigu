

create table tbl_employee(
	id INTEGER NOT NULL AUTO_INCREMENT,
	last_name VARCHAR(100),
	email  VARCHAR(100),
	gender INTEGER,
	primary key(id)
);
insert into tbl_employee values('Yanhua', 'cyh@qq.com', 1);

alter table tbl_employee add column d_id VARCHAR(40);




create table tbl_dept(
	id INTEGER NOT NULL AUTO_INCREMENT,
	departmentName VARCHAR(100),	
	primary key(id)	
);

insert into tbl_dept values(1, 'RD');