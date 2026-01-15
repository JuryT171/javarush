package com.javarush.task.jdk13.task06.task0632;

import java.util.Scanner;

/*
Пирамида
*/

public class Solution {
    public static char[][] array;

    public static void main(String[] args) {
        System.out.println("Введите высоту пирамиды:");
        Scanner s = new Scanner(System.in);
        int height = s.nextInt();
        array = new char[height][(height+(height-1))];  // высота и ширина по символу # в центре
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j >= (height-1-i) && j <= (height-1+i)) {  //находим в центре символ #, двигаемся по циклу
                    array[i][j] = '#';
                }
                else {
                    array[i][j] = ' ';
                }
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
