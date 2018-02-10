CREATE DATABASE IF NOT EXISTS wxshopdb DEFAULT charset utf8 COLLATE utf8_general_ci;

create table `tb_area`(
    `area_id` int(2) not null auto_increment,
    `area_name` varchar(200) not null,
    `prority` int(2) not null default 0,
    `create_time` datetime default null,
    `last_edit_time` datetime default null,
    primary key(`area_id`),
    unique key `uk_area` (`area_name`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- add data
insert into tb_area(area_name,prority) values("江家村",1);
insert into tb_area(area_name,prority) values("西江村",2);