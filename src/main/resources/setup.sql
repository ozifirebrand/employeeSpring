create database employee_db;

create user 'employee_user'@'localhost' identified by "password";

grant all privileges on employee_db.* to 'employee_user'@'localhost';

flush privileges;