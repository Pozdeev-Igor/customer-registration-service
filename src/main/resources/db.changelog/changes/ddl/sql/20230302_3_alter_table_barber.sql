--liquibase formatted sql

--changeset wjkb-13:3
alter table if exists barber
    drop column deposit_id;