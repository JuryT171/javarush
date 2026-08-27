package com.javarush.task.sql.task08.task0804;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/* 
Batching запросов
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        String sql = "insert into employee (name, age, smth) values (?, ?, ?)";
        //напишите тут ваш код
        // создаем подключение
        Connection connection  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root", "root");
        // создаем prepareStatement
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i <=4; i++) {
            // Заполняем параметры запроса
            statement.setString(1, "employee_" + i);
            statement.setInt(2, 30 + i);
            statement.setString(3, "i = " + i);

            // Запрос не выполняется, а укладывается в буфер,
            //  который потом выполняется сразу для всех команд
            statement.addBatch();
        }
        // Выполняем все накопленные запросы разом
        statement.executeBatch();

        // Закрываем ресурсы
        statement.close();
        connection.close();
    }
}
