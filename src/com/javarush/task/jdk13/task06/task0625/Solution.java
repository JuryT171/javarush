package com.javarush.task.jdk13.task06.task0625;

import java.util.Scanner;

/* 
Минимальная сумма
*/

public class Solution {
    public static int[][] array = new int[3][3];

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int[] row_sum = new int[array.length];
        int[] col_sum = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();  //  заполняем массив числами
                row_sum[i] = row_sum[i] + array[i][j];   //  row_sum[i] += array[i][j];
            }
            if (row_sum[i] < min)
                min = row_sum[i];
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                col_sum[j] = col_sum[j] + array[i][j];
            if (col_sum[j] < min){
                min = col_sum[j];}
            }
        }
        System.out.println(min);
    }
}