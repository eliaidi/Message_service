CREATE SCHEMA `Service` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `Service`.`user_basic` (
  `user_id` INT NOT NULL,
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
	`user_id` int not null,
	primary key (`user_id`));
create table `Service`.`user_service`(
	`user_id` int not null,
	primary key(`user_id`));
