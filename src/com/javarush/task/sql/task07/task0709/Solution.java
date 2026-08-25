package com.javarush.task.sql.task07.task0709;

import java.sql.*;

/* 
Метод getObject
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
        ResultSet results = statement.executeQuery("SELECT name,weight, birthday, inn FROM employee");


        while (results.next()) { // цикл
           String name = results.getString("name"); // получаем имя
           Float weight = results.getObject("weight", Float.class); // получаем вес, приводя обьект к класс Float
           Date birthday = results.getDate("birthday");// полуаем дату
           Long inn = results.getObject("inn", Long.class); // получаем инн, приводя объект к классу Лонг

            System.out.println(name+" "+weight+" "+birthday+" "+inn); // вывод
        }
        statement.close();
        connection.close();

    }
}
