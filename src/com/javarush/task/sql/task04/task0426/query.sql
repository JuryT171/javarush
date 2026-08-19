-- Write your code here:
SELECT YEAR(date), MONTH(date), DAY(date), sum(total)
FROM data
GROUP BY YEAR(date), MONTH(date), DAY(date)