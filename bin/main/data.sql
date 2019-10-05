insert into course(id,name)values(1000,'Java-OOPs');
insert into course(id,name)values(1001,'C++');
insert into course(id,name)values(1002,'Php');


insert into passport(id,number)values(4001,'E123x23');
insert into passport(id,number)values(4002,'E123x24');
insert into passport(id,number)values(4003,'E123x25');


insert into student(id,name,passport_id)values(2001,'Ashish',4001);
insert into student(id,name,passport_id)values(2002,'Anupam',4002);
insert into student(id,name,passport_id)values(2003,'Kajal',4003);



insert into review(id,rating,description)values(5001,'5','great course');
insert into review(id,rating,description)values(5002,'4','awsome course');
insert into review(id,rating,description)values(5003,'3','wat to say bout course');

insert into product(id,name,quantity,created_date,last_updated_date) values (1,'Laptop',1000,sysdate(),sysdate());
insert into product(id,name,quantity,created_date,last_updated_date) values (2,'Mobile',500,sysdate(),sysdate());
insert into product(id,name,quantity,created_date,last_updated_date) values (3,'ipad',100,sysdate(),sysdate());