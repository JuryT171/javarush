package com.javarush.task.jdk13.task23.task2301;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static void main(String[] args) {

    }

    public static Solution[] getTwoSolutions() {
        Solution solution = new Solution();  // создаем 1й обьект
        solution.innerClasses[0] = new InnerClass(); //заполняем
        solution.innerClasses[1] = new InnerClass();

        Solution solution2 = new Solution(); //2й обьект
        solution2.innerClasses[0] = new InnerClass(); // заполняем
        solution2.innerClasses[1] = new InnerClass();

        Solution[] result = new Solution[2]; // заполняем массив обьектами
        result[0] = solution;
        result[1] = solution2;

        return result;
    }

    public static class InnerClass {
    }
}
