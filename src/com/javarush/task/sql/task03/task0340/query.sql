-- Write your code here:
select * from authors
where id not in(select author_id from books
                                 where author_id IS NOT NULL
                                 AND genre = 'novel')