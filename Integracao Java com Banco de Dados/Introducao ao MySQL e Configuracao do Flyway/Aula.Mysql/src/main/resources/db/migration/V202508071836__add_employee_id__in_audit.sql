ALTER TABLE employee_audit ADD COLUMN employee_id BIGINT NOT NULL AFTER ID;

--ALTER TABLE jdbc_sample.employee_audit ADD employee_id BIGINT NOT NULL;
--ALTER TABLE jdbc_sample.employee_audit CHANGE employee_id employee_id BIGINT NOT NULL AFTER id;
