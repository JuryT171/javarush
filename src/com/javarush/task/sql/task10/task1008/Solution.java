package com.javarush.task.sql.task10.task1008;

import com.javarush.task.sql.task10.task1008.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/* 
setFirstResult и setMaxResults
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        getSorted(3, 5).forEach(System.out::println);
    }

    public static List<Employee> getSorted(int offset, int limit) {
        //напишите тут ваш код
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            String hql = "from Employee order by age"; // запрос по условию
            Query<Employee> query = session.createQuery(hql,Employee.class);
            query.setFirstResult(offset); // эквивалентно OFFSET
            query.setMaxResults(limit);   // эквивалентно LIMIT
            return query.list();
        }
    }
}