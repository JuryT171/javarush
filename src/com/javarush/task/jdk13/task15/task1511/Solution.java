package com.javarush.task.jdk13.task15.task1511;

/* 
Статики-3
*/

public class Solution {
    public static Cat cat;
    public static class Cat{
        public String name;
    }
    static {  //  статический блок
       cat = new Cat();  // инициализируем поле
       cat.name = "Tom";  //  присваиваем имя
        System.out.println(cat.name);  //  выводим на экран
    }

    public static void main(String[] args) {

    }
}
