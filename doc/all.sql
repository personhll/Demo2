drop table if exists test;
create table test(
                     id  bigint not null comment  'id',
                     name varchar(50) comment  '名字',
                     password varchar(50) comment  '密码',
                     create_time datetime comment '创建日期',
                     update_time datetime comment '更新日期',
                     primary key (id)
)engine=innodb default charset=utf8mb4 comment '测试';


drop table if exists product;
create table product(
                     id  bigint not null comment  'id' auto_increment,
                     prod_code varchar(50) comment  '产品编码',
                     prod_name varchar(50) comment  '产品名称',
                     prod_price int comment '单价',
                     create_time datetime comment '创建日期',
                     update_time datetime comment '更新日期',
                     primary key (id)
)engine=innodb default charset=utf8mb4 comment '产品';