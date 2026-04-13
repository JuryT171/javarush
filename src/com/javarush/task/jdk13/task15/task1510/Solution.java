package com.javarush.task.jdk13.task15.task1510;

/* 
Статики и исключения
*/

public class Solution {
    public static int A = 0;

    static {
        int x = 5 / 0;  // статик выполняется в 1ю очередь, на ноль делить нельзя - выброс исключения

        //throw an exception here - выбросьте эксепшн тут
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
