package com.javarush.task.jdk13.task12.task1209;

/* 
Определимся с животным
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        if(o.getClass()== Cow.class){
            return "Корова";
        }else if (o.getClass()==Dog.class){
            return "Собака";
        } else if (o.getClass() == Whale.class) {
            return "Кит";
        }else
        return "Неизвестное животное";
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
