-- Write your code here:
select * from authors
where full_name NOT LIKE (select CONCAT(first_name, ' ', last_name)
                          from authors
                          where last_name = 'Shakespeare')