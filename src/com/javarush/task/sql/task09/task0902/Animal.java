package com.javarush.task.sql.task09.task0902;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
Entity
*/
//напишите тут ваш код
@Entity // аннотация указывающая что класс будет храниться в БД
@Table(name = "animal_table", schema = "test") // имя таблицы, имя схемы
public class Animal {
    //напишите тут ваш код
        @Id
        private Long id;
        @Column(name = "name")
        private String name;
        @Column(name = "age")
        private Integer age;
        @Column(name = "family")
        private String family;

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

        public String getFamily() {
        return family;
    }

        public void setFamily(String family) {
        this.family = family;
    }

}