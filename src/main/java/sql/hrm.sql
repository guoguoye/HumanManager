create table dept(
    id int not null auto_increment primary key,
    name varchar(20) not null,
    description varchar(200)
    );
insert into dept values (1,'������','������');
insert into dept (name,description) values ('����','����'),
('���²�','���²�'),('���ز�','���ز�');

create table job(
    id int not null auto_increment primary key,
    name varchar(20) not null,
    description varchar(200)
    );
insert into job values (1,'java��������ʦ','java��������ʦ');
insert into job (name,description) values ('java�м���������ʦ','java�м���������ʦ'),
('java�߼���������ʦ','java�߼���������ʦ'),('��Ʒ����','��Ʒ����');

create table user(
    id int not null auto_increment primary key,
    name varchar(20) not null,
		loginname varchar(35) not null,
		password  varchar(16) not null,
		state char(2),
		createDate datetime not null default CURRENT_TIMESTAMP
    );
insert into user values (1,'admin','admin','admin','1',CURRENT_TIMESTAMP);


create table notice(
    id int not null auto_increment primary key,
    title varchar(20) not null,
    content varchar(200),
		createDate datetime not null default CURRENT_TIMESTAMP,
		user_id int not null,
		foreign key (user_id) REFERENCES user(id),
		CONSTRAINT notice_user_fk foreign key(user_id) REFERENCES user(id)
    );
insert into notice values (1,'��Ǩ֪ͨ','��Ǩ֪ͨ',CURRENT_TIMESTAMP,1);


create table document(
    id int not null auto_increment primary key,
    title varchar(20) not null,
    description varchar(200),
		createDate datetime not null default CURRENT_TIMESTAMP,
		filename varchar(20),
		user_id int not null,
		KEY document_user_fk (user_id),
		CONSTRAINT document_user_fk FOREIGN KEY (user_id) REFERENCES user (id)
    );


CREATE TABLE employee (
  id INT(11) NOT NULL AUTO_INCREMENT primary key,
  dept_id INT(11) NOT NULL,
  job_id INT(11) NOT NULL,
  name VARCHAR(20) NOT NULL,
  idCard VARCHAR(18) NOT NULL,
  address VARCHAR(50) NOT NULL,
  phone VARCHAR(11) NOT NULL,
  email VARCHAR(50) NOT NULL,
  sex char(2) NOT NULL DEFAULT 'M',
  birthday DATETIME DEFAULT NULL,
  createDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 
  KEY employee_dept_fk (dept_id),
  KEY employee_job_fk (job_id),
  CONSTRAINT employee_dept_fk FOREIGN KEY (dept_id) REFERENCES dept (id),
  CONSTRAINT employee_job_fk FOREIGN KEY (job_id) REFERENCES job (id)
) ;

insert into employee VALUES (1,1,1,'Zhang','1111','�ż�ׯ','81891110','81891110@qq.com','M','1997-01-01',CURRENT_TIMESTAMP),
(2,1,2,'Wang','2111','�ż�ׯ','81891112','81891112@qq.com','W','1997-02-01',CURRENT_TIMESTAMP),
(3,1,1,'Liang','3111','�ż�ׯ','81891113','81891113@qq.com','M','1997-08-06',CURRENT_TIMESTAMP);







