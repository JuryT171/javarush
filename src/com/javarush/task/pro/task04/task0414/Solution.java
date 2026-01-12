package com.javarush.task.pro.task04.task0414;

import java.util.Scanner;

/* 
Хорошего не бывает много
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        int number = scanner.nextInt();
        do {
            System.out.println( S );
            number --;
        }
        while (number > 0  && number <4);
    }
}