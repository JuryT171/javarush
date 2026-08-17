-- Write your code here:
select * from films
where title LIKE( select title from films
                               where title LIKE 'The%r'
                               limit 1)