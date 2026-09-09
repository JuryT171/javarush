package com.javarush.task.sql.task12.task1203;

/* 
Сохраняем объект в БД
*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Properties;

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        // создаем обьект и заполняем его
        TimeClass timeClass = new TimeClass();
        timeClass.setId(1000L);
        timeClass.setInstant(Instant.ofEpochSecond(10000));
        timeClass.setZonedDateTime(ZonedDateTime.now(ZoneId.systemDefault()));

        // получаем фабрику
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();

        // начинаем транзакцию, сохраняем объект и коммитим
        session.beginTransaction();
        session.save(timeClass);
        session.getTransaction().commit();

        // закрываем сессию
        session.close();

        /* try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(timeClass);
            session.getTransaction().commit();
        }  */

    }

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");

        SessionFactory sessionFactory = new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(TimeClass.class)
                .buildSessionFactory();

        return sessionFactory;
    }
}
