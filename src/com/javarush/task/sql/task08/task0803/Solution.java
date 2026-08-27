package com.javarush.task.sql.task08.task0803;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/* 
Использование PreparedStatement
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        String name = "Harry";
        int age = 18;
        String smth = "Senior pomidor";
        String sql = "insert into employee (name, age, smth) values (?, ?, ?)";
        //напишите тут ваш код
        // создаем подключение
        Connection connection  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root", "root");
        // создаем prepareStatement
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name); // устанавливаем новые значения
        statement.setInt(2,age);
        statement.setString(3, smth);
        statement.executeUpdate(); // обновляем

        statement.close();
        connection.close();
    }
}
