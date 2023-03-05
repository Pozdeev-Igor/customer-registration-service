--liquibase formatted sql

--changeset wjkb-13:7
insert into users(id, amount, email, first_name, is_active, last_name, password, phone_number, rate)
    values
            ('a8b1403a-bb6c-11ed-afa1-0242ac120002', '0', 'example1@mail.ru', 'Petr', true, 'Ivanov', '$2a$12$WKlsbO77NUI3LMB9GZX3NusZ0j.JnRjRIkv70oTcox1t5qW0Uyz7C', '+78888566622', 0.0),
            ('a8b142ec-bb6c-11ed-afa1-0242ac120002', '0', 'example2@mail.ru', 'Ivan', true, 'Petrov', '$2a$12$oh7fpse3MjbNHNumT0ouBOmya7Od4RcB6pZrkb1DzlAzBScdqDQem', '+79998566622', 0.0),
            ('a8b14436-bb6c-11ed-afa1-0242ac120002', '0', 'example3@mail.ru', 'Danila', true, 'Badrov', '$2a$12$z8r4GeF7UY8.VzS/6HrFNu9dmgT1i8F8gqw0hedH1xp8HcEMJCk8i', '+78888566633', 0.0),
            ('a8b14576-bb6c-11ed-afa1-0242ac120002', '0', 'example4@mail.ru', 'Vasya', true, 'Erende', '$2a$12$OQ5t4vujTRHyK2sW5xMgdOTMC8lTveAqGBzMmo3YRpNjCYBOIYyQa', '+78888566655', 0.0),
            ('a8b146a2-bb6c-11ed-afa1-0242ac120002', '0', 'example5@mail.ru', 'Marya', true, 'Ivanova', '$2a$12$T87tc437xpHWr867Z.TnnOtutQUBJn5cM9/gB7HJ54DMorA08T4em', '+78888566669', 0.0);

insert into authority(id, authority, user_id)
    values
            ('0943b8ea-bb6f-11ed-afa1-0242ac120002', 'ROLE_CLIENT', 'a8b1403a-bb6c-11ed-afa1-0242ac120002'),
            ('0943bc00-bb6f-11ed-afa1-0242ac120002', 'ROLE_BARBER', 'a8b146a2-bb6c-11ed-afa1-0242ac120002'),
            ('0943bdd6-bb6f-11ed-afa1-0242ac120002', 'ROLE_ADMIN', 'a8b14436-bb6c-11ed-afa1-0242ac120002'),
            ('0943bf66-bb6f-11ed-afa1-0242ac120002', 'ROLE_CLIENT', 'a8b14576-bb6c-11ed-afa1-0242ac120002'),
            ('0943c10a-bb6f-11ed-afa1-0242ac120002', 'ROLE_CLIENT', 'a8b142ec-bb6c-11ed-afa1-0242ac120002');










