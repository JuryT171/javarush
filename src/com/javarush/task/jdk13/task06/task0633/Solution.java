package com.javarush.task.jdk13.task06.task0633;

/* 
Вырезаем середину
*/

public class Solution {
    public static char[][] chars = {
            {'a', 'b', 'c', 'd', 'e', 'f'},
            {'j', 'h', 'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p', 'q', 'r'},
            {'s', 't', 'u', 'v', 'w', 'x'}};

    public static void main(String[] args) {
        printArray();

        //напишите тут ваш код
        for (int i = 1; i < chars.length - 1; i++) {   // i=1  j=1 - исключаем первую и последнюю строку/столбец
            for (int j = 1; j < chars[i].length - 1; j++) {  //  исключаем символы первые и последние
                chars[i][j] = '-';
            }
        }

        printArray();
    }

    private static void printArray() {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
