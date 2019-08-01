CREATE DATABASE mybatis_action_db DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE country
(
  id          INT          NOT NULL AUTO_INCREMENT,
  countryname VARCHAR(255) NULL,
  countrycode VARCHAR(255) NULL,
  PRIMARY KEY (id)
)ENGINE=INNODB  DEFAULT CHARSET=utf8;