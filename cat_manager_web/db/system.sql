CREATE TABLE SYS_CODE(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	CODE_MODULE VARCHAR(36) NOT NULL COMMENT '代码模块',
	CODE_TYPE VARCHAR(36) NOT NULL COMMENT '代码类型',
	CODE_DESC VARCHAR(150) NOT NULL COMMENT '代码描述',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='系统代码表';

CREATE TABLE SYS_AREA_SETTING(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	AREA_CODE VARCHAR(36) NOT NULL COMMENT '地区编号',
	AREA_DESC VARCHAR(36) NOT NULL COMMENT '地区描述',
	AREA_LEVEL INT NOT NULL COMMENT '地区级别',
	PARENT_AREA_CODE VARCHAR(36) NOT NULL COMMENT '父地区编号',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='地区配置表';

/**
 * 用户模块
 */
CREATE TABLE SYS_USER_MANAGER(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='用户编号管理表';

CREATE TABLE WEIXIN_LOGIN_INFO(
        OBJECT_ID int primary key AUTO_INCREMENT COMMENT '编号',
        USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
        WEIXIN_ID varchar(100) COMMENT '微信号',
        OPEN_ID varchar(100) COMMENT 'OPENID',
        USER_NAME varchar(100) COMMENT '用户名',
        WEIXIN_NAME varchar(100) COMMENT '微信名称',
        WEIXIN_IMAGE_URL varchar(100) COMMENT '微信头像路径',
        UNION_ID varchar(100) COMMENT 'UNIONID',
        CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
	    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
	    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
	    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='微信登录表';

CREATE TABLE QQ_LOGIN_INFO(
        OBJECT_ID int primary key AUTO_INCREMENT COMMENT '编号',
        USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
        QQ_ID varchar(100) COMMENT 'QQ号',
        OPEN_ID varchar(100) COMMENT 'OPENID',
        USER_NAME varchar(100) COMMENT '用户名',
        QQ_NAME varchar(100) COMMENT 'QQ名称',
        QQ_IMAGE_URL varchar(100) COMMENT 'QQ头像路径',
        UNION_ID varchar(100) COMMENT 'UNIONID',
        CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
	    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
	    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
	    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='QQ登录表';


CREATE TABLE SYS_USER_INFO(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
	SEX VARCHAR(10) COMMENT '性别',
	PROVINCE VARCHAR(36) COMMENT '省份',
	CITY_OR_AREA VARCHAR(36) COMMENT '市/区',
	PHONE_NO VARCHAR(15) COMMENT '手机号码',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='用户信息表';

CREATE TABLE USER_ADDR_INFO(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
	PROVINCE VARCHAR(36) NOT NULL COMMENT '省',
	CITY VARCHAR(36) NOT NULL COMMENT '市',
	AREA VARCHAR(36) NOT NULL COMMENT '区',
	STREET VARCHAR(36) NOT NULL COMMENT '街道',
	DETAILED_ADDRESS VARCHAR(255) NOT NULL COMMENT '详细地址',
	IS_DEFULT VARCHAR(2) DEFAULT 'N' COMMENT '是否默认地址',
	ADDRESSEE VARCHAR(36) NOT NULL COMMENT '收件人',
	PHONE_NO VARCHAR(15) NOT NULL COMMENT '手机号码',
	POST_CODE VARCHAR(36) NOT NULL COMMENT '邮政编号',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='用户收货地址信息表';

CREATE TABLE SYS_LOGIN_LOG(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
	DEVICE_ID VARCHAR(36) COMMENT '设备号',
	LOGIN_TYPE VARCHAR(36) COMMENT '登录类型(登陆(LOGIN)/退出(OUT))',
	IP_ADDR VARCHAR(36)  COMMENT 'IP地址',
	LOGIN_MODE VARCHAR(36) NOT NULL COMMENT '登录方式(微信(W)/QQ(Q))',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='登录日志表';


CREATE TABLE SYS_USER_SESSION(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
	DEVICE_ID VARCHAR(36) COMMENT '设备号',
	LOGIN_TYPE VARCHAR(36) NOT NULL COMMENT '登录类型',
	LOGIN_MODE VARCHAR(36) NOT NULL COMMENT '登录方式',
	TOKEN VARCHAR(1000) NOT NULL COMMENT 'token值',
	EXPIRATION_TIME DATETIME NOT NULL COMMENT '用户过期时间',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='用户登录会话表';


CREATE TABLE SYS_USER_DEVICE(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	DEVICE_ID VARCHAR(36) COMMENT '设备号',
	DEVICE VARCHAR(36) COMMENT '设备',
	USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
	CLIENT_V VARCHAR(36) COMMENT '客户端版本',
	APP_VERSION VARCHAR(36) COMMENT 'APP版本',
	IP_ADDR VARCHAR(36) COMMENT 'IP地址',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='用户设备记录表';


CREATE TABLE USER_ACCOUNT_MANAGER(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
	CAT_MONEY INT  COMMENT '金币',
	CAT_DNF INT COMMENT '点卷',
	CAT_DIAMOND INT COMMENT '钻石',
	CAT_INTEGRAL INT COMMENT '积分',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='用户账户管理表';

/**
 * 任务模块
 */
CREATE TABLE SYS_MISSION_MANAGE(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	MISS_TITLE VARCHAR(36) NOT NULL COMMENT '任务标题',
	MISS_TYPE VARCHAR(15) NOT NULL COMMENT '任务类型',
	MISS_CONTENT VARCHAR(255) NOT NULL COMMENT '任务内容',
	MISS_GO_URL VARCHAR(255) COMMENT '任务跳转路劲',
	MISS_IMG_URL VARCHAR(255) COMMENT '任务图片链接',
	TROPHY_DESC VARCHAR(255) COMMENT '奖品描述',
	MISS_VALID_TIME DATETIME COMMENT '任务有效时间',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='系统任务管理表';

CREATE TABLE SYS_MISSION_PLAN(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	MAIN_MISS_ID INT NOT NULL COMMENT '主任务编号',
	MISS_TITLE VARCHAR(36) NOT NULL COMMENT '任务标题',
	MISS_TYPE VARCHAR(15) NOT NULL COMMENT '任务类型',
	MISS_CONTENT VARCHAR(255) NOT NULL COMMENT '任务内容',
	MISS_ORDER  VARCHAR(15) NOT NULL COMMENT '任务执行顺序',
	MISS_GO_URL VARCHAR(255) COMMENT '任务跳转路劲',
	MISS_IMG_URL VARCHAR(255) COMMENT '任务图片链接',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='系统任务计划表';

CREATE TABLE MISSION_TROPHY(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	MAIN_MISS_ID INT NOT NULL COMMENT '主任务编号',
	TROPHY_TYPE VARCHAR(36) NOT NULL COMMENT '奖品类型',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='任务对应奖品表';


CREATE TABLE USER_MISSION_PLAN(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	MAIN_MISS_ID INT NOT NULL COMMENT '主任务编号',
	SUB_MISS_ID INT NOT NULL COMMENT '从任务编号',
	USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='用户任务完成计划表';

/**
 * 系统猫模块
 */
CREATE TABLE CAT_SPECIES(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	SPECIES_ID VARCHAR(36) NOT NULL COMMENT '种类编号',
	SPECIES_DESC VARCHAR(150) NOT NULL COMMENT '种类描述',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='系统猫种类';

CREATE TABLE CAT_BODY(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	SPECIES_ID VARCHAR(36) NOT NULL COMMENT '种类编号',
	BODY_TYPE VARCHAR(36) NOT NULL COMMENT '体型',
	BODY_DESC VARCHAR(150) NOT NULL COMMENT '体型描述',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='系统猫体型表';

CREATE TABLE CAT_HAIR(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	SPECIES_ID VARCHAR(36) NOT NULL COMMENT '种类编号',
	HAIR_TYPE VARCHAR(36) NOT NULL COMMENT '毛发类型',
	HAIR_DESC VARCHAR(150) NOT NULL COMMENT '毛发描述',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='系统猫毛长表';

CREATE TABLE CAT_SKIN(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	SPECIES_ID VARCHAR(36) NOT NULL COMMENT '种类编号',
	SKIN_TYPE VARCHAR(36) NOT NULL COMMENT '皮肤类型',
	SKIN_DESC VARCHAR(255) NOT NULL COMMENT '皮肤描述',
	SKIN_BROWSE_URL VARCHAR(255) NOT NULL COMMENT '皮肤效果链接',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='系统猫皮肤管理表';


CREATE TABLE CAT_CHIP(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	SPECIES_ID VARCHAR(36) NOT NULL COMMENT '种类编号',
	CHIP_TYPE VARCHAR(36) NOT NULL COMMENT '碎片类型',
	CHIP_DESC VARCHAR(255) NOT NULL COMMENT '碎片描述',
	CHIP_IMG_URL VARCHAR(255) NOT NULL COMMENT '碎片图片路径',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='系统猫碎片';

CREATE TABLE CAT_FOOD(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	SPECIES_ID VARCHAR(36) NOT NULL COMMENT '种类编号',
	FOOD_TYPE VARCHAR(36) NOT NULL COMMENT '食物类型',
	FOOD_DESC VARCHAR(255) NOT NULL COMMENT '食物描述',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='系统猫食物表';

CREATE TABLE USER_CAT(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
	CAT_SPECIES_ID VARCHAR(36) NOT NULL COMMENT '猫种类编号',
	DEFAULT_CAT_SEL VARCHAR(10) NOT NULL COMMENT '默认猫选择',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='用户对应猫管理';

CREATE TABLE USER_CAT_SKIN(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	USER_NO VARCHAR(36) NOT NULL COMMENT '用户编号',
	CAT_SPECIES_ID VARCHAR(36) NOT NULL COMMENT '种类编号',
	CAT_SKIN_TYPE VARCHAR(36) NOT NULL COMMENT '皮肤类型',
	DEFAULT_SKIN_SEL VARCHAR(10) NOT NULL COMMENT '默认猫皮肤选择',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='用户对应猫皮肤管理';


/**
 * 商品模块
 */

CREATE TABLE SHOP_CLASS(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	SHOP_TYPE VARCHAR(15) NOT NULL COMMENT '商品类型',
	SHOP_TYPE_DESC VARCHAR(150) NOT NULL COMMENT '商品类型描述',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='商品分类管理表';


CREATE TABLE SHOP_MANAGER(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	SHOP_TYPE VARCHAR(15) NOT NULL COMMENT '商品类型',
	SHOP_NO VARCHAR(36) NOT NULL COMMENT '商品编号',
	SHOP_NAME VARCHAR(36) NOT NULL COMMENT '商品名称',
	SHOP_IMG_URL VARCHAR(255) NOT NULL COMMENT '商品图片地址',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='商品管理表'; 

CREATE TABLE ORDER_MANAGER(
	OBJECT_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	SHOP_NO VARCHAR(36) NOT NULL COMMENT '商品编号',
	ORDER_NO VARCHAR(36) NOT NULL COMMENT '订单编号',
	PAY_TYPE VARCHAR(10) NOT NULL COMMENT '支付类型',
	CREATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '创建人',
    CREATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    UPDATED_BY VARCHAR(150) NOT NULL DEFAULT 'SYSTEM' COMMENT '更新人',
    UPDATED_DATE DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期'
)COMMENT='订单管理';













