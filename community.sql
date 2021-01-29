/*
Navicat MySQL Data Transfer

Source Server         : cust
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : community

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2021-01-29 11:59:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ad
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) DEFAULT NULL,
  `url` varchar(512) DEFAULT NULL,
  `image` varchar(256) DEFAULT NULL,
  `gmt_start` bigint(20) DEFAULT NULL,
  `gmt_end` bigint(20) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `pos` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `type` int(11) NOT NULL,
  `commentator` bigint(20) NOT NULL,
  `gmt_create` bigint(20) NOT NULL,
  `gmt_modified` bigint(20) NOT NULL,
  `like_count` bigint(20) DEFAULT '0',
  `content` varchar(1024) DEFAULT NULL,
  `comment_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '1', '1611827757874', '1611827757874', '0', '111', '1');
INSERT INTO `comment` VALUES ('2', '1', '2', '1', '1611829716137', '1611829716137', '0', 'aa', null);
INSERT INTO `comment` VALUES ('3', '1', '1', '1', '1611890383964', '1611890383964', '0', '1', '0');
INSERT INTO `comment` VALUES ('4', '1', '1', '3', '1611890414346', '1611890414346', '0', '2', '0');

-- ----------------------------
-- Table structure for nav
-- ----------------------------
DROP TABLE IF EXISTS `nav`;
CREATE TABLE `nav` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `url` varchar(256) DEFAULT NULL,
  `priority` int(11) DEFAULT '0',
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nav
-- ----------------------------

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `notifier` bigint(20) NOT NULL,
  `receiver` bigint(20) NOT NULL,
  `outerid` bigint(20) NOT NULL,
  `type` int(11) NOT NULL,
  `gmt_create` bigint(20) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `notifier_name` varchar(100) DEFAULT NULL,
  `outer_title` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notification
-- ----------------------------
INSERT INTO `notification` VALUES ('1', '3', '1', '1', '1', '1611890414350', '0', '卡特', 'a');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `description` text,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `creator` bigint(255) NOT NULL,
  `comment_count` int(11) DEFAULT '0',
  `view_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  `tag` varchar(256) DEFAULT NULL,
  `sticky` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', 'a', 'a', '1611826630615', '1611826630615', '1', '3', '39', '0', 'javascript', '1');
INSERT INTO `question` VALUES ('2', 'aaa', 'aaa', '1611827909651', '1611827909651', '3', '0', '1', '0', 'php', '0');

-- ----------------------------
-- Table structure for tourist
-- ----------------------------
DROP TABLE IF EXISTS `tourist`;
CREATE TABLE `tourist` (
  `user_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_code` varchar(32) NOT NULL COMMENT '用户账号',
  `user_name` varchar(50) NOT NULL COMMENT '用户名称',
  `user_email` varchar(32) NOT NULL COMMENT '用户密码',
  `user_password` varchar(32) NOT NULL,
  `user_state` int(1) DEFAULT NULL COMMENT '1:正常,0:暂停',
  `user_photo` varchar(6666) DEFAULT NULL,
  `exp` varchar(50) NOT NULL DEFAULT '魂师',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tourist
-- ----------------------------
INSERT INTO `tourist` VALUES ('1', 'ljq', '刘建峤', '2492112242@qq.com', '03b2cb341146988d5cf16a1d6a7925d4', '1', '\\images\\logo.png', '封号斗罗');
INSERT INTO `tourist` VALUES ('2', 'woshinibaba', '我是', '2055281269@qq.com', 'ae9187902d0936438399c2543a6e3ed3', '1', '\\images\\2345_image_file_copy_1.jpg', '魂师');
INSERT INTO `tourist` VALUES ('3', 'kate', '卡特', '209998777@qq.com', 'ae9187902d0936438399c2543a6e3ed3', '1', '\\images\\A9F417BD-4622-4D34-A921-EF5E698B487D.jpeg', '魂斗罗');
INSERT INTO `tourist` VALUES ('4', 'aaad', 'aaad', 'aaad', 'aa836f154f3bf01eed8df286a1fbb388', '1', '\\images\\aaad.jpg', '魂师');
INSERT INTO `tourist` VALUES ('8', 'ljqaaa', 'aaa', 'aaaaa', '47bce5c74f589f4867dbd57e9ca9f808', '1', '\\images\\zzxz(1).jpg', '魂师');
INSERT INTO `tourist` VALUES ('9', '18010211', '18010211', '209988@m', '47bce5c74f589f4867dbd57e9ca9f808', '1', '\\images\\CFD43586-EE12-4D1B-8846-87325B04A00D.jpeg', '魂师');
INSERT INTO `tourist` VALUES ('11', '785014205', 'stonebone', '785014205@qq.com', 'f0fb068c1e485dc623567e6b38c65665', '1', '\\images\\u=3363295869,2467511306&fm=26&gp=0.jpg', '魂师');
INSERT INTO `tourist` VALUES ('16', 'aa', 'sssa', '', 'd41d8cd98f00b204e9800998ecf8427e', '1', '\\images\\(31)', '魂师');
INSERT INTO `tourist` VALUES ('17', 'aaaaaaaaaaa', 'sssssssss', '20565281269@qq.com', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', '1', '\\images\\WIN_20200917_21_04_49_Pro.jpg', '魂师');
INSERT INTO `tourist` VALUES ('18', 'woshiliu', '我的小ba', '2492112242@qq.com', 'ae9187902d0936438399c2543a6e3ed3', '1', '\\images\\zzxz(2).jpg', '魂尊');
INSERT INTO `tourist` VALUES ('19', 'wwoshiljq', '阿木木', '205252121@qq.com', 'ae9187902d0936438399c2543a6e3ed3', '1', '\\images\\AMM.jpg', '魂师');
INSERT INTO `tourist` VALUES ('20', 'lll', 'ss', '202', '123', '1', null, '魂师');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `token` varchar(36) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `bio` varchar(256) DEFAULT NULL,
  `avatar_url` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '73102272', null, '43ddea2e-713a-40bd-860b-b4a938ef7b46', '1611829551278', '1611829836454', null, null);
