-- Write your code here:
select city
from cities
ORDER BY CHAR_LENGTH(city) DESC
                           LIMIT 3