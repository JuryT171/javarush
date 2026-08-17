-- Write your code here:
select * from film_directors
where full_name LIKE (select CONCAT(first_name, ' ',last_name) from film_directors
                                                               limit 1)