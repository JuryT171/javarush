-- Write your code here:
SELECT YEAR(date_of_birth), MONTH(date_of_birth), count(*)
FROM employee
GROUP BY YEAR(date_of_birth), MONTH(date_of_birth);