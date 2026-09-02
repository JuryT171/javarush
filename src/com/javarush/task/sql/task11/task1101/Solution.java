package com.javarush.task.sql.task11.task1101;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* 
Отсоединяем объект от сессии
*/

public class Solution {
    public static long id1;
    public static long id2;

    public static void main(String[] args) throws Exception {
        Animal animal = new Animal();
        animal.setName("Murka");
        animal.setAge(5);
        animal.setFamily("Cats");
        try {
            SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //напишите тут ваш код
            id1 = (Long) session.save(animal);
            session.evict(animal); 	// отсоединяем объект от сессии

            id2 = (Long) session.save(animal);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(id1 == id2);
    }
}