package com.javarush.task.sql.task10.task1010;

import com.javarush.task.sql.task10.task1010.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

/* 
NativeQuery
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        getAll().forEach(System.out::println);
    }

    public static List<Employee> getAll() {
        //напишите тут ваш код
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            String hql = "select * from Employee order by id"; // запрос по условию
            // createNativeQuery преобразует sql в hql
            NativeQuery<Employee> query = session.createNativeQuery(hql, Employee.class);
            return query.list();
        }
    }
}