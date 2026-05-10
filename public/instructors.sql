create table instructors
(
    id         serial
        primary key,
    first_name varchar(255),
    last_name  varchar(255)
);

alter table instructors
    owner to avnadmin;

