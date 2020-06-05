alter table tb_user modify status tinyint default 1 not null comment '状态';
alter table tb_course add status tinyint default 1 null;

