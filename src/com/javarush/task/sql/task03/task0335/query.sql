-- Write your code here:
select author.country as author_country, COUNT(book.book_id) as book_count
from authors as author join books as book
ON author.id = book.author_id
where book.genre = 'novel'
group by author.country
HAVING COUNT(book.book_id) > 2