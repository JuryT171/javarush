package com.javarush.task.jdk13.task12.task1218;

/* 
Суперспособности
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanMove {
        public void move();
    }

    public interface CanEat {
        public void eat();
    }

    public abstract class Dog implements CanMove, CanEat {
    }

    public abstract class Duck implements CanMove,CanFly,CanEat{
    }

    public abstract class Car implements CanMove {
    }

    public abstract class Airplane implements CanMove,CanFly {
    }
}
