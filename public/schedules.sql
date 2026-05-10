create table schedules
(
    id          serial
        primary key,
    course_id   integer
        references courses,
    room_id     integer
        references rooms,
    day_of_week varchar(20),
    start_time  time,
    end_time    time,
    date        date,
    group_id    integer
        references groups
);

alter table schedules
    owner to avnadmin;

