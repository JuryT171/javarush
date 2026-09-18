package com.javarush.task.sql.task14.task1404;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/* 
JOIN FETCH
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        List<Task> tasks = getTasks();
        tasks.forEach(System.out::println);
    }

    public static List<Task> getTasks() {
        //напишите тут ваш код
        try (Session session = MySessionFactory.getSessionFactory().openSession()) { // открываем сессию
            // выбираем оригинальные t
            // left join fetch - все задачи+загрузить их
            // t.deadline — поле deadline сущности Task
            String hql = " select distinct t from Task t left join fetch t.employees order by t.deadline";
            Query<Task> query = session.createQuery(hql, Task.class); // типизированный запрос
            return query.list();
        }
    }
}
