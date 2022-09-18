create table passport
(
    id          serial primary key not null,
    serial      int,
    number      int,
    name        varchar(440),
    validity_date timestamp

);

insert into passport (serial, number, name, validity_date)
values (9895, 742355, 'Макуцевич Александр Иванович', '2022-08-08, 12:12:12');

insert into passport (serial, number, name, validity_date)
values (7754, 885562, 'Сидоров Егор Борисович', '2023-08-08, 12:12:12');

insert into passport (serial, number, name, validity_date)
values (3443, 556765, 'Иванов Иван Иванович', '2022-11-08, 12:12:12');


