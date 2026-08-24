package com.javarush.task.sql.task07.task0702;

import java.sql.*;

/* 
Выполнение простого запроса
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        // создаем подключение к БД
        Connection connection  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root", "root");

        // получаем стейтмент
        Statement statement = connection.createStatement();
        // выполняем запрос
        ResultSet results = statement.executeQuery("select 7 * 8");
        statement.close();
        connection.close();
    }
}
