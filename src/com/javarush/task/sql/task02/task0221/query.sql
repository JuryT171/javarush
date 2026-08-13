-- Write your code here:
select prod_year, count(*)
from cars
group by prod_year