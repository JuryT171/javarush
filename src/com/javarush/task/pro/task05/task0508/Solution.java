package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        strings = new String[6]; //  создаем массив 6 строк
        //напишите тут ваш код
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.nextLine();  // перебираем массив записывая в него строки
        }

        // Ищем и "удаляем" (заменяем на null) одинаковые строки в массиве.
        for (int i = 0; i < strings.length; i++) {
            String currentString = strings[i];  // Берем текущую строку для сравнения.
            for (int j = i + 1; j < strings.length; j++) {   // Перебираем оставшиеся строки в массиве
                if (currentString == null) {  //  если встречается пустые строки
                    continue;   // Если текущая строка уже равна null, то нет смысла ее сравнивать с другими.
                }
                if (currentString.equals(strings[j])){    // Сравниваем текущую строку с каждой последующей строкой в массиве.
                    strings[j] = null;    // Если строки одинаковые, заменяем обе строки на null.
                    strings [i] = null;
                }
            }
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}
      
    

