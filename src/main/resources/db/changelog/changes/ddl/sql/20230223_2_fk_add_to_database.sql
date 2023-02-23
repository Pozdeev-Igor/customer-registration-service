--liquibase formatted sql

--changeset wjkb-13:15
alter table barber_weekends drop constraint if exists UK_9gnnjuahboupgmbqcs8uush7d;

--changeset wjkb-13:16
alter table barber_weekends add constraint UK_9gnnjuahboupgmbqcs8uush7d unique (weekends_id);

--changeset wjkb-13:17
alter table barber_feedback drop constraint if exists UK_n1kqljo90tpxt161f40pkfi8f;

--changeset wjkb-13:18
alter table barber_feedback add constraint UK_n1kqljo90tpxt161f40pkfi8f unique (feedback_id);

--changeset wjkb-13:19
alter table clients_appointments drop constraint if exists UK_5qyl58jonipvc4xqm6pu4nxxf;

--changeset wjkb-13:20
alter table clients_appointments add constraint UK_5qyl58jonipvc4xqm6pu4nxxf unique (appointment_id);

--changeset wjkb-13:21
alter table client_feedbacks drop constraint if exists UK_hx56puyiddqo6hbo9ni0ct8a9;

--changeset wjkb-13:22
alter table client_feedbacks add constraint UK_hx56puyiddqo6hbo9ni0ct8a9 unique (feedback_id);

--changeset wjkb-13:23
alter table appointment add constraint FKmnyoncbc9dic1sb8awa0y64d5 foreign key (barber_id) references barber;