-- Write your code here:
select c.customer_id, c.email,
       o.order_id, o.order_status
from customers as c join orders as o
    ON c.customer_id = o.customer_id
WHERE o.order_status = 'PAID' OR o.order_status = 'PROCESSING'