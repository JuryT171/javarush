package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // создаем считывание вводимых чисел
        int[] array = new int[N];   // создаем массив в которм будут храниться числа

        // Заполняем массив значениями, введенными с консоли.
        // Цикл for проходит по каждому элементу массива.

        for (int i = 0; i < array.length; i++) {  //  принимаем числа на ввод, колличество меньше длины массива
            array[i] = scanner.nextInt();
        }
        // Теперь массив array заполнен N целыми числами, введенными пользователем.
        // Проверяем, является ли число N четным.

        if (N % 2 == 0) {   // если число четное
            // Если N четное, выводим элементы массива в обратном порядке.
            // Цикл for начинается с последнего элемента массива (array.length - 1) и идет до первого (индекс 0).

            for (int reverse = ((array.length) - 1); reverse >= 0; reverse--) // счетчик реверса, начинаем с конца
            {
                System.out.println(array[reverse] + " "); // выводим на экран числа с конца если N четное
            }
        } else {
            // Если N нечетное, выводим элементы массива в прямом порядке.
            // Цикл for проходит по каждому элементу массива от начала до конца.

            for (int straight = 0; straight < array.length; straight++) { // если длина массива N нечетная выводим попорядку
                System.out.println(array[straight] + " ");
            }
        }

    }
}
