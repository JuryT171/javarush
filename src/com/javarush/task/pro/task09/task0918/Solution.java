package com.javarush.task.pro.task09.task0918;

/* 
Поработаем со StringBuilder
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Учиться, учиться и еще раз учиться! ";

        System.out.println(addTo(string, new String[]{"Под ", "лежачий ", "камень ", "вода ", "не ", "течет"}));
        System.out.println(replace(string, ", ", 16, 27));
    }

    public static StringBuilder addTo(String string, String[] strings) {
        //напишите тут ваш код
        StringBuilder builder = new StringBuilder(string);   // создаем буилдер из строки стринг
        int count = 0;  // счетчик
        while (count < strings.length) {   //  пробегаемся по массиву строк
            builder.append(strings[count]);   //  заносим в буилдер строки массива
            count++;
        }
        return builder;
    }

    public static StringBuilder replace(String string, String str, int start, int end) {
        //напишите тут ваш код
        StringBuilder builder = new StringBuilder(string);
        builder.replace(start,end,str);  //  заменаем часть строки
        return builder;
    }
}
