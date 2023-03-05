--liquibase formatted sql

--changeset wjkb-13:4
create table users (
                        id uuid not null,
                        amount varchar(255),
                        email varchar(100),
                        first_name varchar(100),
                        is_active boolean,
                        last_name varchar(100),
                        password varchar(100),
                        phone_number varchar(15),
                        rate float4,
                        primary key (id)
);


alter table appointment drop constraint FK3gbqcfd3mnwwcit63lybpqcf8;
alter table deposit drop constraint FKey7qgtdvk8nipnlgbuagofnqc;
alter table authority drop constraint FK6ivstjtpcw0ubkjjpxgh8r91m;
alter table appointment drop constraint FKmnyoncbc9dic1sb8awa0y64d5;
alter table barber_can_serve drop constraint FK7ru2n42eddr2tvtn1eqt9it2c;
alter table barber_weekends drop constraint FKa1mn85xgyo8ky0k78ikq9l1k5;
alter table deposit drop constraint FK5j1mikahsb7jtjq7wkwlhxcf4;
alter table authority drop constraint FKa5y3oqdlwyahk3ujd7k3gxia9;

drop table client;
drop table barber;
