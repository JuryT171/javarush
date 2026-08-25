package com.javarush.task.sql.task07.task0705;

import java.sql.*;

/* 
Использование результата запроса 2
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
        ResultSet results = statement.executeQuery("SELECT MIN(age) FROM employee"); // в запросе указыва мин эйдж

        results.next();
        System.out.println(results.getInt(1)); // выводим на экран первое значение(согласно запроса оно минимальное)
        statement.close();
        connection.close();
    }
}
