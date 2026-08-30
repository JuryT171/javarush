package com.javarush.task.sql.task10.task1003;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/*
Метод executeUpdate
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        promoteAll();
    }

    public static void promoteAll() {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction(); // транзакция т.к мы обновляем update
            Query query // запрос по условию
                    = session.createQuery("update Employee set smth = concat('senior ', smth)");
            query.executeUpdate(); // отпралвчем запрос к БД
            transaction.commit(); // коммитим
        }
    }
}