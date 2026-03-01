create table if not exists students
(
    id serial primary key,
    registration_number varchar(50) unique,
    first_name varchar(50) not null,
    lastname varchar(50),
    email varchar(50) unique,
    password varchar(50)

);