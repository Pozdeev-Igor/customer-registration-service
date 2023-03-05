--liquibase formatted sql

--changeset wjkb-13:5
alter table authority drop column barber_id;
alter table authority rename column client_id to user_id;

alter table if exists authority add constraint FK6ivstjtpcw0ubkjjpxgh8r91m foreign key (user_id) references users;