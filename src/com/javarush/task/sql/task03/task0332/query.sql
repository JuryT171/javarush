-- Write your code here:
select auth.last_name as author, book.genre as book_genre,
       book.date_released
from authors as auth right join books as book
ON auth.author_id = book.author_id
where book.date_released < 1900
group by book.genre,book.date_released