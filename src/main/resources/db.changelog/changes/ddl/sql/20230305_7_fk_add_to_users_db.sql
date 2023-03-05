--liquibase formatted sql

--changeset wjkb-13:6
alter table appointment drop constraint FK3gbqcfd3mnwwcit63lybpqcf8;
alter table appointment add constraint FK3gbqcfd3mnwwcit63lybpqcf8 foreign key (client_id) references users;

alter table appointment drop constraint FKmnyoncbc9dic1sb8awa0y64d5;
alter table appointment add constraint FKmnyoncbc9dic1sb8awa0y64d5 foreign key (barber_id) references users;

alter table deposit drop constraint FK5j1mikahsb7jtjq7wkwlhxcf4;
alter table deposit add constraint FK5j1mikahsb7jtjq7wkwlhxcf4 foreign key (barber_id) references users;

alter table deposit drop constraint FKey7qgtdvk8nipnlgbuagofnqc;
alter table deposit add constraint FKey7qgtdvk8nipnlgbuagofnqc foreign key (client_id) references users;

alter table barber_weekends drop constraint FKa1mn85xgyo8ky0k78ikq9l1k5;
alter table barber_weekends add constraint FKa1mn85xgyo8ky0k78ikq9l1k5 foreign key (barber_id) references users;

alter table barber_can_serve drop constraint FK7ru2n42eddr2tvtn1eqt9it2c;
alter table barber_can_serve add constraint FK7ru2n42eddr2tvtn1eqt9it2c foreign key (barber_id) references users;
