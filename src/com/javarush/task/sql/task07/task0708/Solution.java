package com.javarush.task.sql.task07.task0708;

import java.sql.*;
import java.time.LocalDateTime;

/* 
Получение даты
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        // создаем подключение
        Connection connection  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root", "root");
        // создаем стейтмент
        Statement statement = connection.createStatement();
        // делаем запрос к БД
        ResultSet results = statement.executeQuery("SELECT name,created FROM employee");

        while (results.next()) { // цикл
            // имя класса, получаем обьект преобразовывая его к localDateTime
            java.time.LocalDateTime local = results.getObject("created", java.time. LocalDateTime.class);
            System.out.println(results.getString("name") + " " + local); // вывод согласно задания
        }
        statement.close();
        connection.close();

    }
}
