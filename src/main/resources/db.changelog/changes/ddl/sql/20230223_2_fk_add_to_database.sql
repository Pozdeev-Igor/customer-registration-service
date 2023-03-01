--liquibase formatted sql

--changeset wjkb-13:3
alter table service_type_appointments add constraint UK_rh101482d0ruglgvm2ulpp0m3 unique (appointments_id);

alter table appointment add constraint FKmnyoncbc9dic1sb8awa0y64d5 foreign key (barber_id) references barber;
alter table appointment add constraint FK3gbqcfd3mnwwcit63lybpqcf8 foreign key (client_id) references client;
alter table appointment add constraint FKknubtaym81loju5bs1pqxurkx foreign key (day_and_time_id) references day_and_time;
alter table appointment add constraint FKq4dt8y3uehw8vtsde62wk1h0r foreign key (feedback_id) references feedback;
alter table appointment add constraint FKs3yieb1gxfqp3bdwq6224ktf2 foreign key (service_type_id) references service_type;
alter table barber add constraint FKh99mgwkxwhn50fnoejjkam7sa foreign key (deposit_id) references deposit;
alter table barber_can_serve add constraint FKk1qyvjxkudj3drtvi9h69ucim foreign key (can_serve_id) references service_type;
alter table barber_can_serve add constraint FK7ru2n42eddr2tvtn1eqt9it2c foreign key (barber_id) references barber;
alter table barber_weekends add constraint FKjw9f3jv6xeviibwa4aty366ip foreign key (day_and_time_id) references day_and_time;
alter table barber_weekends add constraint FKa1mn85xgyo8ky0k78ikq9l1k5 foreign key (barber_id) references barber;
alter table deposit add constraint FK5j1mikahsb7jtjq7wkwlhxcf4 foreign key (barber_id) references barber;
alter table deposit add constraint FKey7qgtdvk8nipnlgbuagofnqc foreign key (client_id) references client;
alter table feedback add constraint FK9wfgrg1xqrkfk32mwisl37o0v foreign key (appointment_id) references appointment;
alter table service_type_appointments add constraint FK86pnj18vfcul3nw2ewutnlvaw foreign key (appointments_id) references appointment;
alter table service_type_appointments add constraint FK31ejev85kstu07ci73iippfnj foreign key (service_type_id) references service_type;