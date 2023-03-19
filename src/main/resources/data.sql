insert into director (full_name)
values ('John Bunyan'),
       ('Gianni Rodari'),
       ('Daniel Defoe'),
       ('Danie Vilnev');

insert into genre (name)
values ('History'),
       ('Classic'),
       ('Fantasy'),
       ('Science fiction');

insert into movie (name, director_id, genre_id)
values ('The Pilgrim’s Progress', 1, 1),
       ('Robinson Crusoe', 2, 2),
       ('The Holy War', 1, 1),
       ('Dune', 2, 3);

insert into user_access(user_login, user_password, user_role)
values ('user', '$2y$10$EhbB1UnrN0oc/w9LF3oHDeLnl/xg1V49BAhoeddKUqDoi4ikiiu0W', 'USER'),('admin','$2y$10$97sedf3R3.TrbOiW1tNWVumGOxGcZWffeLdteNiqbv/TQ/X6XNB52','ADMIN');

