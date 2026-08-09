-- Write your code here:
select description
from parts
order by required desc, identifier desc, description desc
offset 23