create table if not exists guest
(
  id serial not null
    constraint guest_pkey
      primary key,
  name varchar(30),
  age integer,
  city varchar(30),
  email varchar(2048),
  pass_hash varchar(100),
  card_id integer
);

create table if not exists card
(
  id serial not null
    constraint card_pkey
      primary key,
  owner integer
    constraint card_owner_fkey
      references guest,
  activated boolean,
  balance integer
);

alter table guest
  add constraint guest_card_id_fkey
    foreign key (card_id) references card;

create table if not exists drink
(
  id serial not null
    constraint drink_pkey
      primary key,
  name varchar(30)
);

create table if not exists coffeeshop
(
  id serial not null
    constraint coffeeshop_pkey
      primary key,
  city varchar(30),
  address varchar(150)
);

create table if not exists instructions
(
  id serial not null
    constraint instructions_pkey
      primary key,
  guest_id integer
    constraint instructions_guest_id_fkey
      references guest,
  date date,
  drink_id integer
    constraint instructions_drink_id_fkey
      references drink,
  coffeeshop_id integer
    constraint instructions_coffeeshop_id_fkey
      references coffeeshop,
  status varchar(10)
);

create table if not exists report
(
  id serial not null
    constraint report_pkey
      primary key,
  instruction_id integer
    constraint report_instruction_id_fkey
      references instructions,
  coffeeshop_id integer
    constraint report_coffeeshop_id_fkey
      references coffeeshop,
  guest_id integer
    constraint report_guest_id_fkey
      references guest,
  date date,
  queue_time interval,
  wait_time interval,
  barista_comment varchar(500),
  toilet_comment varchar(500),
  room_comment varchar(500),
  drink_comment varchar(500)
);

create table if not exists auth
(
  id serial not null
    constraint auth_pkey
      primary key,
  guest_id bigint
    constraint auth_guest_id_fkey
      references guest,
  cookie_value varchar(36)
);
