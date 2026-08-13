-- Write your code here:
select
    case
        when euro is not null then 'bad'
        else 'good'
    end
from cars