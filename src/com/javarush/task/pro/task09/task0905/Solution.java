package com.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        //напишите тут ваш код
        int octalNumber = 0;  //  переменная для хранения восьмеричного числа
        int powerOfTen = 1;   // перемнная для хранения степени в десятчиной степени

        if (decimalNumber<=0)   // если десятичное число равно 0 то и восьмеричное равно 0
            return 0;

        while (decimalNumber>0){
            int remainder = decimalNumber % 8;  //  остаток от деления на  8
            octalNumber = octalNumber + remainder*powerOfTen;  //Добавляем остаток, умноженный на текущую степень десятичной степени, к восьмеричному числу.
            decimalNumber = decimalNumber / 8;   //decimalNumber /= 8;   Делим десятичное число на 8
            powerOfTen = powerOfTen*10;  //  Увеличиваем степень десятки для следующей восьмеричной цифры
        }
        return octalNumber;  //  возвращаем восьмеричное число
    }

    public static int toDecimal(int octalNumber) {
        //напишите тут ваш код
        int decimalNumber = 0;  //  переменная для десятичного числа
        int powerOfEight = 1;   //  переменная для хранения степени

        while (octalNumber>0){
            int remainder = octalNumber % 10;  //  остаток от деления на 10, последняя цифра
            decimalNumber = decimalNumber + remainder*powerOfEight;  //  последняя цифра 8чного числа, умножается на текущую степень
            octalNumber = octalNumber / 10;   //octalNumber /= 10;
            powerOfEight = powerOfEight*8;  //увеличиваем степень
        }

        return decimalNumber;
    }
}
