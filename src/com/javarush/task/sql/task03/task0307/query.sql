-- Write your code here:
select gym.id, gym.name, cust.id
from gyms AS gym, customers AS cust
where cust.id<50