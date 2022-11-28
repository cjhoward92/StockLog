-- Primary database schema
drop database if exists stocklog;
create database stocklog;

-- Cleanup for re-run
drop table if exists trades;
drop table if exists trade_types;
drop table if exists prices;
drop table if exists assets;
drop table if exists asset_types;
drop table if exists users;

-- Users
create table users (
    id bigserial primary key,
    username varchar(100) not null,
    name varchar(200) not null,
    password_hash varchar not null,
    password_salt varchar not null,
    last_login_at timestamp null,
    created_at timestamp not null default NOW()
);

create unique index users_username_uidx on users (username);

-- Trade types
create table trade_types (
    id int primary key,
    type_name varchar(20) not null
);
insert into trade_types(id, type_name) values(1, 'Long');
insert into trade_types(id, type_name) values(2, 'Short');

-- Asset types
create table asset_types (
    id serial primary key,
    name varchar(100) not null
);

create unique index asset_types_name_uidx on asset_types (name);

insert into asset_types(name) values('Futures Contract');
insert into asset_types(name) values('Option');
insert into asset_types(name) values('Forex');
insert into asset_types(name) values('Stock');

-- Assets
create table assets (
    id bigserial primary key,
    name varchar(100) not null,
    type_id int not null,
    constraint trades_asset_type_id_fk foreign key (type_id) references asset_types(id)
);

create unique index assets_name_type_id_uidx on assets (name, type_id);
create index assets_name on assets (name);

-- Trades
create table trades (
    id bigserial primary key,
    user_id bigint not null,
    asset_id bigint not null,
    trade_type_id int not null,
    enter_date date not null,
    enter_price decimal(19,4) not null,
    enter_atr decimal(19,4) null,
    stop_loss_price decimal(19,4) null,
    exit_date date null,
    exit_price decimal(19,4) null,
    profit_and_loss decimal(19,4) null,
    notes text null,
    created_at timestamp not null default NOW(),
    updated_at timestamp null,
    constraint trades_user_id_fk foreign key (user_id) references users(id),
    constraint trades_trade_type_id_fk foreign key (trade_type_id) references trade_types(id),
    constraint trades_asset_id_fk foreign key (asset_id) references assets(id)
);

create index trades_user_id_asset_id_idx on trades (user_id, asset_id);

-- Prices
create table prices (
    asset_id bigint not null,
    capture_date date not null,
    capture_time time not null,
    price decimal(19,4) not null,
    volume bigint null,
    primary key(asset_id, capture_date, capture_time),
    constraint trades_asset_id_fk foreign key (asset_id) references assets(id)
);