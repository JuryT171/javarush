package com.javarush.task.jdk13.task34.task3404;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        //напишите тут ваш код
        if (numRings == 1) { // базовый случай
            System.out.println("from " + a + " to " + b);
        } else {
            moveRing(a, c, b, numRings - 1);  //перенос всех колец,кроме большого
            System.out.println("from " + a + " to " + b);
            moveRing(c, b, a, numRings - 1); //перенос остальных колец
        }
    }
}