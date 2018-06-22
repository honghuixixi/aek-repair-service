
CREATE TABLE `rep_repair_bill_parts` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `bill_id` bigint(20) DEFAULT NULL COMMENT '维修单据ID',
  `part_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '配件名称',
  `part_spec` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '规格型号',
  `part_produce` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '配件生产商',
  `part_price` decimal(20,2) DEFAULT NULL COMMENT '配件单价',
  `unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '计数单位',
  `num` int(3) DEFAULT NULL COMMENT '操作数量',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修单据配件记录表';


CREATE TABLE `rep_repair_bill_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `bill_id` int(11) DEFAULT NULL COMMENT '单据ID',
  `name` varchar(150) COLLATE utf8_bin DEFAULT NULL COMMENT '附件文件名称',
  `url` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '文件路径地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='维修单据附件表';

CREATE TABLE `rep_repair_bill_check_flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `bill_id` int(11) DEFAULT NULL COMMENT '单据ID',
  `flow_name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '流程名称',
  `check_user_id` int(11) DEFAULT NULL COMMENT '审核人ID',
  `check_user_name` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人姓名',
  `check_user_mobile` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人手机号',
  `index` int(11) DEFAULT NULL COMMENT '序号1,2,3......',
  `check_status` int(11) DEFAULT NULL COMMENT '审核状态(1=待审核，2=审核通过，3=审核未通过）',
  `check_remark` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '审核备注',
  `check_time` datetime DEFAULT NULL COMMENT '审核时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='维修单据审核流程表';



CREATE TABLE `rep_repair_bill_check_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` int(11) DEFAULT NULL COMMENT '所属机构ID',
  `check_user_id` int(11) DEFAULT NULL COMMENT '审核人ID',
  `check_user_mobile` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人手机号',
  `check_user_name` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '审批人姓名',
  `check_user_job` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人职务',
  `min_fee` decimal(20,2) DEFAULT NULL COMMENT '经费最小数值',
  `max_fee` decimal(20,2) DEFAULT NULL COMMENT '经费最大数值',
  `index` int(11) DEFAULT NULL COMMENT '层级（1=一级，2=二级，3=三级......）',
  `index_name` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '层级名称',
  `remark` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='维修单据审核配置表';

CREATE TABLE `rep_repair_bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` int(11) DEFAULT NULL COMMENT '机构ID',
  `tenant_name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '所属机构名称',
  `bill_no` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '单据编号',
  `type` int(1) DEFAULT NULL COMMENT '单据类型(1=外修费用,2=配件采购)',
  `status` int(1) DEFAULT NULL COMMENT '状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)',
  `apply_id` int(11) DEFAULT NULL COMMENT '维修申请单ID',
  `apply_no` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '维修单号',
  `apply_user_id` int(11) DEFAULT NULL COMMENT '申请人ID',
  `apply_user_name` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '单据申请人姓名',
  `apply_user_dept_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '申请人所在科室名称',
  `assets_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '维修设备名称',
  `assets_dept_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '设备使用科室名称',
  `assets_spec` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '设备规格',
  `serial_num` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '院内编码',
  `start_use_date` datetime DEFAULT NULL COMMENT '设备启用日期',
  `report_repair_date` datetime DEFAULT NULL COMMENT '维修申请日期',
  `external_repair_company` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '外修单位',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  `fee` decimal(20,2) DEFAULT NULL COMMENT '费用金额',
  `remark` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '申请备注（理由）',
  `current_index` int(11) DEFAULT NULL COMMENT '审批流程所处序号',
  `total_index` int(11) DEFAULT NULL COMMENT '单据所有的流程数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='维修单据表';

CREATE TABLE `rep_repair_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `repair_id` bigint(20) NOT NULL COMMENT '维修工程师id',
  `repair_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '维修工程师姓名',
  `mobile` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号码',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '所在科室id',
  `dept_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '所在科室名称',
  `job_id` int(11) DEFAULT NULL COMMENT '职务ID',
  `job_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '职务名称',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构id',
  `take_order_dept_id` bigint(20) DEFAULT NULL COMMENT '接单科室id',
  `take_order_dept_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '接单科室名称',
  `del_flag` bit(1) DEFAULT b'0' COMMENT '删除标志',
  PRIMARY KEY (`id`),
  KEY `repair_id` (`repair_id`),
  KEY `repair_name` (`repair_name`),
  KEY `mobile` (`mobile`),
  KEY `take_order_dept_id` (`take_order_dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='维修配置表';

ALTER TABLE `rep_repair_apply`
ADD COLUMN `send_person`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送修人' AFTER `turn_num`;
ALTER TABLE `rep_repair_apply`
ADD COLUMN `send_phone`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送修人电话' AFTER `send_person`;
ALTER TABLE `rep_repair_apply`
ADD COLUMN `take_order_id`  bigint(20) NULL DEFAULT NULL COMMENT '接单人ID' AFTER `send_phone`;
ALTER TABLE `rep_repair_apply`
ADD COLUMN `take_order_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接单人姓名' AFTER `take_order_id`;

ALTER TABLE `rep_repair_report`
ADD COLUMN `report_status`  int(1) NULL DEFAULT NULL COMMENT '报修申请状态（1，送修  2，现场维修）' AFTER `del_flag`;
ALTER TABLE `rep_repair_report`
ADD COLUMN  `send_person`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送修人' AFTER `report_status`;
ALTER TABLE `rep_repair_report`
ADD COLUMN `send_phone`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送修人电话' AFTER `send_person`;
ALTER TABLE `rep_repair_report`
ADD COLUMN `report_file`  varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件' AFTER `send_phone`;
ALTER TABLE `rep_repair_report`
ADD COLUMN `trouble_code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障代码' AFTER `send_phone`;


UPDATE rep_repair_apply r,rep_repair_take_orders o set r.take_order_id=o.take_order_id,r.take_order_name=o.take_order_name where r.id=o.apply_id;

ALTER TABLE `rep_repair_report`
MODIFY COLUMN `attachment`  varchar(5000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '附件' AFTER `outside_phone`;








