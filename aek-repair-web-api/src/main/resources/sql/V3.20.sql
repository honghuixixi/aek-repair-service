ALTER TABLE `rep_repair_apply`
ADD COLUMN `report_date`  datetime NULL COMMENT '提交报告单时间' AFTER `report_repair_date`;

ALTER TABLE `rep_repair_apply`
ADD COLUMN `seven_status`  int(1) NULL DEFAULT NULL COMMENT '七天完修（1，是 2，否）' AFTER `report_date`;


ALTER TABLE `rep_repair_apply`
ADD COLUMN `days`  int(6) NULL AFTER `take_order_id`;



UPDATE rep_repair_apply r,rep_repair_report p  set r.report_date=p.repair_date where r.id=p.apply_id;

UPDATE rep_repair_apply r  set r.days=(TIMESTAMPDIFF(DAY,r.report_repair_date,r.report_date));


UPDATE  rep_repair_apply r  set r.seven_status=2 where r.days>7;


UPDATE  rep_repair_apply r  set r.seven_status=1 where r.days<=7;

ALTER TABLE `rep_repair_apply`
DROP COLUMN `report_date`;

ALTER TABLE `rep_repair_apply`
DROP COLUMN `days`;
