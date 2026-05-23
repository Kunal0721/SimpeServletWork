create database backend12_1;

use backend12_1;

create table student(
   id int primary key auto_increment, 
   name varchar(100) not null, 
   age int, 
   course varchar(100) not null
 );