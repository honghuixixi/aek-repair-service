
ALTER TABLE `rep_repair_report`

ADD COLUMN `engineer_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '工程师姓名' AFTER `repair_hours`,
ADD COLUMN `engineer_num`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '工程师工号' AFTER `engineer_name`;
ADD COLUMN `call_repair_date`  datetime NULL COMMENT '叫修时间' AFTER `engineer_num`;
ADD COLUMN `arrival_date`  datetime NULL COMMENT '到达时间' AFTER `call_repair_date`;
ADD COLUMN `leave_date`  datetime NULL COMMENT '离开时间' AFTER `arrival_date`;


ALTER TABLE `rep_repair_apply`
MODIFY COLUMN `assets_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称' AFTER `factory_name`;
ALTER TABLE `rep_repair_apply`
MODIFY COLUMN `assets_num`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产编号' AFTER `assets_brand`;

ALTER TABLE `rep_parts_record`
MODIFY COLUMN `part_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '配件名称' AFTER `tenant_id`;
MODIFY COLUMN `status`  int(1) NULL DEFAULT NULL COMMENT '操作类型（1领用 2 购买）' AFTER `num`;


