package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int second_min = Integer.MAX_VALUE;
        int count = 0;
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();  // читаем вводимые числа

            if (x < min) {
                second_min = min;  // Прежнее минимальное число min1 становится вторым минимальным числом min2
                min = x;
            }    // Текущее число x становится новым минимальным числом min1
            else if (x > min && second_min > x) {    // Иначе, если х больше минимального, но меньше второго минимального
                second_min = x;
            }

            count++;
        }
        if (count < 2) {
            System.out.println("Введите второе число");}
            else System.out.println(second_min);
        }

    }
