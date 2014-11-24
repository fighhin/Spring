/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2014-11-24 16:33:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MSG` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log
-- ----------------------------
INSERT INTO t_log VALUES ('1', 'a user saved!');
INSERT INTO t_log VALUES ('2', 'a user saved!');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(24) DEFAULT NULL,
  `PASSWORD` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO t_user VALUES ('1', 'admin', '123456');
INSERT INTO t_user VALUES ('2', 'admin2', '123456');
INSERT INTO t_user VALUES ('3', 'admin3', '123456');
INSERT INTO t_user VALUES ('5', 'somnus', '123456');
INSERT INTO t_user VALUES ('6', 'somnus', '123456');
