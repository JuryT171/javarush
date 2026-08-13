-- Write your code here:
select position, GROUP_CONCAT(name)
from employee
group by position
having position LIKE '%developer%'