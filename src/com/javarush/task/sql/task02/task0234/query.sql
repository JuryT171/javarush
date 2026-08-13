-- Write your code here:
select year(date_of_birth), count(*) as year_of_birth
from employee
group by year(date_of_birth)