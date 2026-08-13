-- Write your code here:
select department,
       position,
       count(*) as total
from employee
group by department, position
having total > 1 AND position = 'frontend developer'
limit 1