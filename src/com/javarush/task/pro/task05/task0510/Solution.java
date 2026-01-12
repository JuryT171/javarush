package com.javarush.task.pro.task05.task0510;

/* 
Треугольный массив
*/

public class Solution {

    public static int[][] result = new int[10][];

    public static void main(String[] args) {
        //напишите тут ваш код
        int[][] array = new int[10][]; //  создали массив
        array[0] = new int[1];
        array[1] = new int[2];
        array[2] = new int[3];
        array[3] = new int[4];
        array[4] = new int[5];
        array[5] = new int[6];
        array[6] = new int[7];
        array[7] = new int[8];
        array[8] = new int[9];   //  задали размер
        array[9] = new int[10];

        for (int i = 0; i < array.length; i++) {   // прошлись по длинам строк
            result[i] = new int[i + 1]; // каждая строка увеличивается на 1
        }

        for (int i = 0; i < result.length; i++) {     // заполнили цифрами строки
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = i + j; //  присвоили значение ячейкам
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}

