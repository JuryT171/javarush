package com.javarush.task.sql.task10.task1002;

import org.hibernate.Session;
import org.hibernate.query.Query;

/*
Метод uniqueResult
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        System.out.println(getDirector());
    }

    public static Employee getDirector() {
        // получаем сессию
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            // запрос по условию
            Query<Employee> query =
                    session.createQuery("from Employee where smth = 'director'", Employee.class);
            return query.uniqueResult(); // возвращаем результат
        }
    }
}