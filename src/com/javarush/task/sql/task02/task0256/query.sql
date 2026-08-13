-- Write your code here:
select name, SUM(price), AVG(price)
from cars
group by name