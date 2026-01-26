package com.javarush.task.pro.task05.task0517;

import java.util.Arrays;

/* 
Делим массив
*/

public class Solution {

    public static int[][] result = new int[2][];
    public static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static void main(String[] args) {
        //напишите тут ваш код
        int middle = array.length/2;   //  середина
        if (array.length%2>0){   // если длина нечетная
            result[0] = Arrays.copyOfRange(array,0,middle+1);   //1й массив от 1 до середины включительно
            result[1] = Arrays.copyOfRange(array,middle+1,array.length);}   //2й массив от середины доконца
            else {
                result[0] = Arrays.copyOfRange(array,0,middle);   // иначе до середины
                result[1] = Arrays.copyOfRange(array,middle,array.length);
            }
        System.out.println(Arrays.deepToString(result));
        }

    }

