-- Write your code here:
select name, AVG(price),SUM(price)
from cars
group by name
having AVG(price)>100000