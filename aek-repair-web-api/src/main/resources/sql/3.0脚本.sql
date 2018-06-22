ALTER TABLE `rep_repair_message`
CHANGE COLUMN `apply_id` `module_id`  bigint(20) NULL DEFAULT NULL COMMENT '模块id（维修申请id）' AFTER `id`;
ALTER TABLE `rep_repair_message`
CHANGE COLUMN `check_dept_name` `remarks`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '消息备注' AFTER `message_time`;
ALTER TABLE `rep_repair_message`
ADD COLUMN `status`  int(1) NULL COMMENT '消息所属类型' AFTER `del_flag`;


UPDATE  rep_repair_message  set `status`=1;

