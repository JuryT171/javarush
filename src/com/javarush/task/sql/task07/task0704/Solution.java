package com.javarush.task.sql.task07.task0704;

import java.sql.*;

/* 
Использование результата запроса 1
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
        ResultSet results = statement.executeQuery("SELECT * FROM employee");

        while (results.next()) {
            System.out.println(results.getString("name"));
        }
        statement.close();
        connection.close();
    }
}
