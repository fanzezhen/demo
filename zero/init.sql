CREATE DATABASE IF NOT EXISTS demo DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use demo;

# log
drop table if exists log_exception;

drop table if exists log_login;

drop table if exists log_operation;

/*==============================================================*/
/* Table: log_exception                                         */
/*==============================================================*/
create table log_exception
(
    id                   varchar(50) not null,
    username             varchar(15) not null comment '用户名',
    log_type             tinyint comment '日志类型',
    modular              varchar(20) comment '资源所属模块',
    class_name           varchar(20) comment '错误类名',
    message              varchar(20) comment '错误说明',
    stack_trace          text comment '错误堆栈',
    create_user_id       varchar(50) not null comment '创建人ID',
    create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
    app_code             varchar(5) comment '应用代码',
    primary key (id)
);

alter table log_exception comment '异常日志表';

/*==============================================================*/
/* Table: log_login                                             */
/*==============================================================*/
create table log_login
(
    id                   varchar(50) not null,
    username             varchar(15) not null comment '用户名',
    log_type             tinyint comment '1--登录成功； 2--登录失败； 3--退出登录',
    ip                   varchar(20) comment 'ip',
    os                   varchar(20) comment '操作系统',
    browser_name         varchar(15) comment '浏览器名称',
    browser_version      varchar(15) comment '浏览器版本',
    remark               varchar(15) comment '备注',
    create_user_id       varchar(50) comment '创建人ID',
    create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
    app_code             varchar(5) comment '应用代码',
    primary key (id)
);

alter table log_login comment '登录日志表';

/*==============================================================*/
/* Table: log_operation                                         */
/*==============================================================*/
create table log_operation
(
    id                   varchar(50) not null,
    username             varchar(15) not null comment '用户名',
    log_type             tinyint not null comment '日志类型（1-增；2-删；3-改）',
    modular              varchar(20) comment '资源所属模块',
    resource_id          varchar(50) comment '资源ID',
    method_name          varchar(50) comment '方法名',
    remark               text comment '备注',
    create_user_id       varchar(50) not null comment '创建人ID',
    create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
    app_code             varchar(5) comment '应用代码',
    primary key (id)
);

alter table log_operation comment '操作日志表';

# sys
drop table if exists sys_dict;

drop table if exists sys_permission;

drop table if exists sys_role;

drop table if exists sys_role_permission;

drop table if exists sys_user;

drop table if exists sys_user_role;

/*==============================================================*/
/* Table: sys_dict                                              */
/*==============================================================*/
create table sys_dict
(
    id                   varchar(50) not null comment '主键',
    table_field          varchar(20) not null comment '字段全名（表名_字段名）',
    dict_code            varchar(20) not null comment '字典代码',
    dict_name            varchar(20) not null comment '代码名称',
    dict_desc            varchar(50) comment '详细说明',
    app_code             varchar(20) comment '所属应用',
    order_num            tinyint not null default 1 comment '排序优先级',
    create_user_id       varchar(50) comment '创建人ID',
    create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
    del_flag             tinyint not null default 0 comment '是否删除（0--否；1--是）',
    primary key (id),
    unique key uk_sys_dict_field_code (table_field, dict_code)
);

alter table sys_dict comment '系统字典表';

/*==============================================================*/
/* Table: sys_permission                                        */
/*==============================================================*/
create table sys_permission
(
    id                   varchar(64) not null comment '主键',
    pid                  varchar(64) not null default '0' comment '上级ID',
    icon                 varchar(16) comment 'icon',
    code                 varchar(32) comment '权限代码',
    name                 varchar(64) not null comment '名称',
    status               tinyint default 0 comment '状态（0--可用；1--未用）',
    operation_url        varchar(255) comment '请求地址',
    type                 tinyint default 1 comment '是否为菜单（1--菜单；2--按钮）',
    order_num            tinyint default 1 comment '排序优先级',
    del_flag             tinyint not null default 0 comment '是否删除（0--否；1--是）',
    create_user_id       varchar(64) comment '填表人ID',
    update_user_id       varchar(64) comment '最后更新人ID',
    create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
    update_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    app_code             varchar(16) comment '所属应用代码',
    primary key (id)
);

alter table sys_permission comment '菜单、按钮表';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
    id                   varchar(64) not null,
    role_name            varchar(64) not null comment '角色名',
    role_code            varchar(32) comment '角色代码',
    role_type            tinyint not null default 2 comment '角色类型',
    del_flag             tinyint not null default 0 comment '是否删除（0--否；1--是）',
    description          varchar(255) comment '释义',
    status               tinyint not null default 0 comment '状态（0--正常；1--停用）',
    create_time          timestamp not null default CURRENT_TIMESTAMP comment '注册时间',
    update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    create_user_id       varchar(64) comment '填表人ID',
    update_user_id       varchar(64) comment '最后更新人ID',
    app_code             varchar(16) comment '所属应用代码',
    primary key (id),
    unique key uq_sys_role_code_df (role_code, del_flag)
);

alter table sys_role comment '系统角色表';

/*==============================================================*/
/* Table: sys_role_permission                                   */
/*==============================================================*/
create table sys_role_permission
(
    id                   varchar(64) not null comment '主键',
    role_id              varchar(64) not null comment '角色ID',
    permission_id        varchar(64) not null comment '权限ID',
    create_user_id       varchar(64) comment '创建人ID',
    create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
    primary key (id),
    unique key uk_role_permission_role_id_permission_id (role_id, permission_id)
);

alter table sys_role_permission comment '角色权限关联表';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
    id                   varchar(50) not null,
    username             varchar(16) not null comment '用户名',
    password             varchar(64) not null comment '密码',
    nickname             varchar(64) not null default '昵称' comment '昵称',
    avatar               varchar(255) comment '头像地址',
    email                varchar(255) comment '邮箱',
    phone                varchar(16) comment '联系电话',
    sex                  tinyint not null default 3 comment '性别（0--女；1--男；2--未知的性别；3--未说明的性别）',
    department           varchar(50) comment '所属部门',
    del_flag             tinyint not null default 0 comment '是否删除（0--否；1--是）',
    status               tinyint not null default 0 comment '状态（0--正常；1--停用）',
    last_time            timestamp not null default CURRENT_TIMESTAMP comment '最后操作时间',
    create_time          timestamp not null default CURRENT_TIMESTAMP comment '注册时间',
    update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    create_user_id       varchar(64) comment '填表人ID',
    update_user_id       varchar(64) comment '最后更新人ID',
    app_code             varchar(16) comment '所属应用代码',
    primary key (id),
    unique key uk_username_df (username, del_flag)
);

alter table sys_user comment '系统用户表';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
    id                   varchar(64) not null comment '主键',
    user_id              varchar(64) not null comment '用户ID',
    role_id              varchar(64) not null comment '角色ID',
    create_user_id       varchar(64) comment '创建人ID',
    create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
    primary key (id),
    unique key uk_user_role_user_id_role_id (user_id, role_id)
);

alter table sys_user_role comment '系统用户角色表';
