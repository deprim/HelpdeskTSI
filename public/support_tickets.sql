create table support_tickets
(
    id          serial
        primary key,
    user_id     integer
        references users,
    title       varchar(200),
    description text,
    category    varchar(50),
    status      varchar(50) default 'OPEN'::character varying,
    created_at  timestamp   default CURRENT_TIMESTAMP,
    resolved_at timestamp
);

alter table support_tickets
    owner to avnadmin;

