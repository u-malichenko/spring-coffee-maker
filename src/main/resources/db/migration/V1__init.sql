create table if not exists log (id bigserial primary key, name varchar(255), status varchar(255), timestamp timestamp default current_timestamp);

insert into log (name, status)
values
('test2', 'OK');