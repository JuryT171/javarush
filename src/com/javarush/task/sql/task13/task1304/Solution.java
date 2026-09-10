package com.javarush.task.sql.task13.task1304;

import com.javarush.task.sql.task13.task1304.entities.Author;
import org.hibernate.Session;
import org.hibernate.query.Query;

/*
Автор книги или книга автора?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) { // создаем сессию

            Query<Author> query = // HQL запрос
                    session.createQuery("from Author where fullName = :AUTHOR_FULLNAME", Author.class);
            query.setParameter("AUTHOR_FULLNAME", "Mark Twain"); // подставляем значение в параметр
            Author author = query.getSingleResult(); //выполняем запрос,ожидаем один результат

            author.getBooks().forEach(System.out::println); // вывод
        }
    }
}