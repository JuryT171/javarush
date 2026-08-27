package com.javarush.task.sql.task08.task0805;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Set;

/* 
Сохранение Java-объектов
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Set<Employee> employees = Set.of(
                new Employee("Vasya", 33, "lead"),
                new Employee("Pasha", 40, "dev"),
                new Employee("Sasha", 40, "lead"),
                new Employee("Dima", 40, "director"),
                new Employee("Sasha", 40, "dev"));
        String sql = "insert into employee (name, age, smth) values (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            //напишите тут ваш код
            // проходимся по каждому сотруднику в множестве
            for (Employee employee : employees) {
                // берем данные из объекта employee и подставляем
                statement.setString(1, employee.getName());
                statement.setInt(2, employee.getAge());
                statement.setString(3, employee.getSmth());
                // добавляем запрос в батч
                statement.addBatch();
            }
            // выполняем все накопленные запросы разом
            statement.executeBatch();
        }
    }
}

