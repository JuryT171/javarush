package com.javarush.task.jdk13.task12.task1220;

/* 
Почти что Iron Man
*/

public class Solution {
    public static void main(String[] args) {

    }

    //add public interfaces and a public class here - добавь public интерфейсы и public класс тут
    public abstract class Human implements CanRun,CanSwim{

    }
    public interface CanRun{
        void run();
    }
    public interface CanSwim{
        void swim();
    }
}
