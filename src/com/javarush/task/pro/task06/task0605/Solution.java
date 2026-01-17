package com.javarush.task.pro.task06.task0605;

/* 
Правильный порядок
*/

public class Solution {

    public static void main(String[] args) {
        int[] array = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        printArray(array);
        reverseArray(array);
        printArray(array);
    }

    public static void reverseArray(int[] array) {
        //напишите тут ваш код
        int left = 0;   // переменная начало слева
        int right = array.length - 1;   // переменная начало справа(длина - 1)

        while (left < right) {   // цикл пока значения не встрется в середине
            int temp = array[left];   // временная переменная сохраняем значение сначала массива
            array[left] = array[right];  // присваиваем значению слева значение с конца
            array[right] = temp;   // присваиваем значение сконца во временную
            left++;  // cчетчики
            right--;
        }

    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
