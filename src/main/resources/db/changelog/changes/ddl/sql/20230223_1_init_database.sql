--liquibase formatted sql

--changeset wjkb-13:2
create table barber (
                        id  uuid not null,
                        amount varchar,
                        email varchar(100),
                        first_name varchar(50),
                        is_active boolean,
                        last_name varchar(50),
                        login varchar(50),
                        password varchar(50),
                        phone_number varchar(15),
                        deposit_id uuid,
                        primary key (id)
);

--changeset wjkb-13:3
create table barber_weekends (
                                 barber_id uuid not null,
                                 weekends_id uuid not null,
                                 primary key (barber_id, weekends_id)
);

--changeset wjkb-13:4
create table barber_feedback (
                                 barber_id uuid not null,
                                 feedback_id uuid not null,
                                 primary key (barber_id, feedback_id)
);

--changeset wjkb-13:5
create table barber_services (
                                 barber_id uuid not null,
                                 services_id uuid not null,
                                 primary key (barber_id, services_id)
);

--changeset wjkb-13:6
create table client (
                        id  uuid not null,
                        amount varchar,
                        birth_date varchar(20),
                        email varchar(100),
                        first_name varchar(50),
                        last_name varchar(50),
                        login varchar(50),
                        password varchar(50),
                        phone_number varchar(15),
                        deposit_id uuid,
                        primary key (id)
);

--changeset wjkb-13:7
create table clients_appointments (
                                      client_id uuid not null,
                                      appointment_id uuid not null,
                                      primary key (client_id, appointment_id)
);

--changeset wjkb-13:8
create table client_feedbacks (
                                  client_id uuid not null,
                                  feedback_id uuid not null,
                                  primary key (client_id, feedback_id)
);

--changeset wjkb-13:9
create table day_and_time (
                              id  uuid not null,
                              appointment_id uuid,
                              barber_id uuid,
                              client_id uuid,
                              primary key (id)
);

--changeset wjkb-13:10
create table days_and_calendar_list (
                                        day_and_time_id uuid not null,
                                        calendar timestamp
);

--changeset wjkb-13:11
create table deposit (
                         id  uuid not null,
                         deposit_name varchar,
                         money_pool varchar,
                         barber_id uuid,
                         client_id uuid,
                         primary key (id)
);

--changeset wjkb-13:12
create table feedback (
                          id  uuid not null,
                          comment varchar(800),
                          rate int2,
                          appointment_id uuid,
                          barber_id uuid,
                          client_id uuid,
                          service_type_id uuid,
                          primary key (id)
);

--changeset wjkb-13:13
create table service_type (
                              id  uuid not null,
                              description varchar(800),
                              name varchar,
                              primary key (id)
);

--changeset wjkb-13:14
create table service_type_barbers (
                                      service_type_id uuid not null,
                                      barber_set_id uuid not null,
                                      primary key (service_type_id, barber_set_id)
);