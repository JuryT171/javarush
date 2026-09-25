package com.javarush.task.sql.task16.task1605;

import org.hibernate.Session;
import org.hibernate.Transaction;

/* 
Транзакции
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        switchToRemote();
    }

    public static void switchToRemote() {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            //напишите тут ваш код
            Transaction transaction = session.getTransaction();
            transaction.begin(); // начинаем транзакцию
            // создаем запрос согласно условию
            session.createQuery("update Employee e set e.smth" +
                    " = concat('virtual ', e.smth) where e.smth like 'office%'").executeUpdate();
            session.createQuery("delete from Task t where t.title" +
                    " = 'Buy coffee' or t.title = 'Clean up the office'").executeUpdate();

            transaction.commit(); // фиксируем изменения
        }
    }
}