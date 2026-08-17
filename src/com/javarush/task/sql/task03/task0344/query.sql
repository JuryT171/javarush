-- Write your code here:
select title from films
left join (select last_name, id from film_directors
                            where film_directors.last_name = 'Spielberg') as director
            ON films.director_id = director.id