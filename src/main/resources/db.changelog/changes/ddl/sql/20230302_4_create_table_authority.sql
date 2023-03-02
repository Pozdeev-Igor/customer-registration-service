--liquibase formatted sql

--changeset wjkb-13:3
create table authority (
    id uuid not null,
    authority varchar(30),
    barber_id uuid,
    client_id uuid,
    primary key (id)
                       );

-- --changeset wjkb-13:3
alter table if exists authority add constraint FKa5y3oqdlwyahk3ujd7k3gxia9 foreign key (barber_id) references barber;
alter table if exists authority add constraint FK6ivstjtpcw0ubkjjpxgh8r91m foreign key (client_id) references client;
