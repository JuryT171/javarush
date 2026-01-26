package com.javarush.task.pro.task05.task0516;

import java.util.Arrays;

/* 
Заполняем массив
*/

public class Solution {

    public static int[] array = new int[20];
    public static int valueStart = 10;
    public static int valueEnd = 13;

    public static void main(String[] args) {
        //напишите тут ваш код
        int middle = array.length/2;  // создаем временную переменную для середины
        if (array.length%2 == 0){  // если длина массива четная
            Arrays.fill(array,0,middle,valueStart);   //  заполняем от 1 значения до середины 10
            Arrays.fill(array,middle,array.length,valueEnd);}   //  заполняем от середины  до конца 13
            else {   // если длина массива нечетная
                Arrays.fill(array,0,middle+1,valueStart);  // заполняем 10 от 1го значения до середины
                Arrays.fill(array,middle+1,array.length,valueEnd);  // заполняем 13 от середины  до конца

        }
        System.out.println(Arrays.toString(array));
    }
}
