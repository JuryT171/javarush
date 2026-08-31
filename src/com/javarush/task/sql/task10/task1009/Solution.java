package com.javarush.task.sql.task10.task1009;

import com.javarush.task.sql.task10.task1009.Employee;
import com.javarush.task.sql.task10.task1009.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

/* 
Функции в HQL
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        System.out.println("Salary fund: $" + getSalaryFund());
        System.out.println("Agerage age: " + getAverageAge());
    }

    public static Long getSalaryFund() {
        //напишите тут ваш код
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            String hql = "select sum(salary) from Employee "; // запрос по условию
            Query<Long> query = session.createQuery(hql, Long.class);
            return query.uniqueResult();
        }

    }

    public static Double getAverageAge() {
        //напишите тут ваш код
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            String hql = "select avg(age) from Employee "; // запрос по условию
            Query<Double> query = session.createQuery(hql,Double.class);

            return query.uniqueResult();
        }
    }
}