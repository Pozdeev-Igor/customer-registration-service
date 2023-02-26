--liquibase formatted sql

--changeset wjkb-13:15
alter table if exists barber_appointments add constraint UK_s3payd39jlmv7d187ncifdfxr unique (appointments_id);
--changeset wjkb-13:16
alter table if exists barber_feedbacks drop constraint if exists UK_tn36glee9nu4m0s6m74qv8vj6;
alter table if exists barber_feedbacks add constraint UK_tn36glee9nu4m0s6m74qv8vj6 unique (feedbacks_id);
--changeset wjkb-13:17
alter table if exists client_appointments drop constraint if exists UK_ecd0tdtpotdp0ixwa1x6rannk;
alter table if exists client_appointments add constraint UK_ecd0tdtpotdp0ixwa1x6rannk unique (appointments_id);
--changeset wjkb-13:18
alter table if exists client_feedbacks drop constraint if exists UK_hx56puyiddqo6hbo9ni0ct8a9;
alter table if exists client_feedbacks add constraint UK_hx56puyiddqo6hbo9ni0ct8a9 unique (feedbacks_id);
--changeset wjkb-13:19
alter table if exists service_type_appointments drop constraint if exists UK_rh101482d0ruglgvm2ulpp0m3;
alter table if exists service_type_appointments add constraint UK_rh101482d0ruglgvm2ulpp0m3 unique (appointments_id);
--changeset wjkb-13:20
alter table if exists appointment add constraint FKmnyoncbc9dic1sb8awa0y64d5 foreign key (barber_id) references barber;
--changeset wjkb-13:21
alter table if exists appointment add constraint FK3gbqcfd3mnwwcit63lybpqcf8 foreign key (client_id) references client;
--changeset wjkb-13:22
alter table if exists appointment add constraint FK1j8fti0mrcx37oyeisde4jqls foreign key (day_and_time_id) references day_and_time;
--changeset wjkb-13:23
alter table if exists appointment add constraint FKq4dt8y3uehw8vtsde62wk1h0r foreign key (feedback_id) references feedback;
--changeset wjkb-13:31
alter table if exists appointment add constraint FKs3yieb1gxfqp3bdwq6224ktf2 foreign key (service_type_id) references service_type;
--changeset wjkb-13:32
alter table if exists barber add constraint FKh99mgwkxwhn50fnoejjkam7sa foreign key (deposit_id) references deposit;
--changeset wjkb-13:33
alter table if exists barber_appointments add constraint FKt7cka17h694oynt776vfhe7o0 foreign key (appointments_id) references appointment;
--changeset wjkb-13:34
alter table if exists barber_appointments add constraint FKm411gmag2t89gpug1d42vfbmy foreign key (barber_id) references barber;
--changeset wjkb-13:35
alter table if exists barber_can_serve add constraint FKk1qyvjxkudj3drtvi9h69ucim foreign key (can_serve_id) references service_type;
--changeset wjkb-13:36
alter table if exists barber_can_serve add constraint FK7ru2n42eddr2tvtn1eqt9it2c foreign key (barber_id) references barber;
--changeset wjkb-13:37
alter table if exists barber_feedbacks add constraint FK8ao9e18r1tgdp4lpp75rpvrjy foreign key (feedbacks_id) references feedback;
--changeset wjkb-13:38
alter table if exists barber_feedbacks add constraint FKgraeq86jkp2bg2grjsx0oel6f foreign key (barber_id) references barber;
--changeset wjkb-13:39
alter table if exists barber_weekends add constraint FKdufj86xcou7cjn0bbncf14es6 foreign key (day_and_time_id) references day_and_time;
--changeset wjkb-13:40
alter table if exists barber_weekends add constraint FKa1mn85xgyo8ky0k78ikq9l1k5 foreign key (barber_id) references barber;
--changeset wjkb-13:41
alter table if exists client add constraint FKhs11j1mnwrfj4fo694iuyryh0 foreign key (deposit_id) references deposit;
--changeset wjkb-13:42
alter table if exists client_appointments add constraint FKf2s3le3dtxkm9dtwvv79rgs9n foreign key (appointments_id) references appointment;
--changeset wjkb-13:43
alter table if exists client_appointments add constraint FKem5ms0dngydjgrvmmhq5u888i foreign key (client_id) references client;
--changeset wjkb-13:44
alter table if exists client_feedbacks add constraint FKjegcjvrmxb1nq2t5yvm63eetc foreign key (feedbacks_id) references feedback;
--changeset wjkb-13:45
alter table if exists client_feedbacks add constraint FK3kedr2tnbtyi6rs09gujwk2mi foreign key (client_id) references client;
--changeset wjkb-13:46
alter table if exists deposit add constraint FK5j1mikahsb7jtjq7wkwlhxcf4 foreign key (barber_id) references barber;
--changeset wjkb-13:47
alter table if exists deposit add constraint FKey7qgtdvk8nipnlgbuagofnqc foreign key (client_id) references client;
--changeset wjkb-13:48
alter table if exists feedback add constraint FK9wfgrg1xqrkfk32mwisl37o0v foreign key (appointment_id) references appointment;
--changeset wjkb-13:49
alter table if exists service_type_appointments add constraint FK86pnj18vfcul3nw2ewutnlvaw foreign key (appointments_id) references appointment;
--changeset wjkb-13:50
alter table if exists service_type_appointments add constraint FK31ejev85kstu07ci73iippfnj foreign key (service_type_id) references service_type;