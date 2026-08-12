-- Write your code here:
select if(age<=12,'child',
if(age>=20,'adult','teenager'))
from customers
LIMIT 5