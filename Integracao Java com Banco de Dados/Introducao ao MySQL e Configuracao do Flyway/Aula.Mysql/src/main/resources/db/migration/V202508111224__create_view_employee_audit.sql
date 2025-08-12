CREATE VIEW view_employee_audit AS
    SELECT id,
           name,
           old_name,
           salary,
           old_salary,
           birthday,
           old_birthday,
           operation
        FROM employee_audit
        ORDER BY created_at;