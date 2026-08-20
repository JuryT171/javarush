-- Write your code here:
SELECT *
FROM event
WHERE YEAR(date_time) = YEAR(CURDATE())
  AND MONTH(date_time) = MONTH(CURDATE());
