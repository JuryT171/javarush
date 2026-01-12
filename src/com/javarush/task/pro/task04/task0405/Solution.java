package com.javarush.task.pro.task04.task0405;

/* 
Незаполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int a = 0;
        while (a < 10) {     // строки
            int b = 0;    // столбцы
            System.out.print("Б");  //  первая строка
            while (b < 18) {   //    столбцы
                if (a == 0 || a == 9)    //  если 1 и последние строки
                    System.out.print("Б");
                else
                    System.out.print(" ");
                b++;
            }
            System.out.println("Б");
            a++;
        }

    }
}