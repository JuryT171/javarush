package com.javarush.task.pro.task04.task0415;

import java.util.Scanner;

/* 
Площадь круга
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        double pi = 3.14;
        
        
        int S = (int) (pi * radius * radius);
        
        System.out.println(S);
    }
}