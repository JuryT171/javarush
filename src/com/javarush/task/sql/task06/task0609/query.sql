-- Write your code here:
INSERT INTO sale_addresses(street,city,state,zip_code,country)
SELECT street,city, state,zip_code,country from customers
where country != 'Testostan'