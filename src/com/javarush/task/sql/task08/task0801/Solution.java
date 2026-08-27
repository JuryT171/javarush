package com.javarush.task.sql.task08.task0801;

import java.sql.*;

/* 
Работа с транзакциями
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        // создаем подключение
        Connection connection  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root", "root");

        connection.setAutoCommit(false); // отключаем автокоммит

        // создаем стейтмент
        Statement statement = connection.createStatement();
        // увеличиваем з\п диего
        int salary =
                statement.executeUpdate("UPDATE  employee SET salary = salary+2000 WHERE name = 'Diego'");
        // увеличиваем з\п амиго
        int salary1 =
                statement.executeUpdate("UPDATE  employee SET salary = salary+500 WHERE name = 'Amigo'");
        connection.commit();
        statement.close();
        connection.close();
    }
}
