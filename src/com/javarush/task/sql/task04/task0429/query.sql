-- Write your code here:
select * from event
WHERE event.date_time  BETWEEN DATE_SUB( CURDATE() , INTERVAL 14 DAY) AND CURDATE()