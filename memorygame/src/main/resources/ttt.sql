-- we don't know how to generate schema memsaga (class Schema) :(
create table t_game
(
  id bigint auto_increment
    primary key,
  name varchar(255) null
)
engine=MyISAM
;

create table t_memory_game
(
  pair_count int null,
  id bigint not null
    primary key,
  one_id bigint null,
  two_id bigint null
)
engine=MyISAM
;

create index FK7npmai9ucvtqkmteetedip34s
  on t_memory_game (two_id)
;

create index FK94lv60teg33h4akt97ppxj5jl
  on t_memory_game (one_id)
;

create table t_player
(
  id bigint not null
    primary key
)
engine=MyISAM
;

create table t_user
(
  id bigint auto_increment
    primary key,
  first_name varchar(255) null,
  last_name varchar(255) null
)
engine=MyISAM
;



INSERT INTO memsaga.t_user (id, first_name, last_name) VALUES (1, 'Ana', 'Dimitrijevic');
INSERT INTO memsaga.t_user (id, first_name, last_name) VALUES (2, 'Manja', 'Miljevic');

INSERT INTO memsaga.t_player (id) VALUES (1);
INSERT INTO memsaga.t_player (id) VALUES (2);