create table groups
(
    id   serial
        primary key,
    name varchar(50) not null
);

alter table groups
    owner to avnadmin;

