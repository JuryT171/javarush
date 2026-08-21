-- Write your code here:
UPDATE employee SET
                    employee.salary = employee.salary + 1000
WHERE employee.id IN (SELECT task.employee_id FROM task WHERE task.exp_date > '2022-10-01');
