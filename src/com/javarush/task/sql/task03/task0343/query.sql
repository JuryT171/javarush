-- Write your code here:
select full_name from film_directors
left join (select title, director_id from films
                        where films.genre = 'comedy') as f
            ON film_directors.id = f.director_id
