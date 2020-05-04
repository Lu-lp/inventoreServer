# 创建用户表
create table if not exists sys_user
(
    user_id         int       not null AUTO_INCREMENT,
    gender      int       not null comment '性别: 0男，1女',
    username  varchar(16)     not null comment '姓名',
    account varchar(64)  not null comment '登录账户',
    password varchar(64) not null comment  '登录密码',
    phone_number varchar(16)      comment '联系电话',
    role_id       int       not null comment '职务id',
    status int not null default  1 comment '用户状态',
    description varchar(255) comment '用户描述',
    create_time timestamp  default current_timestamp comment '创建时间',
    update_time timestamp  default current_timestamp on update current_timestamp comment '更新时间',
    primary key (user_id)
);
insert into sys_user(gender,username,account,password,phone_number,role_id,description)
            values (0, 'admin', 'admin',123456,13911112222,1,'super manager');
# 创建角色表
create table if not exists role
(
    role_id int(11) NOT NULL AUTO_INCREMENT,
    role_name varchar(255) NOT NULL,
    PRIMARY KEY (role_id)
);
insert into role(role_name)
    values ('ROLE_ADMIN'),('ROLE_SALEMANAGER'),
           ('ROLE_PURCHASINGMANAGER'),('ROLE_STOCKMANAGER');

# 创建角色用户表关联表
create table if not exists user_role
(
  user_id int not null comment '用户id',
  role_id int not null comment '角色id',
  primary key (user_id,role_id)

);
insert into user_role(user_id, role_id) values(1,1);
#创建供应商信息表

create table if not exists supplier
(
    supplier_id int not null auto_increment,
    supplier_name varchar(64) not null comment '供应商公司名称',
    contact varchar(16) not null comment  '联系人',
    phone_number varchar(16) not null comment '联系电话',
    address varchar(64) not null comment  '联系地址',
    description varchar(255) comment  '供应商公司描述',
    create_time timestamp  default current_timestamp comment '创建时间',
    update_time timestamp  default current_timestamp on update current_timestamp comment '更新时间',
    primary key (supplier_id)
);
insert into supplier(supplier_name,contact,phone_number,address)
            values('momogongsi','xiaozhang',6666666,'zhongguo');
#创建客户信息表
create table if not exists customer
(
    customer_id int not null auto_increment,
    customer_name varchar(64) not null comment '客户公司名称',
    contact varchar(16) not null comment  '联系人',
    phone_number varchar(16) not null comment '联系电话',
    address varchar(64) not null comment  '联系地址',
    description varchar(255) comment  '客户公司描述',
    create_time timestamp  default current_timestamp comment '创建时间',
    update_time timestamp  default current_timestamp on update current_timestamp comment '更新时间',
    primary key (customer_id)
);
insert into customer(customer_name,contact,phone_number,address)
            values('kehugongsi','xiaowang',9999999,'fujiansheng');
#创建商品信息表
create table if not exists product
(
    product_id int not null auto_increment,
    product_name varchar(64) not null comment '商品名称',
    brand varchar(64) not null comment '商品品牌',
    size varchar(8) not null comment '商品规格',
    description varchar(255) comment '描述',
    status int not null default  1 comment '状态',
    stock int not null comment '库存数量',
    price decimal not null comment '售价',
    create_time timestamp  default current_timestamp comment '创建时间',
    update_time timestamp  default current_timestamp on update current_timestamp comment '更新时间',
    primary key (product_id)
);
insert into product(product_name,brand,size,stock,price)
            values('jiubei','zhongda','big',0,100);
#创建采购订单表
create table if not exists purchase_order
(
    purchase_order_id int not null auto_increment,
    product_id int not null comment '商品id',
    product_name varchar(64) not null comment '商品名称',
    supplier_id int not null comment  '供应商id',
    supplier_name varchar(64) not null comment '供应商名称',
    order_number timestamp not null default current_timestamp comment '订单号',
    unit_price decimal(10,2) not null comment '单价',
    number int not null comment '数量',
    total_price decimal(10,2) not null comment '总价',
    description varchar(255) comment '描述',
    status int not null default  0 comment '状态{0:待审核；1: 审核成功待入库;2: 订单完成; -1: 订单取消}',
    auditor varchar(16) comment '审核人',
    audit_result int comment '审核结果',
    audit_time timestamp comment '审核时间',
    rukuren varchar(16) comment '入库人/出库人',
    ruku_time timestamp comment '入库时间/出库时间',
    creator varchar(16)  not null comment '创建人',
    create_time timestamp  default current_timestamp comment '创建时间',
    update_time timestamp  default current_timestamp on update current_timestamp comment '更新时间',
    type int not null comment '订单类型：1采购or0退货',
    primary key (purchase_order_id)
);
#创建销售订单信息表
create table if not exists sale_order
(
    sale_order_id int not null auto_increment,
    product_id int not null comment '商品id',
    product_name varchar(64) not null comment '商品名称',
    customer_id int not null comment  '客户id',
    customer_name varchar(64) not null comment '客户名称',
    order_number timestamp not null default current_timestamp comment '订单号',
    unit_price decimal(10,2) not null comment '单价',
    number int not null comment '数量',
    total_price decimal(10,2) not null comment '总价',
    description varchar(255) comment '描述',
    status int not null default  1 comment '状态{0:待审核；1: 审核成功待入库;2: 订单完成; -1: 订单取消}',
    auditor varchar(16) comment '审核人',
    audit_result int comment '审核结果',
    audit_time timestamp comment '审核时间',
    rukuren varchar(16) comment '入库人/出库人',
    ruku_time timestamp comment '入库时间/出库时间',
    creator varchar(16)  not null comment '创建人',
    create_time timestamp  default current_timestamp comment '创建时间',
    update_time timestamp  default current_timestamp on update current_timestamp comment '更新时间',
    type int not null comment '订单类型：1销售or0退货',
    primary key (sale_order_id)
);
