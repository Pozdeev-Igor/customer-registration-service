--liquibase formatted sql

--changeset wjkb-13:1
create table appointment (
                             id  uuid not null,
                             barber_id uuid,
                             client_id uuid,
                             day_and_time_id uuid,
                             feedback_id uuid,
                             service_type_id uuid,
                             primary key (id)
);