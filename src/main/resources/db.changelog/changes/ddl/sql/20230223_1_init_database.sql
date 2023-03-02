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

create table barber (
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

create table barber_can_serve (
                                  barber_id uuid not null,
                                  can_serve_id uuid not null,
                                  primary key (barber_id, can_serve_id)
);

create table barber_weekends (
                                 barber_id uuid not null,
                                 day_and_time_id uuid not null
);

create table client (
                        id uuid not null,
                        amount varchar(255),
                        birth_date varchar(20),
                        email varchar(100),
                        first_name varchar(100),
                        last_name varchar(100),
                        password varchar(100),
                        phone_number varchar(20),
                        primary key (id)
);

create table day_and_time (
                              id uuid not null,
                              starts_from int8,
                              ends_with int8,
                              primary key (id)
);

create table deposit (
                         id uuid not null,
                         deposit_name varchar(255),
                         money_pool varchar(255),
                         barber_id uuid,
                         client_id uuid,
                         primary key (id)
);

create table feedback (
                          id uuid not null,
                          comment varchar(1000),
                          rate int2,
                          appointment_id uuid,
                          primary key (id)
);

create table service_type (
                              id uuid not null,
                              description varchar(255),
                              name varchar(255),
                              primary key (id)
);

create table service_type_appointments (
                                           service_type_id uuid not null,
                                           appointments_id uuid not null,
                                           primary key (service_type_id, appointments_id)
);
