package com.javarush.task.sql.task08.task0807;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPDataSource {
    private static HikariCPDataSource instance;
    private HikariConfig config;
    private HikariDataSource ds;

    private HikariCPDataSource() {
        //напишите тут ваш код
        config = new HikariConfig(); // инициализируем конфиг
        //устанавливаем параметры подключения
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        config.setUsername("root");
        config.setPassword("root");
        //инициализируем ds,передав в конструктор  config
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new HikariCPDataSource();
        }
        return instance.ds.getConnection();
    }
}
