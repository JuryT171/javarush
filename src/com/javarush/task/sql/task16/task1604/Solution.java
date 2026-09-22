package com.javarush.task.sql.task16.task1604;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;


/* 
Метод list
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            //напишите тут ваш код
            List<Object[]> list = session.createNativeQuery("select id, title, created_time from project").list();
            list.forEach(a -> System.out.printf("%s, %s, %s\n", a[0], a[1], a[2]));
        }
    }
}