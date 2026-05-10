create table roles
(
    id   serial
        primary key,
    name varchar(50) not null
);

alter table roles
    owner to avnadmin;

