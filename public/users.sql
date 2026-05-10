create table users
(
    id         serial
        primary key,
    first_name varchar(100),
    last_name  varchar(100),
    email      varchar(150) not null
        unique,
    role_id    integer
        references roles,
    created_at timestamp default CURRENT_TIMESTAMP,
    username   varchar(100) not null
        unique,
    password   varchar(255) not null,
    group_id   integer
        references groups
);

alter table users
    owner to avnadmin;

