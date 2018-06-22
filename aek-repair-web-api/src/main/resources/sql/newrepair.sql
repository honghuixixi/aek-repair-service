
ALTER TABLE `rep_repair_report`

ADD COLUMN `engineer_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '����ʦ����' AFTER `repair_hours`,
ADD COLUMN `engineer_num`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '����ʦ����' AFTER `engineer_name`;
ADD COLUMN `call_repair_date`  datetime NULL COMMENT '����ʱ��' AFTER `engineer_num`;
ADD COLUMN `arrival_date`  datetime NULL COMMENT '����ʱ��' AFTER `call_repair_date`;
ADD COLUMN `leave_date`  datetime NULL COMMENT '�뿪ʱ��' AFTER `arrival_date`;


ALTER TABLE `rep_repair_apply`
MODIFY COLUMN `assets_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�豸����' AFTER `factory_name`;
ALTER TABLE `rep_repair_apply`
MODIFY COLUMN `assets_num`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ʲ����' AFTER `assets_brand`;

ALTER TABLE `rep_parts_record`
MODIFY COLUMN `part_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '�������' AFTER `tenant_id`;
MODIFY COLUMN `status`  int(1) NULL DEFAULT NULL COMMENT '�������ͣ�1���� 2 ����' AFTER `num`;


