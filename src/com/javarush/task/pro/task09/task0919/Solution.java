package com.javarush.task.pro.task09.task0919;

/* 
Разворот строки
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Ходит кот задом наперед";
        System.out.println(string);
        System.out.println(reverseString(string));
    }

    public static String reverseString(String string) {
        //напишите тут ваш код
        StringBuilder builder = new StringBuilder(string);  // создаем буилдер со строкой string
        builder.reverse();  // переворачиваем текст
        String result = builder.toString();  // переводим к типу стринг
        return result;
    }
}
