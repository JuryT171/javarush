package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        //напишите тут ваш код
        String binaryNumber = "";
        if (decimalNumber <= 0) {
            return binaryNumber;
        }

        StringBuilder binary = new StringBuilder();
         while (decimalNumber!=0){
             binary.insert(0, decimalNumber % 2);  // Получаем остаток от деления на 2, вставляем цифру в начало
             decimalNumber /= 2;    //  делим числа на 2, переходим к следующему разряду
         }
        return binary.toString();

    }

    public static int toDecimal(String binaryNumber) {
        //напишите тут ваш код
        if (binaryNumber == null || binaryNumber.isEmpty()) {   // Если строка равна ноль или пустая, возвращаем 0.
            return 0;
        }
        int decimalNumber = 0;  // хранение десятичного числа
        int power = 0;  // хранение 2й степени

        for (int i = binaryNumber.length() - 1; i >= 0; i--) {   //  идем от конца к началу
            char c = binaryNumber.charAt(i);  //  получаем символ цифры
            if (c == '1') {
                decimalNumber += Math.pow(2, power); // если цифра = 1 ,прибавляем 2 в степени power если текущий символ '1'
            } else if (c != '0') {
                return 0; // Если в строке не '0' и не '1', возвращаем 0
            }
            power++; // Увеличиваем степень двойки
        }

        return decimalNumber;
    }
}


