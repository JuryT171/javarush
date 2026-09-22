package com.javarush.task.sql.task16.task1603;

/* 
Удаление через Criteria API
*/

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static com.javarush.task.sql.task16.task1603.MySessionFactory.getSessionFactory;

public class Solution {

    public static void main(String[] args) {
        EmployeeFactory.initEmployees();
        deleteEmployeeById(2L);
    }

    public static void deleteEmployeeById(long id) {
        //напишите тут ваш код
        try (Session session = getSessionFactory().openSession()) { // 1
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); // 2
            // 3
            CriteriaDelete<Employee> criteriaDelete = criteriaBuilder.createCriteriaDelete(Employee.class);
            //4
            Root<Employee> root = criteriaDelete.from(Employee.class);
            //5,6
            criteriaDelete.where(criteriaBuilder.equal(root.get("id"), id));
            // 7
            session.beginTransaction();
            session.createQuery(criteriaDelete).executeUpdate(); //8
            session.getTransaction().commit(); // 9
        }
    }
}
