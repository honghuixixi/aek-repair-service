ALTER TABLE rep_repair_report  MODIFY COLUMN repair_start_date datetime DEFAULT NULL COMMENT 'ά�޿�ʼ����(����ʱ��)';
ALTER TABLE rep_repair_report  MODIFY COLUMN repair_end_date datetime DEFAULT NULL COMMENT 'ά�޽�������(����ʱ��-�ύά�ޱ���ʱ��)';
ALTER TABLE rep_repair_report  MODIFY COLUMN actual_start_date datetime DEFAULT NULL COMMENT 'ʵ�ʿ�ʼʱ��(�ӵ�ʱ��)';
ALTER TABLE rep_repair_report  MODIFY COLUMN actual_end_date datetime DEFAULT NULL COMMENT 'ʵ�ʽ���ʱ��(ά��ʱ��-ʵ��ά�޿�ʼʱ��)';
commit;
