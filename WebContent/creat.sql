CREATE SCHEMA `Service` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `Service`.`user_basic` (
  `user_id` varchar(45) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_pwd` VARCHAR(45) NOT NULL,
  `user_age` INT NULL,
  `user_image` longblob not null,
  `user_sex` varchar(10) not null,
  `user_mail` VARCHAR(45) NOT NULL,
  `user_tel` VARCHAR(45) NOT NULL,
  `user_power` VARCHAR(45)  NOT NULL,
  PRIMARY KEY (`user_id`));
create table  `Service`.`member`(
	`user_id` varchar(45) not null,
	primary key (`user_id`));
create table `Service`.`user_service`(
	`user_id` varchar(45) not null,
	primary key(`user_id`));
	
create table `Service`.`goods`(
	`sku` varchar(45) not null,
	`name` varchar(45) not null,
	`marketPrice` double,
	`shopPrice` double,
	`introdcution` varchar(60),
	`desciption` varchar(100),
	`thumbail` longblob,
	`smallImage` longblob,
	`bigImage` longblob,
	`isOnSale` int not null,
	`kind` varchar(45) not null,
	`stock` int null,
	primary key (`sku`));
	
create table `Service`.`kinds`(
	`kind_id` int not null,
	`kind_name` varchar(45) not null,
	primary key (`kind_id`));
create table `Service`.`shoppingCart`(
	`id` varchar(45) not null,
	`sku` varchar(45),
	`total` double not null,
	primary key (`id`));

create table `Service`.`ordering`(
	`id` varchar(45) not null,
	`sku` varchar(45),
	`total` double not null,
	primary key (`id`));

create table `Service`.orderLast(
`id` varchar(45) not null,
	`sku` varchar(45),
	`total` double not null,
	primary key (`id`));
