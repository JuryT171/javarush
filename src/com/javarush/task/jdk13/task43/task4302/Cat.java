package com.javarush.task.jdk13.task43.task4302;


import java.util.Objects;
/* 
Сравниваем котов
*/

public class Cat {

    private String name;
    private int age;
    private transient int weight;
    private transient String breed;

    public Cat(String name, int age, int weight, String breed) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Cat cat = (Cat) obj;
        return age == cat.age && Objects.equals(breed, cat.breed);
    }

    @Override

    public int hashCode() {
        int result = age;
        result = 31 * result + (breed != null ? breed.hashCode() : 0);
        return result;
    }
}
