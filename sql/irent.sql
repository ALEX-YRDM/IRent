create database  if not exists rent;
use rent;
create table t_renter(
                         id bigint(20) primary key auto_increment,
                         nickname varchar(255) not null unique,
                         username varchar(255) not null unique,
                         password varchar(255) not null,
                         gender int default 0,
                         phoneNumber varchar(255) not null unique,
                         email varchar(255) not null,
                         address varchar(255) not null,
                         birthday datetime not null
)ENGINE =InnoDB CHARSET =utf8;

create table t_landlord(
                           id bigint(20) primary key auto_increment,
                           nickname varchar(255) not null unique,
                           username varchar(255) not null unique,
                           password varchar(255) not null,
                           phoneNumber varchar(255) not null unique,
                           email varchar(255) not null,
                           address varchar(255) not null
)ENGINE =InnoDB CHARSET =utf8;

create table t_house(
                        id bigint(20) primary key auto_increment,
                        landlord_id bigint(20),
                        title varchar(255) not null,
                        address varchar(255) not null,
                        houseType varchar(255) not null,
                        rooms int not null default 0,
                        money double not null  default 0,
                        photo varchar(255) not null,
                        updateTime timestamp,
                        state int not null,
                        constraint fk_house_landlord foreign key (landlord_id) references t_landlord(id)
)ENGINE =InnoDB CHARSET =utf8;

create table t_record(
                         id bigint(20) primary key auto_increment,
                         r_id bigint(20),
                         l_id bigint(20),
                         h_id bigint(20),
                         tradeTime timestamp,
                         foreign key (r_id) references t_renter(id),
                         foreign key (l_id) references t_landlord(id),
                         foreign key (h_id) references t_house(id)
)ENGINE =InnoDB CHARSET =utf8;



