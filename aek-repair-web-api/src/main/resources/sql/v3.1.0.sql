ALTER TABLE rep_repair_report  MODIFY COLUMN repair_start_date datetime DEFAULT NULL COMMENT '维修开始日期(申请时间)';
ALTER TABLE rep_repair_report  MODIFY COLUMN repair_end_date datetime DEFAULT NULL COMMENT '维修结束日期(完修时间-提交维修报告时间)';
ALTER TABLE rep_repair_report  MODIFY COLUMN actual_start_date datetime DEFAULT NULL COMMENT '实际开始时间(接单时间)';
ALTER TABLE rep_repair_report  MODIFY COLUMN actual_end_date datetime DEFAULT NULL COMMENT '实际结束时间(维修时间-实际维修开始时间)';
commit;
