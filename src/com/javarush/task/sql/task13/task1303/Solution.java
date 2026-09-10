package com.javarush.task.sql.task13.task1303;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.javarush.task.sql.task13.task1303.entities.Publisher;

import java.util.List;
import java.util.Map;

import static com.javarush.task.sql.task13.task1303.MySessionFactory.getSessionFactory;

/* 
Опять книги
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        List<Publisher> publishers;

        //напишите тут ваш код
        try (SessionFactory sessionFactory =MySessionFactory.getSessionFactory();
            Session session = sessionFactory.openSession()){ // открываем сессию
            String hql = "select distinct b.publisher " + // уникальные издатели таблицы book
                    "from Book b where b.author.fullName = 'Mark Twain'"; // автор книги марк твэн
            // создаем запрос,который вернет обьект класса publisher
            Query<Publisher> query = session.createQuery(hql, Publisher.class);
            publishers = query.list();// hql преобразуется в sql, преобразует результат
            // в обьект publisher и возвращает список
        }
            publishers.stream().map(Publisher::getName).forEach(System.out::println);
    }
}
