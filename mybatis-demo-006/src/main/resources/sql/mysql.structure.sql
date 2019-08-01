DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  user_name VARCHAR(50) COMMENT '用户名',
  user_password VARCHAR(50) COMMENT '密码',
  user_email VARCHAR(50) COMMENT '邮箱',
  user_info TEXT COMMENT '简介',
  head_img BLOB COMMENT '头像',
  create_time DATETIME COMMENT '创建时间',
  PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户表';

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role (
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  role_name VARCHAR(50) COMMENT '角色名',
  enabled TINYINT(1) COMMENT '有效标志',
  create_by VARCHAR(50) COMMENT '创建人',
  create_time DATETIME COMMENT '创建时间',
  PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '角色表';

DROP TABLE IF EXISTS sys_privilege;
CREATE TABLE sys_privilege (
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  privilege_name VARCHAR (50) COMMENT '权限名称',
  privilege_url VARCHAR (200) COMMENT '权限URL',
  PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '权限表';

DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role (
  user_id BIGINT(20) COMMENT '用户ID',
  role_id BIGINT(20) COMMENT '角色ID'
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户角色关联表';

DROP TABLE IF EXISTS sys_role_privilege;
CREATE TABLE sys_role_privilege (
  role_id BIGINT(20) COMMENT '角色ID',
  privilege_id BIGINT(20) COMMENT '权限ID'
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '角色权限关联表';

-- 默认邮箱
ALTER TABLE sys_user
MODIFY COLUMN user_email VARCHAR(50) NULL DEFAULT  'test@mybatis.tk'
COMMENT '邮箱'
AFTER user_password;

