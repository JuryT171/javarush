package com.javarush.task.sql.task10.task1005;

import com.javarush.task.sql.task10.task1001.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.javarush.task.sql.task10.task1005.entities.Book;

import java.util.List;

/*
join в HQL
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        List<Book> books;
        //напишите тут ваш код
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            // запрос по условию
            String hql = "from Book where author.full_name = 'Mark Twain' and publisher.name = 'Chatto & Windus'";
            // создаем запрос, указывая что результат Book
            Query<Book> query = session.createQuery(hql , Book.class);

            books = query.list(); // получаем список результатов
        }
        books.forEach(System.out::println);
    }
}