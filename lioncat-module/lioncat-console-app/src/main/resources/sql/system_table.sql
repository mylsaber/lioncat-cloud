DROP TABLE IF EXISTS `SYS_USER`;
CREATE TABLE `SYS_USER`
(
    `ID`                   int unsigned auto_increment comment '自增主键',
    `ACCOUNT`              varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '账号',
    `PASSWORD`             varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '密码',
    `TYPE`                 tinyint unsigned comment '用户类型',
    `AVATAR`               varchar(255) character set utf8mb4 collate utf8mb4_general_ci null comment '头像',
    `NICKNAME`             varchar(255) character set utf8mb4 collate utf8mb4_general_ci      default null comment '昵称',
    `GENDER`               tinyint unsigned                                                   default 0 comment '性别',
    `BIRTHDAY`             date                                                               default null comment '出生日期',
    `PHONE`                varchar(11) character set utf8mb4 collate utf8mb4_general_ci       default null comment '手机',
    `EMAIL`                varchar(255) character set utf8mb4 collate utf8mb4_general_ci      default null comment '邮箱',
    `LAST_LOGIN_IP`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上次登录ip',
    `LAST_LOGIN_ADDRESS`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上次登录地点',
    `LAST_LOGIN_TIME`      datetime                                                      NULL DEFAULT NULL COMMENT '上次登录时间',
    `LAST_LOGIN_DEVICE`    text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         NULL COMMENT '上次登录设备',
    `LATEST_LOGIN_IP`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最新登录ip',
    `LATEST_LOGIN_ADDRESS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最新登录地点',
    `LATEST_LOGIN_TIME`    datetime                                                      NULL DEFAULT NULL COMMENT '最新登录时间',
    `LATEST_LOGIN_DEVICE`  text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         NULL COMMENT '最新登录设备',
    `USER_STATUS`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户状态',
    `SORT_CODE`            int unsigned                                                  NULL DEFAULT NULL COMMENT '排序码',
    `EXT_JSON`             longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NULL COMMENT '扩展信息',
    `DELETE_FLAG`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标志',
    `CREATE_TIME`          datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    `CREATE_USER`          varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '创建用户',
    `UPDATE_TIME`          datetime                                                      NULL DEFAULT NULL COMMENT '修改时间',
    `UPDATE_USER`          varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '修改用户',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '用户'
  ROW_FORMAT = DYNAMIC;



DROP TABLE IF EXISTS `SYS_ROLE`;
CREATE TABLE `SYS_ROLE`
(
    `ID`          int unsigned auto_increment comment '自增主键',
    `NAME`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci not null COMMENT '名称',
    `CODE`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci not null COMMENT '编码',
    `SORT_CODE`   int unsigned                                                  NULL DEFAULT NULL COMMENT '排序码',
    `EXT_JSON`    longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NULL COMMENT '扩展信息',
    `DELETE_FLAG` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标志',
    `CREATE_TIME` datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    `CREATE_USER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '创建用户',
    `UPDATE_TIME` datetime                                                      NULL DEFAULT NULL COMMENT '修改时间',
    `UPDATE_USER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '修改用户',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '角色'
  ROW_FORMAT = DYNAMIC;


DROP TABLE IF EXISTS `SYS_RESOURCE`;
CREATE TABLE `SYS_RESOURCE`
(
    `ID`          int unsigned auto_increment comment '自增主键',
    `PARENT_ID`   int unsigned                                                       default null COMMENT '父id',
    `TITLE`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
    `CODE`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
    `MENU_TYPE`   tinyint unsigned                                              not null COMMENT '菜单类型',
    `PATH`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      default null COMMENT '路径',
    `COMPONENT`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      DEFAULT NULL COMMENT '组件',
    `ICON`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      DEFAULT NULL COMMENT '图标',
    `COLOR`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      DEFAULT NULL COMMENT '颜色',
    `SORT_CODE`   int unsigned                                                       DEFAULT NULL COMMENT '排序码',
    `EXT_JSON`    longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NULL COMMENT '扩展信息',
    `DELETE_FLAG` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标志',
    `CREATE_TIME` datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    `CREATE_USER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '创建用户',
    `UPDATE_TIME` datetime                                                      NULL DEFAULT NULL COMMENT '修改时间',
    `UPDATE_USER` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '修改用户',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '资源'
  ROW_FORMAT = DYNAMIC;


DROP TABLE IF EXISTS `SYS_RELATION`;
CREATE TABLE `SYS_RELATION`
(
    `ID`        int unsigned auto_increment comment '自增主键',
    `OBJECT_ID` int unsigned                                              not null COMMENT '对象ID',
    `TARGET_ID` int unsigned                                              not null COMMENT '目标ID',
    `CATEGORY`  tinyint unsigned                                          not null COMMENT '关系分类',
    `EXT_JSON`  longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '扩展信息',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '关系'
  ROW_FORMAT = DYNAMIC;