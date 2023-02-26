--liquibase formatted sql

--changeset wjkb-13:2
create table appointment (
    id uuid not null,
    barber_id uuid,
    client_id uuid,
    day_and_time_id uuid,
    feedback_id uuid,
    service_type_id uuid,
    primary key (id)
                         );

--changeset wjkb-13:3
create table barber (
    id uuid not null,
    amount varchar(255),
    email varchar(255),
    first_name varchar(255),
    is_active boolean,
    last_name varchar(255),
    login varchar(255),
    password varchar(255),
    phone_number varchar(255),
    rate float4,
    deposit_id uuid,
    primary key (id)
                    );

--changeset wjkb-13:4
create table barber_appointments (
    barber_id uuid not null,
    appointments_id uuid not null,
    primary key (barber_id, appointments_id)
                                 );

--changeset wjkb-13:5
create table barber_can_serve (
    barber_id uuid not null,
    can_serve_id uuid not null,
    primary key (barber_id, can_serve_id)
                              );

--changeset wjkb-13:6
create table barber_feedbacks (
    barber_id uuid not null,
    feedbacks_id uuid not null,
    primary key (barber_id, feedbacks_id)
                              );

--changeset wjkb-13:7
create table barber_weekends (
    barber_id uuid not null,
    day_and_time_id uuid not null
                             );

--changeset wjkb-13:8
create table client (
    id uuid not null,
    amount varchar,
    birth_date varchar(15),
    email varchar(100),
    first_name varchar(100),
    last_name varchar(100),
    login varchar(100),
    password varchar,
    phone_number varchar(20),
    deposit_id uuid,
    primary key (id)
                    );

--changeset wjkb-13:9
create table client_appointments (
    client_id uuid not null,
    appointments_id uuid not null,
    primary key (client_id, appointments_id)
                                 );

--changeset wjkb-13:10
create table client_feedbacks (
    client_id uuid not null,
    feedbacks_id uuid not null,
    primary key (client_id, feedbacks_id)
                              );

--changeset wjkb-13:11
create table deposit (
    id uuid not null,
    deposit_name varchar,
    money_pool varchar,
    barber_id uuid,
    client_id uuid,
    primary key (id)
                     );

--changeset wjkb-13:12
create table feedback (
    id uuid not null,
    comment varchar(1000),
    rate smallint,
    appointment_id uuid,
    primary key (id)
                      );

--changeset wjkb-13:13
create table service_type (
    id uuid not null,
    description varchar,
    name varchar,
    primary key (id)
                          );

--changeset wjkb-13:14
create table service_type_appointments (
    service_type_id uuid not null,
    appointments_id uuid not null,
    primary key (service_type_id, appointments_id)
                                       );

--changeset wjkb-13:15
create table day_and_time (
    id uuid not null,
    starts_from bigint,
    ends_with bigint,
    primary key (id)
                          );