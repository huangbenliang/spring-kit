create database 'spring_kit';

CREATE TABLE `student`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT comment 'id',
    `no`          varchar(15) DEFAULT NULL unique comment '学号',
    `first_name`  varchar(255) NOT NULL comment '姓',
    `last_name`   varchar(255) NOT NULL comment '名',
    `age`         tinyint     default null comment '年龄',
    `gender`      char(1)     default null comment '性别',
    `create_time` datetime    DEFAULT NULL comment '创建时间',
    `update_time` datetime    DEFAULT NULL comment '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8MB4;