DELIMITER $
-- Trigger para UPDATE
CREATE TRIGGER tgr_employee_audit_update
AFTER UPDATE ON employees
FOR EACH ROW
BEGIN
    INSERT INTO employee_audit (
        id,
        name,
        old_name,
        salary,
        old_salary,
        birthday,
        old_birthday,
        operation
    ) VALUES (
        NEW.id,
        NEW.name,
        OLD.name,
        NEW.salary,
        OLD.salary,
        NEW.birthday,
        OLD.birthday,
        'U'
    );
END$