package com.javarush.task.jdk13.task13.task1305;

/* 
Наследование интерфейса
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

    }
    public interface CanMove{
        Double speed();
    }
    public interface CanFly extends CanMove{
        Double speed(CanFly canFly);

        }
    }
