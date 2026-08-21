-- Write your code here:
UPDATE employee SET
                    salary = 5000,
                    position = 'fullstack developer'
where position LIKE '%developer%'