
ALTER TABLE `rep_repair_apply` ADD COLUMN `report_status`  int(1) NULL COMMENT '报修申请状态（1，送修  2，现场维修）' AFTER `del_flag`;
ALTER TABLE `rep_repair_apply` ADD COLUMN `assets_desc`  int(1) NULL COMMENT '资产描述（1，固定资产 2，非固定资产）' AFTER `report_status`;
ALTER TABLE `rep_repair_apply` ADD COLUMN `assets_local`  varchar(40) NULL COMMENT '设备所在位置' AFTER `assets_desc`;
ALTER TABLE `rep_repair_apply` ADD COLUMN `serial_num`  varchar(50) NULL COMMENT '院内编码' AFTER `assets_local`;
ALTER TABLE `rep_repair_apply` ADD COLUMN `assets_file`  varchar(1000) NULL COMMENT '附件' AFTER `serial_num`;
ALTER TABLE `rep_repair_apply` ADD COLUMN `turn_num`  int(1) NULL DEFAULT 0 COMMENT '转单次数' AFTER `assets_file`;
ALTER TABLE `rep_repair_apply` MODIFY COLUMN `assets_id`  bigint(20) NULL COMMENT '关联设备ID' AFTER `apply_no`;
ALTER TABLE `rep_repair_apply` MODIFY COLUMN `assets_num`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产编号' AFTER `assets_brand`;
UPDATE rep_repair_apply set turn_num=0 where turn_num is NULL;
UPDATE rep_repair_apply set assets_desc=1 where assets_desc is NULL

ALTER TABLE `rep_repair_take_orders` ADD COLUMN `repair_id`  bigint(20) NULL COMMENT '维修人ID' AFTER `del_flag`;
ALTER TABLE `rep_repair_take_orders` MODIFY COLUMN `repair_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '维修人名称' AFTER `repair_id`;
UPDATE rep_repair_take_orders set repair_id=take_order_id,repair_name=take_order_name;
