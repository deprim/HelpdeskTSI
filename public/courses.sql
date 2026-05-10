create table courses
(
    id            serial
        primary key,
    name          varchar(200) not null,
    code          varchar(50)
        unique,
    instructor_id integer
        references users
);

alter table courses
    owner to avnadmin;

