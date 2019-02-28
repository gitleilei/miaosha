/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : miaosha

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-02-27 18:40:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户自增ID',
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '用户姓名/昵称',
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1男2女',
  `age` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
  `telphone` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '用户电话/登陆账号',
  `register_mode` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '注册方式//byphone,bywechat,byalipay',
  `third_party_id` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '第三方ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '哈哈第一', '1', '26', '13521718488', 'byphone', '');
INSERT INTO `user_info` VALUES ('2', '哈哈第2', '2', '26', '13521788488', 'byphone', '');
INSERT INTO `user_info` VALUES ('3', '哈哈第3', '1', '16', '13520718488', 'byphone', '');
INSERT INTO `user_info` VALUES ('4', '哈哈第4', '2', '29', '13521618488', 'byphone', '');
INSERT INTO `user_info` VALUES ('5', '哈哈第5', '2', '22', '13521798488', 'byphone', '');

-- ----------------------------
-- Table structure for user_password
-- ----------------------------
DROP TABLE IF EXISTS `user_password`;
CREATE TABLE `user_password` (
  `id` int(11) NOT NULL,
  `encrpt_password` varchar(128) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_password
-- ----------------------------
