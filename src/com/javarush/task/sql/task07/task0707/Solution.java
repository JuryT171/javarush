package com.javarush.task.sql.task07.task0707;

import java.sql.*;

/* 
Метод wasNull
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
        ResultSet results = statement.executeQuery("SELECT name,weight FROM employee");
        while (results.next()) { // цикл
            Double weight = results.getDouble("weight"); // получаем вес с плавющей точкой
            if (results.wasNull()) {
                weight = null; // если был 0 то null
            }
            System.out.println(results.getObject("name") + " " + weight);
        }
        statement.close();
        connection.close();
    }
}
