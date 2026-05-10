create table rooms
(
    id          serial
        primary key,
    room_number varchar(20),
    capacity    integer,
    type        varchar(50)
);

alter table rooms
    owner to avnadmin;

