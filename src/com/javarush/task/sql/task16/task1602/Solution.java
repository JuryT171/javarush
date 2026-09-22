package com.javarush.task.sql.task16.task1602;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/* 
Фильтр результата в Criteria API
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Animal> results = new ArrayList<>();
        try {
            SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(new Animal("Tom", 5, "Cat"));
            session.saveOrUpdate(new Animal("Jerry", 3, "Mouse"));
            session.saveOrUpdate(new Animal("Spike", 7, null));
            transaction.commit();
            //напишите тут ваш код
            CriteriaBuilder builder = session.getCriteriaBuilder(); // 1
            CriteriaQuery<Animal> critQuery = builder.createQuery(Animal.class); //2

            Root<Animal> root = critQuery.from(Animal.class); // 3
            //4,5
            critQuery.select(root).where(builder.isNotNull(root.get("family")));

            Query<Animal> query = session.createQuery(critQuery); // 6
            results = query.getResultList(); // 7

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        results.forEach(System.out::println);
    }
}