-- Write your code here:
select a.sex as aothor_sex, a.country as author_country,
       b.copies_sold_millions as books_sold
from authors as a join books as b
ON a.author_id = b.author_id
where b.copies_sold_millions > 10
group by a.sex, a.country, b.copies_sold_millions
order by b.copies_sold_millions desc