drop table if exists my_entity;
create table my_entities(id int auto_increment primary key, name varchar(255));

insert into my_entities(name) values ('name1');
insert into my_entities(name) values ('name2');