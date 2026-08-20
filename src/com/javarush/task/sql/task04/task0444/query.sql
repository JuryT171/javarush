-- Write your code here:
select CONCAT(city, '-', CHAR_LENGTH(city))
from cities
ORDER BY CHAR_LENGTH(city) ASC
    LIMIT 3