create table sys_menu
(
    id        int auto_increment comment '编号'
        primary key,
    parent_id int        default 0 not null comment '父级ID',
    name      varchar(50)          not null comment '名称',
    type      tinyint(1) default 0 not null comment '0=目录 1=菜单 2=权限',
    icon      varchar(200)         null comment '图标',
    remark    varchar(200)         null comment '备注',
    order_num int                  not null comment '排序值',
    perms     varchar(1024)        null comment '权限字符',
    view_path varchar(1024)        null comment '页面路径',
    is_show   tinyint(1) default 1 not null comment '0=隐藏 1=显示',
    create_at datetime             not null comment '创建时间',
    update_at datetime             null comment '更新时间',
    delete_at datetime             null comment '删除时间'
)
    comment '权限 & 菜单';

create table sys_role
(
    id         int auto_increment comment '编号'
        primary key,
    name       varchar(50)  not null comment '名称',
    unique_key varchar(50)  not null comment '唯一标识',
    status     tinyint(1)   not null comment '0=禁用 1=开启',
    remark     varchar(200) null comment '备注',
    order_num  int          not null comment '排序值',
    create_at  datetime     not null comment '创建时间',
    update_at  datetime     null comment '更新时间',
    delete_at  datetime     null comment '删除时间'
)
    comment '角色';

create table sys_role_menu
(
    role_id int not null comment '角色ID',
    menu_id int not null comment '权限ID',
    primary key (role_id, menu_id)
)
    comment '角色&权限关联表';

create table sys_user
(
    id        int auto_increment comment '用户编号'
        primary key,
    account   varchar(50)  not null comment '账号',
    password  char(32)     not null comment '密码',
    username  varchar(50)  null comment '姓名',
    nickname  varchar(50)  null comment '昵称',
    avatar    varchar(400) null comment '头像',
    gender    tinyint(1)   not null comment '性别 0=保密 1=女 2=男',
    email     varchar(50)  null comment '邮件',
    mobile    char(11)     null comment '手机号',
    status    tinyint(1)   not null comment '0=禁用 1=开启',
    remark    varchar(200) null comment '备注',
    order_num int          null comment '排序值',
    create_at datetime     not null comment '创建时间',
    update_at datetime     null comment '更新时间',
    delete_at datetime     null comment '删除时间'
);

create table sys_user_role
(
    user_id int not null comment 'ID',
    role_id int not null comment '角色ID',
    primary key (user_id, role_id)
)
    comment '用户角色关联表';

