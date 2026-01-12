package com.javarush.task.pro.task05.task0509;

/* 
Таблица умножения
*/

public class Solution {

    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {
        //напишите тут ваш код
        MULTIPLICATION_TABLE = new int[10][10];  // присваиваем массиву размер
        for (int i = 0; i < MULTIPLICATION_TABLE.length; i++) {  // проходимся по строкам
            for (int j = 0; j < MULTIPLICATION_TABLE.length; j++) {  // проходимся по стоблцам
                MULTIPLICATION_TABLE[i][j] = ((i + 1) * (j + 1));   // сохраняем результат умножения
                System.out.print(MULTIPLICATION_TABLE[i][j] + " ");  // выводим на экран
            }
            System.out.println();  // перенос строки

        }

    }

}
