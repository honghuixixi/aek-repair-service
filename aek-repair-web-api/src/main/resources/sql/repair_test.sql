/*
Navicat MySQL Data Transfer

Source Server         : sys
Source Server Version : 50718
Source Host           : 192.168.1.57:3306
Source Database       : repair_test

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-19 13:43:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for repair_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `repair_dictionary`;
CREATE TABLE `repair_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typeid` bigint(20) DEFAULT NULL COMMENT '关联类型',
  `key` bigint(20) DEFAULT NULL COMMENT '字典值',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '字典名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair_dictionary
-- ----------------------------
INSERT INTO `repair_dictionary` VALUES ('1', '1', '1001', '个');
INSERT INTO `repair_dictionary` VALUES ('2', '1', '1002', '盒');
INSERT INTO `repair_dictionary` VALUES ('3', '1', '1003', '支');
INSERT INTO `repair_dictionary` VALUES ('4', '2', '1004', '故障维修');
INSERT INTO `repair_dictionary` VALUES ('5', '2', '1005', '预防修性维修');
INSERT INTO `repair_dictionary` VALUES ('6', '2', '1006', '计量/检测后维修');
INSERT INTO `repair_dictionary` VALUES ('7', '3', '1007', '故障停机');
INSERT INTO `repair_dictionary` VALUES ('8', '3', '1008', '部分功能失效');
INSERT INTO `repair_dictionary` VALUES ('9', '3', '1009', '附件损坏');
INSERT INTO `repair_dictionary` VALUES ('10', '3', '1010', '不规则或偶发现象');
INSERT INTO `repair_dictionary` VALUES ('11', '3', '1011', '性能指标偏离');
INSERT INTO `repair_dictionary` VALUES ('12', '3', '1012', '开机后死机');
INSERT INTO `repair_dictionary` VALUES ('13', '3', '1013', '其他');
INSERT INTO `repair_dictionary` VALUES ('14', '4', '1014', '操作不当');
INSERT INTO `repair_dictionary` VALUES ('15', '4', '1015', '校正失调');
INSERT INTO `repair_dictionary` VALUES ('16', '4', '1016', '保养不当');
INSERT INTO `repair_dictionary` VALUES ('17', '5', '1017', '电源损坏');
INSERT INTO `repair_dictionary` VALUES ('18', '5', '1018', '保险丝熔断');
INSERT INTO `repair_dictionary` VALUES ('19', '5', '1019', '内部电路损坏');
INSERT INTO `repair_dictionary` VALUES ('20', '5', '1020', '机械传动部分损坏');
INSERT INTO `repair_dictionary` VALUES ('21', '5', '1021', '电机损坏');
INSERT INTO `repair_dictionary` VALUES ('22', '5', '1022', '记录器损坏');
INSERT INTO `repair_dictionary` VALUES ('23', '5', '1023', '显示器损坏');
INSERT INTO `repair_dictionary` VALUES ('24', '5', '1024', '附件损坏');
INSERT INTO `repair_dictionary` VALUES ('25', '5', '1025', '电池失效');
INSERT INTO `repair_dictionary` VALUES ('26', '5', '1026', '软件损坏');
INSERT INTO `repair_dictionary` VALUES ('27', '6', '1027', '电源');
INSERT INTO `repair_dictionary` VALUES ('28', '6', '1028', '温度');
INSERT INTO `repair_dictionary` VALUES ('29', '6', '1029', '湿度');
INSERT INTO `repair_dictionary` VALUES ('30', '6', '1030', '气源');
INSERT INTO `repair_dictionary` VALUES ('31', '6', '1031', '水源');
INSERT INTO `repair_dictionary` VALUES ('32', '6', '1032', '电磁干扰');
INSERT INTO `repair_dictionary` VALUES ('33', '7', '1033', '修理');
INSERT INTO `repair_dictionary` VALUES ('34', '7', '1034', '更换部件');
INSERT INTO `repair_dictionary` VALUES ('35', '7', '1035', '电路板更换');
INSERT INTO `repair_dictionary` VALUES ('36', '7', '1036', '附件更换');
INSERT INTO `repair_dictionary` VALUES ('37', '7', '1037', '调试与校正');
INSERT INTO `repair_dictionary` VALUES ('38', '7', '1038', '维护，保养');
INSERT INTO `repair_dictionary` VALUES ('39', '7', '1039', '软件重新设置与安装');
INSERT INTO `repair_dictionary` VALUES ('40', '7', '1040', '排除外界因素');
INSERT INTO `repair_dictionary` VALUES ('41', '7', '1041', '其他');
INSERT INTO `repair_dictionary` VALUES ('42', '8', '1042', '工作正常');
INSERT INTO `repair_dictionary` VALUES ('43', '8', '1043', '基本功能正常');
INSERT INTO `repair_dictionary` VALUES ('44', '8', '1044', '需要进一步修理');
INSERT INTO `repair_dictionary` VALUES ('45', '8', '1045', '需要外送修理');
INSERT INTO `repair_dictionary` VALUES ('46', '8', '1046', '无法修复');
INSERT INTO `repair_dictionary` VALUES ('47', '8', '1047', '其他');

-- ----------------------------
-- Table structure for repair_dictype
-- ----------------------------
DROP TABLE IF EXISTS `repair_dictype`;
CREATE TABLE `repair_dictype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair_dictype
-- ----------------------------
INSERT INTO `repair_dictype` VALUES ('1', '配件单位');
INSERT INTO `repair_dictype` VALUES ('2', '维修类型');
INSERT INTO `repair_dictype` VALUES ('3', '故障现象');
INSERT INTO `repair_dictype` VALUES ('4', '人为因素');
INSERT INTO `repair_dictype` VALUES ('5', '设备故障');
INSERT INTO `repair_dictype` VALUES ('6', '外界环境因素');
INSERT INTO `repair_dictype` VALUES ('7', '工作内容');
INSERT INTO `repair_dictype` VALUES ('8', '维修结果');

-- ----------------------------
-- Table structure for rep_message_receive
-- ----------------------------
DROP TABLE IF EXISTS `rep_message_receive`;
CREATE TABLE `rep_message_receive` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `message_id` bigint(20) DEFAULT NULL COMMENT '关联消息ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '接收人ID',
  `message_status` tinyint(1) DEFAULT NULL COMMENT '消息状态；0未查看1已查看',
  `custom_data` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息接收表';

-- ----------------------------
-- Records of rep_message_receive
-- ----------------------------

-- ----------------------------
-- Table structure for rep_repair_apply
-- ----------------------------
DROP TABLE IF EXISTS `rep_repair_apply`;
CREATE TABLE `rep_repair_apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `tenant_id` bigint(20) NOT NULL COMMENT '机构ID',
  `apply_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '维修申请单号',
  `assets_id` bigint(20) NOT NULL COMMENT '关联设备ID',
  `assets_dept_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '使用科室名称',
  `assets_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '设备名称',
  `assets_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '资产编号',
  `fault_desc` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '故障描述',
  `assets_img` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '设备图片路径，多图以，分割',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态，1:待故障判定、2:现场解决、3:待维修、4:以维修待验收、5:验收通过、6:验收不通过;',
  `urgent_level` tinyint(1) DEFAULT NULL COMMENT '紧急程度(1;2;3;4)',
  `report_repair_id` bigint(20) DEFAULT NULL COMMENT '报修申请人ID',
  `report_repair_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '申请人姓名',
  `report_repair_date` datetime DEFAULT NULL COMMENT '报修申请时间',
  `custom_data` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备维修申请表';

-- ----------------------------
-- Records of rep_repair_apply
-- ----------------------------

-- ----------------------------
-- Table structure for rep_repair_appraisal
-- ----------------------------
DROP TABLE IF EXISTS `rep_repair_appraisal`;
CREATE TABLE `rep_repair_appraisal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `apply_id` bigint(20) DEFAULT NULL COMMENT '关联申请单id',
  `identify_id` bigint(20) DEFAULT NULL COMMENT '鉴定人id',
  `identify_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '鉴定人姓名',
  `identify_date` datetime DEFAULT NULL COMMENT '鉴定时间',
  `scene_flag` tinyint(1) DEFAULT NULL COMMENT '现场解决1是2否',
  `repair_mode` tinyint(1) DEFAULT NULL COMMENT '1:内修；2：外修',
  `identify_coment` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '鉴定备注',
  `custom_data` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修鉴定表';

-- ----------------------------
-- Records of rep_repair_appraisal
-- ----------------------------

-- ----------------------------
-- Table structure for rep_repair_check
-- ----------------------------
DROP TABLE IF EXISTS `rep_repair_check`;
CREATE TABLE `rep_repair_check` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `apply_id` bigint(20) DEFAULT NULL COMMENT '关联申请单id',
  `repair_check_date` datetime DEFAULT NULL COMMENT '验收时间',
  `repair_attitude` tinyint(4) DEFAULT NULL COMMENT '维修态度',
  `response_speed` tinyint(4) DEFAULT NULL COMMENT '响应速度',
  `repair_quality` tinyint(4) DEFAULT NULL COMMENT '维修质量',
  `assess_coment` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '评价备注',
  `check_status` tinyint(1) DEFAULT NULL COMMENT '验收结果1，验收通过2，验收未通过',
  `assets_status` tinyint(4) DEFAULT NULL COMMENT '设备现况(1：正常工作；2：基本正常；3：其它)',
  `custom_data` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='验收详情表';

-- ----------------------------
-- Records of rep_repair_check
-- ----------------------------

-- ----------------------------
-- Table structure for rep_repair_message
-- ----------------------------
DROP TABLE IF EXISTS `rep_repair_message`;
CREATE TABLE `rep_repair_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `apply_id` bigint(20) DEFAULT NULL COMMENT '关联维修申请id',
  `message_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '消息内容',
  `message_time` datetime DEFAULT NULL COMMENT '消息时间',
  `assets_dept_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '输入科室',
  `assets_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '设备名称',
  `assets_id` bigint(20) DEFAULT NULL,
  `message_level` tinyint(1) DEFAULT NULL COMMENT '消息紧急程度',
  `custom_data` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息表';

-- ----------------------------
-- Records of rep_repair_message
-- ----------------------------

-- ----------------------------
-- Table structure for rep_repair_parts
-- ----------------------------
DROP TABLE IF EXISTS `rep_repair_parts`;
CREATE TABLE `rep_repair_parts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `report_id` bigint(20) NOT NULL COMMENT '维修报告ID',
  `part_id` bigint(20) DEFAULT NULL COMMENT '配件id',
  `part_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '配件编号',
  `part_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '配件名称',
  `part_produce` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '配件生产商',
  `part_spec` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '配件规格',
  `unit_key` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '计数单位字典表',
  `num` smallint(3) NOT NULL COMMENT '使用数量',
  `part_price` bigint(20) NOT NULL COMMENT '配件单价',
  `custom_data` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修配件表';

-- ----------------------------
-- Records of rep_repair_parts
-- ----------------------------

-- ----------------------------
-- Table structure for rep_repair_report
-- ----------------------------
DROP TABLE IF EXISTS `rep_repair_report`;
CREATE TABLE `rep_repair_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `apply_id` bigint(20) DEFAULT NULL COMMENT '关联申请单id',
  `repair_type_key` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联维修类型字典表',
  `fault_phenomenon_keys` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '故障现象Ids字典表',
  `fault_reason_keys` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '故障原因ids字典表',
  `work_content_keys` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '工作内容ids字典表',
  `repair_result_key` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '维修结果关联字典表',
  `repair_period_start` datetime DEFAULT NULL COMMENT '维修开始日期',
  `repair_period_end` datetime DEFAULT NULL COMMENT '维修结束日期',
  `parts_waiting_start` datetime DEFAULT NULL COMMENT '配件等待开始时间',
  `parts_waiting_end` datetime DEFAULT NULL COMMENT '配件等待结束时间',
  `actual_start` datetime DEFAULT NULL COMMENT '实际开始时间',
  `actual_end` datetime DEFAULT NULL COMMENT '实际结束时间',
  `repair_cost` bigint(20) DEFAULT NULL COMMENT '维修费用',
  `parts_cost` bigint(20) DEFAULT NULL COMMENT '材料费用',
  `total_cost` bigint(20) DEFAULT NULL COMMENT '总计',
  `repair_coment` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '维修备注',
  `repair_id` bigint(20) DEFAULT NULL COMMENT '维修人ID',
  `repair_name` varchar(20) DEFAULT NULL COMMENT '维修人名称',
  `repair_date` datetime DEFAULT NULL COMMENT '提交报告单时间',
  `custom_data` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修报告单表';

-- ----------------------------
-- Records of rep_repair_report
-- ----------------------------
