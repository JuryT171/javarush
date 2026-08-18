-- Write your code here:
WITH grossed_total AS(select SUM(grossed) as total from films)
select AVG(total) as average_grossed from grossed_total