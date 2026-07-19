package com.javarush.task.jdk13.task41.task4109;

import java.util.Date;

public abstract class AbstractEntity {
    public int id;
    public Date createdTime;
    public Date updatedTime;

    // пустой конструктор
    public AbstractEntity() {
    }

    // Копирующий конструктор
    public AbstractEntity(AbstractEntity other) {
        this.id = other.id;
        this.createdTime = other.createdTime;
        this.updatedTime = other.updatedTime;
    }

    // Абстрактный метод клонирования
    public abstract AbstractEntity clone();
}
