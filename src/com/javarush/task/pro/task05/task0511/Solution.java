package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите коллиство строк N: ");
        int N = scanner.nextInt();   // считываем число которое будет являться кол-вом строк массива
        multiArray = new int[N][];  //  обьявляем массив где N - введенное число

        for (int i = 0; i < N; i++) {    // цикл по строкам который ввел пользователь
            int rowLength = scanner.nextInt();  //считываем следующее число, которое означает кол-во хранящися чисел в строке
            multiArray[i] = new int [rowLength];  // заносим в цикл эти числа
        }

        for (int i = 0; i < multiArray.length; i++) {    // цикл для вывода результата на экран
            for (int j = 0; j < multiArray[i].length; j++) {
                System.out.print(multiArray[i][j]);
            }
            System.out.println();
        }
    }
}
