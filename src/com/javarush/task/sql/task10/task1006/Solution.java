package com.javarush.task.sql.task10.task1006;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/* 
Параметры к запросам
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        getBetween(25, 32).forEach(System.out::println);
    }

    public static List<Employee> getBetween(int from, int to) {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            String hql = "from Employee where age > :FROM and age < :TO order by age";
            Query<Employee> query = session.createQuery(hql, Employee.class);
            query.setParameter("FROM", from); // устанавливаем значение для параметра from
            query.setParameter("TO", to); // устанавливаем значение для параметра to
            return query.list();
        }
    }
}