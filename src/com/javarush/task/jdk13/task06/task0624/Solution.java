package com.javarush.task.jdk13.task06.task0624;

import java.util.Scanner;

/* 
Максимальный элемент
*/

public class Solution {
    public static int[][] array = new int[3][3];

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();   //  заполняем массив числами
            }
        }
        int max = array[0][0];  //  вводим переменную для поиска максимума
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {  // считываем числа массива
                if (array[i][j] > max)  // если какое либо число из массива больше чем в 1й ячейке
                    max = array[i][j];  //  оно становится максимальныс
            }
        }
        System.out.println(max);
    }
}


