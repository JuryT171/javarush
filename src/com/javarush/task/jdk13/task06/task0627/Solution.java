package com.javarush.task.jdk13.task06.task0627;

import java.util.Scanner;

/* 
Вот это переворот!
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
        for (int i = 0; i < array.length; i++) {
            for (int j = i +1; j < array[i].length; j++) {
                // считываем числа массива
                int rev_massiv = array[i][j];  //  ввели временную переменную, присвоили значение
                array [i][j] = array [j][i]; //  поменяли местами значения
                array[j][i] = rev_massiv;  // присваем значение из врем переменной
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array [i][j]+" ");
            }
            System.out.println();
        }
    }
}
