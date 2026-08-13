-- Write your code here:
select name, SUM(price)
from cars
group by name