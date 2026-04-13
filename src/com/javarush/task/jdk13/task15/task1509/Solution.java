package com.javarush.task.jdk13.task15.task1509;

/* 
Значения по умолчанию
*/

public class Solution {
    int intVar;
    double doubleVar;
    Double DoubleVar;
    boolean booleanVar;
    Object ObjectVar;
    Exception ExceptionVar;
    String StringVar;

    public static void main(String[] args) {
        Solution obj = new Solution(); //  создаем объект,чтобы получить доступ к полям
        System.out.println(obj.intVar);
        System.out.println(obj.doubleVar);
        System.out.println(obj.DoubleVar);
        System.out.println(obj.booleanVar);
        System.out.println(obj.ObjectVar);
        System.out.println(obj.ExceptionVar);
        System.out.println(obj.StringVar);
    }
}
