/*
Navicat MySQL Data Transfer

Source Server         : 6446
Source Server Version : 50718
Source Host           : mysqlcluster.aek.com:6446
Source Database       : repair_dev

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-19 13:57:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rep_parts_record
-- ----------------------------
DROP TABLE IF EXISTS `rep_parts_record`;
CREATE TABLE `rep_parts_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `report_id` bigint(20) DEFAULT NULL COMMENT '维修报告ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构id',
  `part_id` bigint(20) DEFAULT NULL COMMENT '关联配件Id',
  `part_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '配件名称',
  `part_spec` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '规格型号',
  `part_produce` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '配件生产商',
  `part_price` bigint(20) DEFAULT NULL COMMENT '配件单价',
  `unit_key` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '计数单位字典表',
  `num` smallint(3) DEFAULT NULL COMMENT '操作数量',
  `status` tinyint(1) DEFAULT NULL COMMENT '操作类型（1入库 2 出库）',
  `operation_time` datetime DEFAULT NULL COMMENT '操作时间',
  `custom_data` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配件操作记录表';
