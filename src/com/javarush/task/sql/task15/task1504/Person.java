package com.javarush.task.sql.task15.task1504;

import jakarta.persistence.*;

@Entity
@Table(name = "person", schema = "test")
// каждый класс дерева — своя таблица, со всеми унаследованными колонками
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
