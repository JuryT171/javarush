package com.javarush.task.jdk13.task06.task0623;

/* 
Знакомство с двумерным массивом
*/

public class Solution {
    public static int[][] array;//напишите тут ваш код

    public static void main(String[] args) {
        //напишите тут ваш код
        array = new int[2][3];  //  cоздаем границы массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (i + 1) + (j + 1);   //  заполняем массив числами
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j] + " ");   // цикл для вывода на экран всех чисел
            }
        }
    }
}