package com.javarush.task.sql.task08.task0806;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* 
Чтение Java-объектов из БД
*/

public class Solution {

    public static Set<Employee> employees = new HashSet<>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        Statement statement = connection.createStatement();

        ResultSet results = statement.executeQuery("SELECT * FROM employee");

        while (results.next()) {
            // заполняем объект employee данными
            Employee employee = new Employee();
            employee.setId(results.getInt(1));
            employee.setName(results.getString(2));
            employee.setAge(results.getInt(3));
            employee.setSmth(results.getString(4));

            employees.add(employee);
        }
        results.close();
        statement.close();
        connection.close();

        employees.forEach(System.out::println);
    }
}
