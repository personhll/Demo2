drop table if exists test;
create table test(
                     id  bigint not null comment  'id',
                     name varchar(50) comment  '名字',
                     password varchar(50) comment  '密码',
                     create_time datetime comment '创建日期',
                     update_time datetime comment '更新日期',
                     primary key (id)
)engine=innodb default charset=utf8mb4 comment '测试';