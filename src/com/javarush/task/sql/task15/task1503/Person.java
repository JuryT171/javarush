package com.javarush.task.sql.task15.task1503;

import jakarta.persistence.*;
@Entity
@Table(name = "person", schema = "test")
// Каждый класс дерева наследования - отдельная таблица
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id // PK id с AUTO_INCREMENT
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
