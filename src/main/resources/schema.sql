drop table if exists genre;
CREATE TABLE genre (
  id bigint auto_increment PRIMARY KEY,
  name varchar(255)
);

drop table if exists director;
CREATE TABLE director (
  id bigint auto_increment PRIMARY KEY,
  full_name varchar(255)
);

drop table if exists movie;
CREATE TABLE movie (
  id bigint auto_increment PRIMARY KEY,
  name varchar(255),
  director_id bigint,
  genre_id bigint,
  FOREIGN KEY (director_id) REFERENCES director (id),
  FOREIGN KEY (genre_id) REFERENCES genre (id)
);

drop table if exists user_access;
create table user_access(
    id bigint auto_increment primary key,
    user_login varchar(255),
    user_password varchar(255),
    user_role varchar(255)
);