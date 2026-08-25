package com.javarush.task.sql.task07.task0706;

import java.sql.*;

/* 
Имя и тип колонки
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
        ResultSet results = statement.executeQuery("SELECT * FROM employee LIMIT 1"); // в запросе указыва мин эйдж

        ResultSetMetaData metaData = results.getMetaData(); //интерфейс ResultSetMetaData
        for (int i = 1; i <= metaData.getColumnCount(); i++) { // проходимся циклом
            // получаем имя колонки, тип колонки
            System.out.println(metaData.getColumnName(i) + "(" + metaData.getColumnTypeName(i) + ")");
        }

        statement.close();
        connection.close();
    }
}
