package com.javarush.task.pro.task05.task0507;

import java.util.Scanner;

/* 
Максимальное из N чисел
*/

public class Solution {
    public static int[] array;  // создан массив

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();    //  числа с клавиатуры будут попадать в переменную N
        array = new int [N];   // заполняем массив числами с клавиатуры

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();     //  присваиваем введенные числа с клавиатуры
        }
        int max = array[0];   // вводим переменную  макс с индексом 0
        for (int i = 1; i < array.length; i++) {
            if (array [i] > max)   // счетчик проверят если есть числа больше чем число с индексом 0 то оно записывается как максимальное
                max = array[i];
        }
        System.out.println(max);
    }
}
