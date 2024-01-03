create database `studentdb`;
use `studentdb`;

create table students
(
    id          int auto_increment
        primary key,
    student_id  int         null,
    name        varchar(50) null,
    gender      varchar(10) null,
    birthdate   date        null,
    class       varchar(50) null,
    total_score int         null
);



INSERT INTO students (student_id, name, gender, birthdate, class, total_score)
VALUES (1001, 'John Smith', 'Male', '2000-01-05', 'Class A', 85),
       (1002, 'Emma Davis', 'Female', '2001-03-12', 'Class B', 92),
       (1003, 'Michael Lee', 'Male', '2000-06-20', 'Class A', 78),
       (1004, 'Olivia Wang', 'Female', '2001-09-28', 'Class C', 90),
       (1005, 'Sophia Chen', 'Female', '2000-12-15', 'Class B', 88);