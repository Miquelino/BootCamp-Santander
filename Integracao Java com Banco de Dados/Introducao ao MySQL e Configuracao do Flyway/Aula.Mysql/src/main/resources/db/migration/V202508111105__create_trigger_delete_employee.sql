DELIMITER $
-- Trigger para DELETE
CREATE TRIGGER tgr_employee_audit_delete
AFTER DELETE ON employees
FOR EACH ROW
BEGIN
    INSERT INTO employee_audit (
        id,
        name,
        salary,
        birthday,
        operation
    ) VALUES (
        OLD.id,
        OLD.name,
        OLD.salary,
        OLD.birthday,
        'D'
    );
END$