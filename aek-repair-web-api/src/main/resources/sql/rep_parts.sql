/*
Navicat MySQL Data Transfer

Source Server         : 6446
Source Server Version : 50718
Source Host           : mysqlcluster.aek.com:6446
Source Database       : repair_dev

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-19 13:56:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rep_parts
-- ----------------------------
DROP TABLE IF EXISTS `rep_parts`;
CREATE TABLE `rep_parts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构id',
  `kind_code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '分类编码',
  `kind_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '分类名称',
  `update_man` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) DEFAULT NULL COMMENT '启用状态（0未启用 1启用）',
  `remarks` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `custom_data` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='配件分类表';
