-- Write your code here:
select g.location, person.name, person.email, person.telephone
from gyms AS g, customers AS person
WHERE person.name = 'Hulk'