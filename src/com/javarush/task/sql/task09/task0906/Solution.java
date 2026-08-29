package com.javarush.task.sql.task09.task0906;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

/* 
Настройки SessionFactory
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");

        //напишите тут ваш код
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

        SessionFactory sessionFactory = new Configuration()
                .setProperties(properties)
                .buildSessionFactory();
    }
}
