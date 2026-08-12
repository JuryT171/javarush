-- Write your code here:
select if(position = 'manager',if(salary>10000,'good','bad'),
       if(salary>5000,'good','bad'))
From employee
where city = 'London'
