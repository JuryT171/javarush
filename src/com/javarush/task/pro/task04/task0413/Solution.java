package com.javarush.task.pro.task04.task0413;

/* 
Рисуем треугольник
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for(int i = 1;i<=10;i++){  //  это строки колличество
            int eight_count = 0+i;  // счетчик восьмерок
            for(int j=0;j<eight_count;j++) // колличество выводимых восьмерок
                System.out.print("8");
            System.out.println(); // перенос строки
        }


    }
}