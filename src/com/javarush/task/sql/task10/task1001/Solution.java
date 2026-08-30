package com.javarush.task.sql.task10.task1001;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/* 
Метод list
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            String hql = "select distinct e.smth from Employee as e " +
                    "where e.age > 18 order by e.smth";
            // создаем запрос, указывая что результат string
            Query<String> query = session.createQuery(hql , String.class);
            // получаем список результатов
            List<String> results = query.list();

            // выводим в консоль, каждое значение с новой строки
            results.forEach(System.out::println);
        }
    }
}
