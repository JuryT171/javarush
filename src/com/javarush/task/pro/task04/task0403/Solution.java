package com.javarush.task.pro.task04.task0403;

import java.sql.SQLOutput;
import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        boolean isEnter = false;
        while (!isEnter) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                sum = sum + number;
            } else if (sc.hasNextLine())
            {
                String line = sc.nextLine();

                if (line.equals("ENTER"))
                {
                    isEnter = true;
                }
            }

        }
        System.out.println(sum);

    }
}