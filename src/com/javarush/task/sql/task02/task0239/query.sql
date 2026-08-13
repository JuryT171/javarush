-- Write your code here:
select
    YEAR(date_of_birth),
    MONTH(date_of_birth)
from employee
where MONTH(date_of_birth) = 12 OR  MONTH(date_of_birth) = 1 OR MONTH(date_of_birth) = 2
