/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = ''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */`xuyang` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xuyang`;


drop table if exists `t_blog`;

create table `t_blog`
(
    `id`            bigint(20) not null auto_increment,
    `picture`       varchar(225) default null,
    `title`         varchar(225) default null,
    `content`       longtext,
    `views`         int(11)      default null,
    `comment_count` int(11)      default null,
    `update_time`   datetime     default null,
    `commentable`   bit(1)       default null,
    `recommend`     bit(1)       default null,
    `type_id`       bigint(20)   default null,
    `description`   varchar(225) default null,
    primary key (`id`) using btree,
    key `type_id` (`type_id`) using btree,
    constraint `type_id` foreign key (`type_id`) references `t_type` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  default charset = utf8
  row_format = dynamic;

drop table if exists `t_type`;

create table `t_type`
(
    `id`   bigint(20)   not null auto_increment,
    `name` varchar(225) not null,
    primary key (`id`) using btree
) engine = InnoDB
  auto_increment = 2
  default charset = utf8
  row_format = dynamic;

drop table if exists `t_comment`;

create table `t_comment`
(
    `id`                bigint(20) not null auto_increment,
    `email`             varchar(225) default null,
    `nick_name`         varchar(225) default null,
    `content`           longtext,
    `avatar`            varchar(225) default null,
    `create_time`       datetime     default null,
    `blog_id`           bigint(20)   default null,
    `parent_comment_id` bigint(20)   default null,
    `parent_nick_name`  varchar(225) default null,
    `admin_comment`     bit(1)       default null,
    primary key (`id`) using btree
) engine = InnoDB
  auto_increment = 2
  default charset = utf8
  row_format = dynamic;

drop table if exists `t_friend`;

create table `t_friend`
(
    `id`           bigint(20) not null auto_increment,
    `link_des`     varchar(225) default null,
    `link_address` varchar(225) default null,
    `avatar`       varchar(225) default null,
    primary key (`id`) using btree
) engine = InnoDB
  auto_increment = 2
  default charset = utf8
  row_format = dynamic;

drop table if exists `t_message`;

create table `t_message`
(
    `id`                bigint(20) not null auto_increment,
    `email`             varchar(225) default null,
    `nick_name`         varchar(225) default null,
    `content`           longtext,
    `avatar`            varchar(225) default null,
    `create_time`       datetime     default null,
    `parent_message_id` bigint(20)   default null,
    `parent_nick_name`  varchar(225) default null,
    `admin_message`     bit(1)       default null,
    primary key (`id`) using btree
) engine = InnoDB
  auto_increment = 2
  default charset = utf8
  row_format = dynamic;

drop table if exists `t_user`;

create table `t_user`
(
    `id`          bigint(20) not null auto_increment,
    `nick_name`   varchar(225) default null,
    `user_name`   varchar(225) default null,
    `pass_word`   varchar(225) default null,
    `email`       varchar(225) default null,
    `avatar`      varchar(225) default null,
    `is_admin`    int(11)      default null,
    `create_time` datetime     default null,
    PRIMARY KEY (`id`) using btree
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC;
